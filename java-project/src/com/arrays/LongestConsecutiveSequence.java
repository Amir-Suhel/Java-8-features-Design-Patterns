package com.arrays;

import java.util.HashSet;
import java.util.Set;

public class LongestConsecutiveSequence {

	public static void main(String[] args) {

		int[] arr = { 1, 2, 3, 3, 2, 2, 1, 0, 4, 3 };
		int ans = longestConsecutive(arr);
		System.out.println(ans);

	}

	public static int longestConsecutive(int[] nums) {
		int n = nums.length;
		if (n < 1)
			return 0;

		Set<Integer> set = new HashSet<>();
		for (int num : nums)
			set.add(num);

		int maxi = 1;
		for (int num : nums) {
			if (!set.contains(num - 1)) {
				int cnt = 1;
				int x = num;
				while (set.contains(x + 1)) {
					cnt++;
					x += 1;
				}
				maxi = Math.max(cnt, maxi);
			}
		}
		return maxi;
	}

}
