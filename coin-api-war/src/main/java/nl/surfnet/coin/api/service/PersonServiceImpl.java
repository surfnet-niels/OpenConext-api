/*
 * Copyright 2012 SURFnet bv, The Netherlands
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package nl.surfnet.coin.api.service;

import java.util.Collection;
import java.util.List;

import javax.annotation.Resource;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.collections.Transformer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import nl.surfnet.coin.api.client.domain.GroupMembersEntry;
import nl.surfnet.coin.api.client.domain.Person;
import nl.surfnet.coin.api.client.domain.PersonEntry;
import nl.surfnet.coin.janus.domain.ARP;
import nl.surfnet.coin.ldap.LdapClient;
import nl.surfnet.coin.teams.service.impl.ApiGrouperDao;

@Component(value = "ldapService")
public class PersonServiceImpl implements PersonService {

  @Autowired
  private LdapClient ldapClient;

  @Resource(name = "apiGrouperDao")
  private ApiGrouperDao apiGrouperDao;

  @Resource(name = "janusClientDetailsService")
  private OpenConextClientDetailsService clientDetailsService;

  private PersonARPEnforcer arpEnforcer = new PersonARPEnforcer();

  @Override
  public PersonEntry getPerson(String userId, String onBehalfOf, String spEntityId) {
    Person person = ldapClient.findPerson(userId);

    ARP arp = clientDetailsService.getArp(spEntityId);
    person = arpEnforcer.enforceARP(person, arp);

    return new PersonEntry(person, 1, 0, null, 1);
  }

  @SuppressWarnings("unchecked")
  @Override
  public GroupMembersEntry getGroupMembers(String groupId, String onBehalfOf, String spEntityId, Integer count,
                                           Integer startIndex, String sortBy) {

    /*
     * first get all members from grouper. Note that we don't support sortBy but
     * we do support count and startIndex. See
     * https://jira.surfconext.nl/jira/browse/BACKLOG-438
     */
    GroupMembersEntry entry = apiGrouperDao.findAllMembers(groupId, startIndex, count);
    List<Person> persons = entry.getEntry();
    if (!CollectionUtils.isEmpty(persons)) {
      Collection<String> identifiers = CollectionUtils.collect(persons, new Transformer() {
        @Override
        public Object transform(Object input) {
          return ((Person) input).getId();
        }
      });
      // Now enrich the information
      List<Person> enrichtedInfo = ldapClient.findPersons(identifiers);
      ARP arp = clientDetailsService.getArp(spEntityId);
      for (Person person : enrichtedInfo) {
        person.setVoot_membership_role(getVootMembersShip(person.getId(), persons));
        arpEnforcer.enforceARP(person, arp);
      }
      entry.setEntry(enrichtedInfo);
    }
    return entry;
  }

  private String getVootMembersShip(String id, List<Person> persons) {
    for (Person person : persons) {
      if (person.getId().equals(id)) {
        return person.getVoot_membership_role();
      }
    }
    throw new RuntimeException("No person found with identifier ('" + id + "')");
  }

  public void setArpEnforcer(PersonARPEnforcer arpEnforcer) {
    this.arpEnforcer = arpEnforcer;
  }
}