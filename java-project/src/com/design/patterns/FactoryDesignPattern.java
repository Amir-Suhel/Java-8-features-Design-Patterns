package com.design.patterns;

interface Product {
	void setName();
}

class Bike implements Product {

	@Override
	public void setName() {
		System.out.println("Product name is Bike");
	}
	
}

class Car implements Product {

	@Override
	public void setName() {
		System.out.println("Product name is Car");
	}
	
}

interface Factory {
	Product factoryMethod();
}

class FactoryA implements Factory {

	@Override
	public Product factoryMethod() {
		return new Bike();
	}
	
}

class FactoryB implements Factory {

	@Override
	public Product factoryMethod() {
		return new Car();
	}
	
}

public class FactoryDesignPattern {

	public static void main(String[] args) {
		Factory factoryA = new FactoryA();
		Product productA = factoryA.factoryMethod();
		productA.setName();
		
		Factory factoryB = new FactoryB();
		Product productB = factoryB.factoryMethod();
		productB.setName();
	}

	
	
}
