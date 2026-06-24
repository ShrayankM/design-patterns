package org.example.dsa;

import java.util.HashMap;
import java.util.Map;

public class HouseRobber {
	public int rob(int[] nums) {
		int N = nums.length;
		HashMap<Integer, Integer> memo = new HashMap<>();
		return rob(0, nums, N, memo);
	}

	private int rob(int currentPosition, int [] nums, int N, Map<Integer, Integer> memo) {
		if (currentPosition >= N) return 0;
		if (memo.containsKey(currentPosition)) return memo.get(currentPosition);

		int robbedCurrentHouse = nums[currentPosition] + rob(currentPosition + 2, nums, N, memo);
		int skippedCurrentHouse = rob(currentPosition + 1, nums, N, memo);

		int maxRobbed = Math.max(robbedCurrentHouse, skippedCurrentHouse);
		memo.put(currentPosition, maxRobbed);
		return maxRobbed;
	}
}
