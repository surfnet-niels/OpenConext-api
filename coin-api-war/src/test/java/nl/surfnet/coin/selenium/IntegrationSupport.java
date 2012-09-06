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

package nl.surfnet.coin.selenium;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Base class for integration tests
 * 
 */
public class IntegrationSupport {

  protected Logger LOG = LoggerFactory.getLogger(IntegrationSupport.class);

  public static final String URL_UNDER_TEST = withEndingSlash(System
      .getProperty("selenium.test.url", "http://localhost:8095"));

  private static String withEndingSlash(String path) {
    return path.endsWith("/") ? path : path + "/";
  }
}