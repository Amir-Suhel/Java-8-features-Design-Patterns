package com.java8;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.stream.Collectors;

class Product {

	private int id;
	private String name;
	private int price;

	public Product(int id, String name, int price) {
		this.id = id;
		this.name = name;
		this.price = price;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	@Override
	public String toString() {
		return "Product [id=" + id + ", name=" + name + ", price=" + price + "]";
	}

}

public class StreamExampleII {

	public static void main(String[] args) {
		List<Product> list = new ArrayList<>();
		list.add(new Product(1, "Smarthone", 10000));
		list.add(new Product(2, "Refrigerator", 15000));
		list.add(new Product(3, "Bike", 125000));
		list.add(new Product(5, "Iron", 1000));
		list.add(new Product(6, "Charger", 500));

//		List<Product> collect = list.stream().filter(e -> e.getPrice() > 1000 && e.getPrice() < 125000).collect(Collectors.toList());
//		collect.forEach(e -> System.out.println(e));
//		
//		List<Integer> collect2 = list.stream().filter(e -> e.getPrice() < 15000).map(p -> p.getId()).collect(Collectors.toList());
//		System.out.println(collect2);
//		
//		Map<Integer, String> map = list.stream().collect(Collectors.toMap(p -> p.getId(), p -> p.getName()));
//		System.out.println(map);
//		
//		List<Product> collect3 = list.stream().sorted((p1, p2) -> p1.getPrice() - p2.getPrice()).collect(Collectors.toList());
//		System.out.println(collect3);
//		
//		List<Product> collect4 = list.stream().sorted((p1, p2) -> p2.getPrice() - p1.getPrice()).collect(Collectors.toList());
//		System.out.println(collect4);
//		

		String str = "AMERICAIA";
		
		Map<Character, Long> sortedMap = new LinkedHashMap<>();

		str.chars().mapToObj(c -> (char) c)
				.collect(Collectors.groupingBy(c -> c, TreeMap::new, Collectors.counting())).entrySet().stream()
				.sorted(Map.Entry.<Character, Long>comparingByValue().thenComparing(e -> e.getKey()))
				.forEachOrdered(e -> sortedMap.put(e.getKey(), e.getValue()));

		
	}

}
