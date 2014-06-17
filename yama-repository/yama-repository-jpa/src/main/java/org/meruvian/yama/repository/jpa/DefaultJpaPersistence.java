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
package org.meruvian.yama.repository.jpa;

import javax.persistence.Embedded;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

import org.hibernate.annotations.GenericGenerator;
import org.meruvian.yama.repository.DefaultPersistence;

/**
 * @author Dian Aditya
 * 
 */
@MappedSuperclass
public class DefaultJpaPersistence implements DefaultPersistence {
	protected String id;
	protected JpaLogInformation logInformation = new JpaLogInformation();

	@Id()
	@GeneratedValue(generator = "system-uuid")
	@GenericGenerator(name = "system-uuid", strategy = "uuid2")
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	@Embedded
	public JpaLogInformation getLogInformation() {
		return logInformation;
	}

	public void setLogInformation(JpaLogInformation logInformation) {
		this.logInformation = logInformation;
	}
}
