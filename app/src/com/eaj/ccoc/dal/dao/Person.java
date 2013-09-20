package com.eaj.ccoc.dal.dao;

import org.apache.commons.lang.WordUtils;

public class Person {

	private final String firstName;
	private final String lastName;
	private final UserInfo userInfo;

	public Person(String firstName, String lastName, UserInfo userInfo) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.userInfo = userInfo;
	}

	public String toString() {
		return WordUtils.capitalizeFully(fullName());
	}

	private String fullName() {
		return String.format("%s %s", firstName, lastName);
	}

	public UserInfo getUserInfo() {
		return userInfo;
	}

}
