package com.immutable;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

class ImmutableClass {
	private final int value;
	private final String name;
	private final Date date; // Mutable field
	private final List<String> tokens;

	public ImmutableClass(int value, String name, Date date, List<String> tokens) {
		this.value = value;
		this.name = name;
		this.date = new Date(date.getTime()); // Create a defensive copy
		this.tokens = tokens;
	}

	public int getValue() {
		return value;
	}

	public String getName() {
		return name;
	}

	public Date getDate() {
		return new Date(date.getTime()); // Return a copy instead of the original
	}

	public List<String> getTokens() {
		return new ArrayList<>(tokens);
	}

	@Override
	public String toString() {
		return "ImmutableClass [value=" + value + ", name=" + name + ", date=" + date + ", tokens=" + tokens + "]";
	}
}

public class ImmutableClassExample {

	@SuppressWarnings("deprecation")
	public static void main(String[] args) {
		List<String> tokens = new ArrayList<>();
		tokens.add("token1");
		ImmutableClass instance1 = new ImmutableClass(1, "amir", new Date(), tokens);
		System.out.println(instance1);

		instance1.getTokens().add("token2");

		instance1.getDate().setDate(30);

		System.out.println(instance1);

	}

}
