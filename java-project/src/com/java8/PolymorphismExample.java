package com.java8;

class A {
	void fun(int a) {
		System.out.println("A function");
	}

	int fun(int a, int b) {
		return a + b;
	}
}

class B extends A {
	void fun(double a) {
		System.out.println("oveeriding");
	}

	int fun(int a, int b) {
		return a + b + 2;
	}
}

public class PolymorphismExample {

	public static void main(String[] args) {
		B obj = new B();
		obj.fun(5.000);
		System.out.println(obj.fun(2, 5));

	}

}
