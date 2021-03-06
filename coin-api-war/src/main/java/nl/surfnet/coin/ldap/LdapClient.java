/*
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */
package nl.surfnet.coin.ldap;

import java.util.Collection;
import java.util.List;

import nl.surfnet.coin.api.client.domain.Person;

/**
 * Interface to Ldap where all persons are stored.
 * 
 */
public interface LdapClient {

  public static final String URN_IDENTIFIER = "urn:collab:person:";

  /**
   * 
   * Find the Person in the LDAP. The identifier can either be the urn
   * (urn:collab:person:nl.myuniversity:s123456) or the persistent identifier (hashed urn specific for the SP).
   * 
   * @param identifier
   *          unqiue identifier of the Person
   * @return Person object
   */
  Person findPerson(String identifier);

  /**
   * 
   * Find the Persons in the LDAP. The identifier can either be the urn
   * (urn:collab:person:nl.myuniversity:s123456) or the persistent identifier (hashed urn specific for the SP).
   * 
   * @param identifier
   *          unqiue identifier of the Person
   * @return Persons objects
   */
  List<Person> findPersons(Collection<String> identifiers);
}
