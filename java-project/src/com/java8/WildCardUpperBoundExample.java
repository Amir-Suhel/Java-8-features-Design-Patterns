package com.java8;

import java.util.ArrayList;
import java.util.List;

public class WildCardUpperBoundExample {

	private static void printElements(List<? extends Number> list) {
		for (Object obj : list) {
			System.out.print(obj + ",");
		}
	}

	public static void main(String[] args) {

		List<Integer> list1 = new ArrayList<>();
		list1.add(1);
		list1.add(2);
		list1.add(3);

		printElements(list1);
		System.out.println();

		List<Double> list2 = new ArrayList<>();
		list2.add(1.0);
		list2.add(2.3);
		list2.add(3.8);

		printElements(list2);
		System.out.println();

		List<String> list3 = new ArrayList<>();
		list3.add("string1");
		list3.add("string2");

	}

}
