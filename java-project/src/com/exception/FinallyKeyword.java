package com.exception;

public class FinallyKeyword {

	static void multiple(int num) {
		try {
			System.out.println("Inside try block");
			int x = num / 0;
//			System.exit(0);
			//return num * 2;
		}catch(ArithmeticException e) {
			System.out.println(e.getMessage());
			//return num / 2;
		}
		finally {
			System.out.println("Finally block executed");
		}
		System.out.println("hslall");
	}
	public static void main(String[] args) {
		multiple(10);
//		System.out.println("result: " + result);

	}

}
