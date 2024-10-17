package com.java8;

interface I {
	int salary = 10;

	void fun();
}

class InterfaceE implements I {
	

	@Override
	public void fun() {
		System.out.println("Hello I am implemented");
	}

}

class SingleRes {
	static SingleRes instance = null;
	private int id;
	private String name;
	
	private SingleRes(int id, String name) {
		this.id = id;
		this.name= name;
	}
	
	static SingleRes getInstance(int id, String name) {
		if(instance == null) {
			instance = new SingleRes(id, name);
		}
		return instance;
	}
	
	public String toString() {
		return "[id: " + this.id + ", name: " + name + "]";
	}
}

public class INterfaceExampl {
	public static void main(String [] args) {
		InterfaceE obj = new InterfaceE();
		obj.fun();
		System.out.println(obj.salary);
		
		SingleRes s1 = SingleRes.getInstance(1, "amir");
		SingleRes s2 = SingleRes.getInstance(2, "suhel");
		
		System.out.println("s1: " + s1.toString());
		System.out.println("s2: " + s2.toString());
	}

}
