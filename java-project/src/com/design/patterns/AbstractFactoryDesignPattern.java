package com.design.patterns;

//Products
interface Button {
	void paint();
}

interface CheckBox {
	void paint();
}

//Concrete Products
class WindowButton implements Button {

	@Override
	public void paint() {
		System.out.println("Rendering window button");
	}
}

class MacButton implements Button {

	@Override
	public void paint() {
		System.out.println("Rendering mac button");
	}
}

class WindowCheckBox implements CheckBox {

	@Override
	public void paint() {
		System.out.println("Rendering window checkbox");
	}
}

class MacCheckBox implements CheckBox {

	@Override
	public void paint() {
		System.out.println("Rendering Mack checkbox");
	}
}

//Abstract Factory
interface GUIFactory {
	Button createButton();

	CheckBox createCheckBox();
}

//Concrete Factories
class WindowFactory implements GUIFactory {

	@Override
	public Button createButton() {
		return new WindowButton();
	}

	@Override
	public CheckBox createCheckBox() {
		return new WindowCheckBox();
	}
}

class MacFactory implements GUIFactory {

	@Override
	public CheckBox createCheckBox() {
		return new MacCheckBox();
	}

	@Override
	public Button createButton() {
		return new MacButton();
	}
}

public class AbstractFactoryDesignPattern {

	public static void main(String[] args) {

		GUIFactory windowFactory = new WindowFactory();
		Button windowButton = windowFactory.createButton();
		CheckBox windowCheckBox = windowFactory.createCheckBox();
		windowButton.paint();
		windowCheckBox.paint();

		GUIFactory macFactory = new MacFactory();
		Button macButton = macFactory.createButton();
		CheckBox macCheckBox = macFactory.createCheckBox();
		macButton.paint();
		macCheckBox.paint();

	}

}
