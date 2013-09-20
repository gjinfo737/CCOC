package com.eaj.ccoc.home;

import org.apache.commons.lang.WordUtils;

public class Person {

	private final String firstName;
	private final String lastName;

	public Person(String firstName, String lastName) {
		this.firstName = firstName;
		this.lastName = lastName;
	}

	public String toString() {
		return WordUtils.capitalizeFully(fullName());
	}

	private String fullName() {
		return String.format("%s %s", firstName, lastName);
	}

}
