package com.eaj.ccoc.home;

import org.apache.commons.lang.WordUtils;

public class Person {

	private final String name;

	public Person(String name) {
		this.name = name;
	}

	public String toString() {
		return format(name);
	}

	private String format(String _name) {
		return WordUtils.capitalizeFully(_name);
	}

}
