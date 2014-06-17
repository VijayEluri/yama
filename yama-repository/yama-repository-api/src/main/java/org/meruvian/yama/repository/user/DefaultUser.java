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
package org.meruvian.yama.repository.user;

import org.meruvian.yama.repository.LogInformation;
import org.meruvian.yama.repository.commons.Address;
import org.meruvian.yama.repository.commons.DefaultFileInfo;
import org.meruvian.yama.repository.commons.FileInfo;
import org.meruvian.yama.repository.commons.Name;

/**
 * @author Dian Aditya
 *
 */
public class DefaultUser implements User {
	private String id;
	private String username;
	private String password;
	private String email;
	private Name name = new Name();
	private Address address = new Address();
	private LogInformation logInformation = new LogInformation();
	private FileInfo fileInfo = new DefaultFileInfo();
	
	public DefaultUser() {}
	
	public DefaultUser(User user) {
		this.id = user.getId();
		this.username = user.getUsername();
		this.password = user.getPassword();
		this.email = user.getEmail();
		this.name = user.getName();
		this.address = user.getAddress();
		this.logInformation = user.getLogInformation();
	}
	
	@Override
	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	@Override
	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public Name getName() {
		return name;
	}

	public void setName(Name name) {
		this.name = name;
	}
	
	@Override
	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	@Override
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}
	
	@Override
	public LogInformation getLogInformation() {
		return logInformation;
	}
	
	public void setLogInformation(LogInformation logInformation) {
		this.logInformation = logInformation;
	}

	@Override
	public void update(User user) {
		this.id = user.getId();
		this.logInformation = new LogInformation(user.getLogInformation());
		this.username = user.getUsername();
		this.password = user.getPassword();
		this.email = user.getEmail();
		this.name = new Name(user.getName());
		this.address = new Address(user.getAddress());
	}

	@Override
	public FileInfo getFileInfo() {
		return fileInfo;
	}

	public void setFileInfo(FileInfo fileInfo) {
		this.fileInfo = fileInfo;
	}
}
