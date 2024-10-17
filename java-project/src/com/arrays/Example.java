package com.arrays;

import java.util.ArrayList;
import java.util.Arrays;

public class Example {

	public static void main(String[] args) {
		ArrayList<Integer> arr = new ArrayList<>(Arrays.asList(4, 1, 2, 3, 1));
		System.out.println(arr);
		int ans = reversePairs(arr);
		System.out.println("ans: " + ans);
		System.out.println(arr);

	}

	public static int reversePairs(ArrayList<Integer> arr) {
		// Write your code here.
		return mergeSort(arr, 0, arr.size() - 1);
	}

	public static int mergeSort(ArrayList<Integer> arr, int low, int high) {
		int cnt = 0;
		if (low >= high)
			return 0;

		int mid = low + (high - low) / 2;
		cnt += mergeSort(arr, low, mid);
		cnt += mergeSort(arr, mid + 1, high);
		cnt += countPairs(arr, low, mid, high);
		merge(arr, low, mid, high);

		return cnt;
	}

	public static int countPairs(ArrayList<Integer> arr, int low, int mid, int high) {
		int j = mid + 1;
		int cnt = 0;

		for (int i = low; i <= mid; i++) {
			while (j <= high && arr.get(i) > 2 * arr.get(j)) {
				j++;
			}
			cnt += (j - (mid + 1));
		}
		return cnt;
	}

	public static void merge(ArrayList<Integer> arr, int low, int mid, int high) {
		int temp[] = new int[high - low + 1];
		int i = low;
		int j = mid + 1;
		int k = 0;
		while (i <= mid && j <= high) {
			if (arr.get(i) < arr.get(j)) {
				temp[k] = arr.get(i);
				i++;
			} else {
				temp[k] = arr.get(j);
				j++;
			}
			k++;
		}

		while (i <= mid) {
			temp[k] = arr.get(i);
			i++;
			k++;
		}
		while (j <= high) {
			temp[k] = arr.get(j);
			j++;
			k++;
		}

		for (int x = low; x <= high; x++) {
			arr.set(x, temp[x - low]);
		}
	}

}
