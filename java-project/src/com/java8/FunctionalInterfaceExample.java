package com.java8;

interface Draw {

	void draw();
}

interface Operation {
	int sum(int a, int b);
}

interface FindSum {
	int sum(int[] arr);
}

public class FunctionalInterfaceExample {

	public static void main(String[] args) {

		Draw draw = () -> {
			System.out.println("drawing");
		};

		draw.draw();

		Draw obj = new Draw() {

			@Override
			public void draw() {
				System.out.println("draw without lambda expression.");

			}

		};

		obj.draw();

		Operation op = (a, b) -> a + b;

		System.out.println(op.sum(2, 3));
		System.out.println(op.sum(5, 6));

		FindSum findSum = (arr) -> {
			int sum = 0;
			for (int i = 0; i < arr.length; i++) {
				sum += arr[i];
			}
			return sum;
		};

		System.out.println(findSum.sum(new int[] { 1, 2, 3, 4, 5 }));

	}

}
