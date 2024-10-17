package com.arrays;

import java.util.Arrays;

public class ArrayRotationBy90Degree {

	public static void main(String[] args) {
		int[][] arr = { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 } };
		int[][] ans = rotation(arr);

		for (int[] row : ans) {
			System.out.println(Arrays.toString(row));
		}

	}

	public static int[][] rotation(int[][] arr) {
		int n = arr.length;
		int[][] temp = new int[n][n];

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				temp[j][n - i - 1] = arr[i][j];
			}
		}

		return temp;
	}

}
