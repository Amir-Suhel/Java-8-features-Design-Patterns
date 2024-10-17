package com.arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class NextGreaterPermutation {

	public static void main(String[] args) {

		int[] arr = { 2, 6, 2, 4, 3, 0, 0 };

		List<Integer> ans = nextGreaterPermutation(arr);
		System.out.println(ans);
		
		int[] result = nextGreaterPermuatationOptimalSolution(arr);
		System.out.println(Arrays.toString(result));
	}

	/**
	 * optimal solution
	 */
	public static int[] nextGreaterPermuatationOptimalSolution(int[] arr) {
		int n = arr.length;
		int idx = -1;
		for (int i = n - 2; i >= 0; i--) {
			if (arr[i] < arr[i + 1]) {
				idx = i;
				break;
			}
		}

		if (idx == -1) {
			Arrays.sort(arr);
			return arr;
		}

		for (int i = n - 1; i >= idx; i--) {
			if (arr[i] > arr[idx]) {
				int temp = arr[i];
				arr[i] = arr[idx];
				arr[idx] = temp;
				break;
			}
		}

		Arrays.sort(arr, idx + 1, n);
		return arr;
	}

	public static List<List<Integer>> permute(int[] nums) {
		List<List<Integer>> result = new ArrayList<>();
		List<Integer> tempList = new ArrayList<>();
		boolean[] used = new boolean[nums.length];
		generatePermutations(nums, result, tempList, used);
		return result;
	}

	private static void generatePermutations(int[] nums, List<List<Integer>> result, List<Integer> tempList,
			boolean[] used) {
		if (tempList.size() == nums.length) {
			result.add(new ArrayList<>(tempList));
			return;
		}
		for (int i = 0; i < nums.length; i++) {
			if (!used[i]) {
				tempList.add(nums[i]);
				used[i] = true;
				generatePermutations(nums, result, tempList, used);
				used[i] = false;
				tempList.remove(tempList.size() - 1);
			}
		}
	}

	public static List<Integer> nextGreaterPermutation(int[] arr) {
		int n = arr.length;

		int[] temp = Arrays.copyOf(arr, n);
		Arrays.sort(temp);

		List<List<Integer>> list = permute(arr);
		Collections.sort(list, new Comparator<List<Integer>>() {
			@Override
			public int compare(List<Integer> list1, List<Integer> list2) {
				return list1.toString().compareTo(list2.toString());
			}
		});

//		for (List<Integer> trav : list) {
//			System.out.println(trav);
//		}

		for (int i = 0; i < list.size() - 1; i++) {
			if (list.get(i).size() == n) {
				if (compare(list.get(i), arr)) {
					for (int j = i + 1; j < list.size(); j++) {
						if (!compare(list.get(j), arr)) {
							return list.get(j);
						}
					}

				}
			}

		}

		return Arrays.stream(temp).boxed().collect(Collectors.toList());

	}

	public static boolean compare(List<Integer> list, int[] arr) {
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] != list.get(i)) {
				return false;
			}
		}
		return true;
	}

}
