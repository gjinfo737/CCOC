package com.eaj.ccoc.home;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import com.eaj.ccoc.dal.dao.Person;

public class PersonSorter {
	public static void sort(List<Person> persons) {
		Collections.sort(persons, new Comparator<Person>() {
			@Override
			public int compare(Person lhs, Person rhs) {
				return lhs.toString().compareTo(rhs.toString());
			}
		});
	}
}
