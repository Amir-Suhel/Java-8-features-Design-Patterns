package com.java8;

import java.util.Map;
import java.util.TreeMap;
import java.util.stream.Collectors;

public class StringExample {

	public static void main(String[] args) {

		String str = "geeksforgeeks";

		Map<Character, Long> map = str.chars().mapToObj(c -> (char) c)
				.collect(Collectors.groupingBy(c -> c, Collectors.counting())).entrySet().stream()
				.filter(e -> e.getValue() > 1).collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));

		Map<Character, Long> ans = new TreeMap<>(map);

		System.out.println(ans);

	}

}
