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

package nl.surfnet.coin.api;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.Proxy;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.scribe.model.Token;

import nl.surfnet.coin.api.client.InMemoryOAuthRepositoryImpl;
import nl.surfnet.coin.api.client.OAuthEnvironment;
import nl.surfnet.coin.api.client.OAuthRepository;
import nl.surfnet.coin.api.client.OAuthVersion;
import nl.surfnet.coin.api.client.OpenConextOAuthClientImpl;
import nl.surfnet.coin.api.client.domain.Person;

import static org.junit.Assert.assertEquals;

public class CorsHeaderTestIntegration extends ImplicitGrantSelenium {

  @Before
  public void login() throws Exception {
    super.implicitGrant();
  }

  @Test
  public void corsHeader() throws Exception {

  }

}
