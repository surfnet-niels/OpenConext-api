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


import nl.surfnet.coin.api.client.domain.Person;

import java.util.List;

public interface PersonService {

    /**
     * Get the Person
     *
     * @param userId the unique identifier
     * @param loggedInUser {@link String} the unique identifier for the logged in user who performs the request
     * @return the {@link org.opensocial.models.Person}
     */
    Person getPerson(String userId, String loggedInUser);
}