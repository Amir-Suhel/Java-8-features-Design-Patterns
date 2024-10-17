package com.strings;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.stream.Collectors;

public class Example {

	public static void main(String[] args) {

		List<String> list = Arrays.asList("amir", "suhel", "amir", "raman", "karan", "raman", "raman", "akshay",
				"suhel", "vikas", "john");

		List<String> ans = new ArrayList<>();

		Map<String, Integer> map = new HashMap<>();
		for (String str : list) {
			map.put(str, map.getOrDefault(str, 0) + 1);
		}

		for (Entry<String, Integer> entry : map.entrySet()) {
			if (entry.getValue() > 1) {
				ans.add(entry.getKey());
			}
		}

		System.out.println(ans);

		List<String> ans2 = list.stream().collect(Collectors.groupingBy(s -> s, Collectors.counting())).entrySet()
				.stream().filter(e -> e.getValue() > 1).map(e -> e.getKey()).collect(Collectors.toList());
		System.out.println("ans2: " + ans2);

	}

}
