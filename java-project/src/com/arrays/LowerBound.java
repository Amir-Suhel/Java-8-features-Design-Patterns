package com.arrays;

import java.util.Arrays;

public class LowerBound {

	public static void main(String[] args) {

		int[] arr = { 1, 3, 4, 5, 8, 10, 15 };
		
		int key = 0;
		int lowerBound = lowerBound(arr.length, key, arr);
		System.out.println("lower Bound: " + lowerBound);
		int search = Arrays.binarySearch(arr, key);
		System.out.println("lower: " + search);
	}

	static int lowerBound(int n, int key, int[] arr) {
		int low = 0;
		int high = n - 1;
		while (low < high) {
			int mid = low + (high - low) / 2;
			if (key <= arr[mid])
				high = mid;
			else
				low = mid + 1;
		}
		if (low < n && arr[low] < key) {
			low++;
		}
		return low;
	}

}
