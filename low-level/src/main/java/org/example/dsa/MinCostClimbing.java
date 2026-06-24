package org.example.dsa;

import java.util.HashMap;
import java.util.Map;

public class MinCostClimbing {
	public int minCostClimbingStairs(int[] cost) {
		int N = cost.length;

		Map<Integer, Integer> memo = new HashMap<>();
		return Math.min(climb(0, N, cost, memo), climb(1, N, cost, memo));
	}

	private int climb(int currentPosition, int N, int [] cost, Map<Integer, Integer> memo) {
		if (currentPosition >= N) return 0;

		if (memo.containsKey(currentPosition)) return memo.get(currentPosition);

		int oneStep = cost[currentPosition] + climb(currentPosition + 1, N, cost, memo);
		int twoStep = cost[currentPosition] + climb(currentPosition + 2, N, cost, memo);

		memo.put(currentPosition, Math.min(oneStep, twoStep));
		return memo.get(currentPosition);
	}
}
