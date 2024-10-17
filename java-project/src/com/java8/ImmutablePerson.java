package com.java8;

import java.util.Date;

public final class ImmutablePerson {
	private final String name;
	private final int age;
	private final Date birthDate;

	// Constructor
	public ImmutablePerson(String name, int age, Date birthDate) {
		this.name = name;
		this.age = age;
		// Perform defensive copy of the mutable Date object
		this.birthDate = new Date(birthDate.getTime());
	}

	// Getter methods
	public String getName() {
		return name;
	}

	public int getAge() {
		return age;
	}

	public Date getBirthDate() {
		// Return a defensive copy of the mutable Date object
		return new Date(birthDate.getTime());
	}

	@Override
	public String toString() {
		return "ImmutablePerson{name='" + name + "', age=" + age + ", birthDate=" + birthDate + '}';
	}

	public static void main(String[] args) {
		Date birthDate = new Date();
		ImmutablePerson person = new ImmutablePerson("Alice", 30, birthDate);

		System.out.println("Before modifying birthDate: " + person);
		// Attempt to modify the birthDate
		birthDate.setTime(birthDate.getTime() + 1000000000L);
		System.out.println("After modifying birthDate: " + person);

		// Attempt to modify the birthDate through getter
		person.getBirthDate().setTime(birthDate.getTime() + 1000000000L);
		System.out.println("After modifying through getter: " + person);
	}
}
