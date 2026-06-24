package org.example.dsa;

public class MaxSumSubarray {
	public int maxSubArray(int[] nums) {
		// Greedy approach
		int maxValue = Integer.MIN_VALUE;
		int currentSum = 0;

		for (int i = 0; i < nums.length; i++) {
			currentSum = Math.max(currentSum + nums[i], nums[i]);
			maxValue = Math.max(maxValue, currentSum);
		}
		return maxValue;
	}
}
