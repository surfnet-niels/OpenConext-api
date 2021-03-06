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

package nl.surfnet.coin.api.client.domain;

import java.util.ArrayList;
import java.util.List;

import org.codehaus.jackson.annotate.JsonIgnore;

/**
 * 
 *
 */
@SuppressWarnings("serial")
public class PersonEntry extends AbstractEntry {

  private Person entry;

  public PersonEntry() {
  }

  public PersonEntry(Person person, int pageSize, int offset, String sortBy, int totalResults) {
    this.entry = person;
    setStartIndex(0);
    setSorted(false);
    setTotalResults(1);
    setFiltered(false);
    setItemsPerPage(1);
    setUpdatedSince(false);
  }

  /**
   * @return the entry
   */
  public Person getEntry() {
    return entry;
  }

  /**
   * @param entry
   *          the entry to set
   */
  public void setEntry(Person entry) {
    this.entry = entry;
  }

  /* (non-Javadoc)
   * @see nl.surfnet.coin.api.client.domain.AbstractEntry#getEntrySize()
   */
  @Override
  public int getEntrySize() {
    return this.entry != null ? 1 : 0;
  }

  /* (non-Javadoc)
   * @see nl.surfnet.coin.api.client.domain.AbstractEntry#getEntryCollection()
   */
  @Override
  @JsonIgnore
  public List getEntryCollection() {
    ArrayList<Person> list = new ArrayList<Person>();
    if (this.entry != null) {
      list.add(entry);
    }
    return list;
  }

  /* (non-Javadoc)
   * @see nl.surfnet.coin.api.client.domain.AbstractEntry#sortEntryCollection(java.lang.String)
   */
  @Override
  @JsonIgnore
  public void sortEntryCollection(String sort) {
    // we can't sort
    
  }

  /* (non-Javadoc)
   * @see nl.surfnet.coin.api.client.domain.AbstractEntry#setEntryCollection(java.util.List)
   */
  @Override
  @JsonIgnore
  public void setEntryCollection(List entryCollection) {
  }
  

}
