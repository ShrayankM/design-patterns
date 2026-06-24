package org.example.dsa;

import java.util.HashMap;
import java.util.Map;

public class CircularHouseRobber {
	public int rob(int[] nums) {
		int N = nums.length;

		if (N == 1) return nums[0];

		Map<String, Integer> memo = new HashMap<>();
		return Math.max(rob(0, N - 1, nums, memo), rob(1, N, nums, memo));
	}

	private int rob(int currentPosition, int endingPosition, int [] nums, Map<String, Integer> memo) {
		if (currentPosition >= endingPosition) return 0;

		String key = currentPosition + "#" + endingPosition;
		if (memo.containsKey(key)) return memo.get(key);

		int robbedCurrentHouse = nums[currentPosition] + rob(currentPosition + 2, endingPosition, nums, memo);
		int skippedCurrentHouse = rob(currentPosition + 1, endingPosition, nums, memo);


		memo.put(key, Math.max(robbedCurrentHouse, skippedCurrentHouse));
		return memo.get(key);
	}
}
