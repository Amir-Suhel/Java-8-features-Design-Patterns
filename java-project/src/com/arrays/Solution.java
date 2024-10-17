package com.arrays;

public class Solution {

	static int cnt = 0;

	public static void main(String[] args) {
		long[] arr = { 5, 4, 3, 2, 1 };
		long ans = getInversions(arr, arr.length);
		System.out.println("ans: " + ans);
		
	}

	public static long getInversions(long arr[], int n) {
		// Write your code here.
		mergeSort(arr, 0, n - 1);
		return cnt;
	}

	public static void mergeSort(long arr[], int low, int high) {
		if (low < high) {
			int mid = low + (high - low) / 2;
			mergeSort(arr, low, mid);
			mergeSort(arr, mid + 1, high);
			merge(arr, low, mid, high);
		}
	}

	public static void merge(long arr[], int low, int mid, int high) {

		long temp[] = new long[high - low + 1];
		int i = low;
		int j = mid + 1;
		int k = 0;

		while (i <= mid && j <= high) {
			if (arr[i] <= arr[j]) {
				temp[k] = arr[i];
				i++;
			} else {
				temp[k] = arr[j];
				cnt += (mid - i + 1);
				j++;
			}
			k++;
		}

		while (i <= mid)
			temp[k++] = arr[i++];
		while (j <= high)
			temp[k++] = arr[j++];

		for (int x = 0; x < temp.length; x++) {
			arr[low + x] = temp[x];
		}
	}
}
