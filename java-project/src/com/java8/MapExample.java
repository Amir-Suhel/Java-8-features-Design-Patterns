package com.java8;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class MapExample {

	public static void main(String[] args) {

		Map<Integer, Integer> map = new HashMap<>();

		map.put(1, 10);
		map.put(2, 20);
		map.put(3, 30);
		map.put(4, 10);
		map.put(5, 20);
		
		Set<Entry<Integer,Integer>> entrySet = map.entrySet();
		
		for(Entry<Integer, Integer> it: entrySet) {
			System.out.println(it.getKey() + " : " + it.getValue());
		}

	}

}
