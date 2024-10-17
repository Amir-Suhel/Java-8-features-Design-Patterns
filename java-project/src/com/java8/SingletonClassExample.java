package com.java8;

class Singleton {
	// Static instance variable
	private static Singleton instance = null;

	// Instance variables
	private int id;
	private String name;

	// Private constructor
	private Singleton(int id, String name) {
		this.id = id;
		this.name = name;
	}

	// Static method to get the singleton instance
	public static Singleton getInstance(int id, String name) {
		if (instance == null) {
			// Create a new instance only if it doesn't exist
			instance = new Singleton(id, name);
		}
		return instance;
	}

	// Getter methods
	public int getId() {
		return id;
	}

	public String getName() {
		return name;
	}
}

public class SingletonClassExample {
	public static void main(String[] args) {
		// Getting singleton instance
		Singleton instance1 = Singleton.getInstance(1, "Amir");

		// Accessing instance variables
		System.out.println("ID: " + instance1.getId());
		System.out.println("Name: " + instance1.getName());

		// Attempting to create another instance
		Singleton instance2 = Singleton.getInstance(2, "Ali");

		// Accessing instance variables of the second instance
		System.out.println("ID: " + instance2.getId());
		System.out.println("Name: " + instance2.getName());

		// Check if both instances are the same
		if (instance1 == instance2) {
			System.out.println("Both instances are the same.");
		} else {
			System.out.println("Instances are different.");
		}
	}

}
