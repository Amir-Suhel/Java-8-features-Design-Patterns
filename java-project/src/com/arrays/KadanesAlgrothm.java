package com.arrays;

public class KadanesAlgrothm {

	public static void main(String[] args) {

		int[] arr = { -2, 1, -3, 4, -1, 2, 1, -5, 4, 6};
		long ans1 = maxSumBruteForce(arr);
		System.out.println("max subarraysum with brute force: " + ans1);
		long ans2 = maxSumBetterApproach(arr);
		System.out.println("max subarraysum with better approach: " + ans2);

		greatestSumSubarray(arr);

	}

	/**
	 * Greatest Sum subarray print
	 */
	public static void greatestSumSubarray(int[] arr) {
		long maxi = Long.MIN_VALUE;
		long sum = 0;
		int start = 0;
		int end = 0;

		for (int i = 0; i < arr.length; i++) {
			sum += arr[i];
			if (sum > maxi) {
				maxi = sum;
				end = i;
			}
			if (sum < 0) {
				sum = 0;
				start = i + 1;
			}
		}

		for (int i = start; i <= end; i++) {
			System.out.print(arr[i] + ", ");
		}
	}

	public static Long maxSumBruteForce(int[] arr) {
		int n = arr.length;
		long maxi = 0;

		for (int i = 0; i < n; i++) {
			for (int j = i; j < n; j++) {
				long sum = 0L;
				for (int k = i; k <= j; k++) {
					sum += arr[k];
					maxi = Math.max(sum, maxi);
				}
			}
		}

		return maxi;

	}

	public static Long maxSumBetterApproach(int[] arr) {
		int n = arr.length;
		long maxi = 0;
		for (int i = 0; i < n; i++) {
			long sum = 0L;
			for (int j = i; j < n; j++) {
				sum += arr[j];
				maxi = Math.max(sum, maxi);
			}
		}

		return maxi;
	}

	public static Long kadane(int[] arr) {
		long maxi = Long.MIN_VALUE;
		long sum = 0;
		for (int i = 0; i < arr.length; i++) {
			sum += arr[i];
			if (sum > maxi) {
				maxi = sum;
			}
			if (sum < 0) {
				sum = 0;
			}

		}

		return maxi;
	}

}
