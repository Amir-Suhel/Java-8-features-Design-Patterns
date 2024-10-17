package com.design.patterns;

class Singleton {
	static Singleton instance = null;
	private int id;
	private String name;

	private Singleton(int id, String name) {
		this.id = id;
		this.name = name;
	}

	public static Singleton getInstance(int id, String name) {
		if (instance == null) {
			instance = new Singleton(id, name);
		}
		return instance;
	}

	public String toString() {
		return "[id: " + id + ", name: " + name + "]";
	}
}

public class SingletonDesignPattern {

	public static void main(String[] args) {
		Singleton obj1 = Singleton.getInstance(1, "amir");
		Singleton obj2 = Singleton.getInstance(2, "raman");

		System.out.println(obj1);
		System.out.println(obj2);

	}

}
