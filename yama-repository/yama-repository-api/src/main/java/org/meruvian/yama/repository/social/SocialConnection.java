/**
 * Copyright 2014 Meruvian
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0 
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.meruvian.yama.repository.social;

import org.meruvian.yama.repository.DefaultPersistence;
import org.meruvian.yama.repository.user.User;

/**
 * @author Dian Aditya
 * 
 */
public interface SocialConnection extends DefaultPersistence {
	public enum Provider {
		FACEBOOK, GOOGLE, LINKEDIN, YAHOO, TWITTER, FUPEI;
	}
	
	static final String DEFAULT_ID = "DEFAULT";

	User getUser();

	Provider getProvider();

	String getProviderUserId();

	int getRank();

	String getDisplayName();

	String getProfileUrl();

	String getImageUrl();

	String getAccessToken();

	String getSecret();

	String getRefreshToken();

	Long getExpireTime();
}
