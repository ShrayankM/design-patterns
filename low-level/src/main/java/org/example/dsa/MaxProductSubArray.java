package org.example.dsa;

public class MaxProductSubArray {
	public int maxProduct(int[] nums) {
		int currentMax = 1, currentMin = 1;

		int result = Integer.MIN_VALUE;
		for (int i = 0; i < nums.length; i++) {
			int maxMultiply = currentMax * nums[i];
			int minMultiply = currentMin * nums[i];

			currentMax = Math.max(maxMultiply, Math.max(minMultiply, nums[i]));
			currentMin = Math.min(maxMultiply, Math.max(minMultiply, nums[i]));

			result = Math.max(result, currentMax);
		}
		return result;
	}
}
