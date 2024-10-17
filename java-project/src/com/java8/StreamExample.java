package com.java8;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class StreamExample {

	public static void main(String[] args) {

		Map<Integer, List<String>> groupBy = Stream.of("an", "array", "is", "a", "user", "defined", "data", "type")
				.collect(Collectors.groupingBy(String::length));
		System.out.println(groupBy);

		Map<Boolean, List<Integer>> partition = Stream.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10)
				.collect(Collectors.partitioningBy(e -> e % 2 == 0));
		System.out.println(partition);
		System.out.println(partition.get(true));

		String join = Stream.of("Mohd", "Amir", "Suhel").collect(Collectors.joining(" ", "Mr. ", " Azij"));
		System.out.println(join);

		List<Character> chars = Arrays.asList('a', 'b', 'c');

		String str = chars.stream().map(String::valueOf)
				.collect(Collectors.collectingAndThen(Collectors.toList(), e -> String.join("-", e)));

		System.out.println(str);

		List<List<Integer>> ls = Arrays.asList(Arrays.asList(1, 2, 3), Arrays.asList(4, 5, 6),
				Arrays.asList(7, 8, 9, 10));
		List<Integer> collect5 = ls.stream().flatMap(e -> e.stream()).collect(Collectors.toList());
		System.out.println(collect5);

		int sum = IntStream.rangeClosed(1, 6).sum();
		System.out.println("sum: " + sum);

		List<Integer> nums = Arrays.asList(2, 1, 3, 0, 4, 5);

		Stream<String> stringStream = Stream.of("1", "2", "3", "4", "5");
		// int[] array = stringStream.mapToInt(Integer:: parseInt).toArray();
//		int[] array = stringStream.mapToInt(e -> Integer.parseInt(e)).toArray();
//		System.out.println(Arrays.toString(array));
		double[] array2 = stringStream.mapToDouble(e -> Double.parseDouble(e)).toArray();
		System.out.println("array2: " + Arrays.toString(array2));

		System.out.println(nums.stream().findFirst().get());
		System.out.println(nums.stream().findAny().get());

		Optional<Integer> first = nums.stream().filter(e -> e > 3).findFirst();
		System.out.println("findFirst: " + first.get());

		boolean anyMatch = nums.stream().anyMatch(e -> e > 3);
		System.out.println("anytmatch:" + anyMatch);

		System.out.println("allMatch: " + nums.stream().allMatch(e -> e <= 10));

		System.out.println("noneMatch: " + nums.stream().noneMatch(e -> e == 8));

		Optional<Integer> min = nums.stream().min((a, b) -> a.compareTo(b));
		System.out.println("min: " + min.get());

		Optional<Integer> min2 = nums.stream().min(Comparator.reverseOrder());
		System.out.println("min2:" + min2.get());

		Optional<Integer> reduce = nums.stream().reduce((a, b) -> a + b);
		System.out.println("reduce: " + reduce.get());

		Stream<Integer> peek = nums.stream().filter(e -> e % 2 == 0).peek(e -> System.out.println(e));
		peek.count();

		List<List<String>> list = Arrays.asList(Arrays.asList("c", "language"), Arrays.asList("java", "programming"),
				Arrays.asList("intermediate", "Operations", "are", "lazy"));

		List<String> collect = list.stream().flatMap(e -> e.stream()).collect(Collectors.toList());
		System.out.println(collect + ", size: " + collect.size());

		List<String> collect2 = list.stream().flatMap(e -> e.stream().map(c -> c.toUpperCase()))
				.collect(Collectors.toList());
		System.out.println(collect2);

		List<String> collect3 = list.stream().flatMap(e -> {
			return Stream.concat(e.stream().limit(1).map(c -> c.toUpperCase()), e.stream().skip(1));
		}).collect(Collectors.toList());

		System.out.println(collect3);

		List<String> collect4 = list.stream().map(innerList -> {
			if (list.indexOf(innerList) < 2) {
				return innerList.stream().sorted().collect(Collectors.toList());
			} else {
				return innerList.stream().sorted((a, b) -> b.compareToIgnoreCase(a)).collect(Collectors.toList());
			}
		}).flatMap(e -> {
			return Stream.concat(e.stream().limit(1).map(c -> c.toUpperCase()), e.stream().skip(1));
		}).collect(Collectors.toList());

		System.out.println(collect4);

	}

}
