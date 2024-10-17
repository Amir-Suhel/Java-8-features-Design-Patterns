package com.exception;

import java.io.IOException;
import java.nio.file.FileAlreadyExistsException;

class Parent {
	void method1() throws IOException {
		System.out.println("Parent method");
	}
}

class Child extends Parent {
	void method1() throws  FileAlreadyExistsException{
		System.out.println("overriding method");
	}
}

public class OverridinfMethodException {

	public static void main(String[] args) throws FileAlreadyExistsException {
		Child obj = new Child();
		obj.method1();

	}

}
