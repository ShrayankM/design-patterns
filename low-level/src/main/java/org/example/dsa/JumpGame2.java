package org.example.dsa;

import java.util.Arrays;

public class JumpGame2 {
	public int canJump(int[] nums) {
		int [] memo = new int [nums.length];
		Arrays.fill(memo, Integer.MAX_VALUE);

		int [] result = new int []{0};
		result[0] = Integer.MAX_VALUE;

		jump(0, nums, result, memo, 0);
		return result[0];
	}

	private static void jump(int index, int [] nums, int [] result, int [] memo, int totalJumps) {
		if (index >= nums.length - 1) {
			result[0] = Math.min(result[0], totalJumps);
			return;
		}

		if (memo[index] != Integer.MAX_VALUE) {
			result[0] = Math.min(result[0], memo[index]);
			return;
		}

		int jumpsPossible = nums[index];
		for (int i = 1; i <= jumpsPossible; i++) {
			jump(index + i, nums, result, memo, totalJumps + 1);
		}
		memo[index] = result[0];
	}
}
