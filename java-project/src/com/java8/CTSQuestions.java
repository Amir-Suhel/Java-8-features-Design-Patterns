package com.java8;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

//class Example implements Comparable<Example> {
//	String name;
//	int age;
//
//	Example(String name, int age) {
//		this.name = name;
//		this.age = age;
//	}
//
//	@Override
//	public int compareTo(Example o) {
//		return this.name.compareTo(o.name);
//	}
//
//	public String toString() {
//		return "[name: " + name + ", age: " + age + "]";
//	}
//
//}
class Example {
	String name;
	int age;
	long salary;

	Example(String name, int age, long salary) {
		this.name = name;
		this.age = age;
		this.salary = salary;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public long getSalary() {
		return salary;
	}

	public void setSalary(long salary) {
		this.salary = salary;
	}

	public String toString() {
		return "[name: " + name + ", age: " + age + ", salary: " + salary + "]";
	}

}

public class CTSQuestions {

	static String checkValidString(String str) throws Exception {
		if (str.length() < 5) {
			throw new Exception("word length is less than 3");
		}
		return str.toUpperCase();
	}

	public static void main(String[] args) {

		List<String> str = Arrays.asList("amir", "ami", "suhel", "raman", "abc");
		List<String> collect = str.stream().map(word -> {
			try {
				return checkValidString(word);
			} catch (Exception e) {
				System.out.println(e.getMessage());
				return "";
			}
		}).filter(word -> !word.isEmpty()).collect(Collectors.toList());
		System.out.println(collect);

//		List<List<Integer>> list = Arrays.asList(
//                Arrays.asList(1, 3, 2),
//                Arrays.asList(9, 7),
//                Arrays.asList(6, 12, 8) );
//		
//		//list.stream().flatMap(e -> e.stream()).distinct().collect(Collectors.toList());
//		
//		List<Integer> collect = list.stream().flatMap(e -> e.stream().sorted()).collect(Collectors.toList());
//		System.out.println(collect);
//		
//		List<Integer> ls = Arrays.asList(1,2,3,4,5);
//		
//		Stream.iterate(1, n -> n + 1).limit(10).forEach(e -> System.out.println(e));
//
//		List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
//		Map<Boolean, List<Integer>> map = list.stream().collect(Collectors.groupingBy(e -> e % 2 == 0));
//		List<Integer> evenList = map.get(true);
//		List<Integer> oddList = map.get(false);
//		System.out.println("even: " + evenList);
//		System.out.println("odd: " + oddList);
		/**
		 * seccond way
		 */ 
		// Map<Boolean, List<Integer>> collect =
		// list.stream().collect(Collectors.partitioningBy(e -> e % 2 == 0));

//		List<Example> examples = Arrays.asList(new Example("amir", 20, 5000L), new Example("suhel", 19, 1000L),
//				new Example("amir", 22, 2000L), new Example("raman", 25, 15000L));
		// examples.stream().sorted().forEach(e -> System.out.println(e));
		// examples.stream().sorted((a, b) -> a.getAge() - b.getAge()).forEach(e ->
		// System.out.println(e));

//		examples.stream().sorted(Comparator.comparing(Example::getName).thenComparingLong(Example::getSalary))
//				.forEach(e -> System.out.println(e));

	}

}
