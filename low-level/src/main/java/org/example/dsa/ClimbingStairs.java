package org.example.dsa;

import java.util.HashMap;
import java.util.Map;

public class ClimbingStairs {
	public int climbStairs(int n) {
		Map<Integer, Integer> memo = new HashMap<>();
		return climb(0, n, memo);
	}

	private int climb(int currentPosition, int n, Map<Integer, Integer> memo) {
		if (currentPosition == n) return 1;
		if (currentPosition > n) return 0;

		if (memo.containsKey(currentPosition)) return memo.get(currentPosition);

		int result = climb(currentPosition + 1, n, memo)
				+ climb(currentPosition + 2, n, memo);
		memo.put(currentPosition, result);
		return memo.get(currentPosition);
	}
}
