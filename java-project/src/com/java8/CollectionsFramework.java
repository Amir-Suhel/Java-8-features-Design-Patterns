package com.java8;

import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Optional;
import java.util.stream.Collectors;

class Person {
	private int id;
	private String name;

	public Person(int id, String name) {
		super();
		this.id = id;
		this.name = name;
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

	@Override
	public String toString() {
		return "Student [id=" + id + ", name=" + name + "]";
	}

}

public class CollectionsFramework {

	public static void main(String[] args) {
		List<Integer> list = Arrays.asList(1, 2, 3, 4, 5);
		Integer reduce2 = list.stream().reduce(0,  (a, b) -> a + b);
		Optional<Integer> max = list.stream().max((a, b) -> a - b);
		System.out.println(list.stream().min((a, b) -> a - b).get());
		System.out.println("max: " + max.get());
		Collections.sort(list, (a, b) -> b - a);
		System.out.println("llist:" + list);

		Map<Integer, Person> map = new LinkedHashMap<>();
		map.put(10, new Person(1, "amir"));
		map.put(5, new Person(4, "suhel"));
		map.put(7, new Person(3, "raman singh"));

		System.out.println(map);

		Optional<Integer> reduce = map.entrySet().stream().map(p -> p.getValue().getId()).reduce((a, b) -> a + b);
		int sum = map.entrySet().stream().mapToInt(p -> p.getValue().getId()).sum();
		System.out.println("sum  with mapToInt: " + sum);
		System.out.println("sum: " + reduce.get());

		Map<String, List<Entry<Integer, Person>>> collect = map.entrySet().stream()
				.collect(Collectors.groupingBy(e -> e.getValue().getName()));
		System.out.println("People grouped by ");

//		for (Map.Entry<Integer, Person> entry : map.entrySet()) {
//			System.out.println(entry.getKey() + ", " + map.values());
//		}

//		List<Entry<Integer, Person>> collect2 = map.entrySet().stream()
//				.sorted((e1, e2) -> e1.getValue().getId() - e2.getValue().getId()).collect(Collectors.toList());
//		Map<Integer, Person> sortedMap = new LinkedHashMap<>();
//		for (Map.Entry<Integer, Person> entry : collect2) {
//			sortedMap.put(entry.getKey(), entry.getValue());
//		}

//		List<Map.Entry<Integer, Person>> collect = map.entrySet().stream()
//				.sorted((e1, e2) -> e1.getKey().compareTo(e2.getKey())).collect(Collectors.toList());
//		Map<Integer, Person> sortedMap = new LinkedHashMap<>();
//		for (Map.Entry<Integer, Person> entry : collect) {
//			sortedMap.put(entry.getKey(), entry.getValue());
//		}

		// System.out.println(sortedMap);

//		Map<Integer, Integer> map = new HashMap<>();
//		map.put(1,  10);

//		map.put(2,  20);
//		map.put(3,  30);
//		
//		for(int key: map.keySet()) {
//		System.out.println("key: " + key + ", value: " + map.get(key));
//		}
//		
//		
//		Set<Entry<Integer,Integer>> entrySet = map.entrySet();
//		for(Map.Entry<Integer, Integer> entry: entrySet) {
//			System.out.println("key: " + entry.getKey() + ", value: " + entry.getValue());
//		}
//		
//
//		Set<Person> stu = new LinkedHashSet<>();
//
//		stu.add(new Person(1, "amir"));
//		stu.add(new Person(4, "suhel"));
//		stu.add(new Person(3, "raman singh"));
//
//		System.out.println(stu);
//
//		List<Person> list = new ArrayList<>(stu);
//		List<Person> collect2 = list.stream().sorted((a, b) -> a.getId() - b.getId()).collect(Collectors.toList());
//		Set<Person> s1 = new LinkedHashSet<>(collect2);
//		System.out.println(s1);
//		Collections.sort(list, (a, b) -> Integer.compare(a.getId(), b.getId()));
//		Set<Person> collect = list.stream().collect(Collectors.toCollection(LinkedHashSet::new));
//		System.out.println(collect);

	}

}
