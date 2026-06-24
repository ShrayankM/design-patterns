package org.example.dsa;

import java.util.HashMap;
import java.util.Map;

public class CoinChange {
	public int coinChange(int[] coins, int amount) {
		Map<Integer, Integer> memo = new HashMap<>();
		return findMinimumCoins(coins, amount, memo);
	}

	private int findMinimumCoins(int [] coins, int amount, Map<Integer, Integer> memo ) {
		if (amount == 0) return 0;
		if (memo.containsKey(amount)) return memo.get(amount);

		int coinsRequired = Integer.MAX_VALUE;
		for (int i = 0; i < coins.length; i++) {
			if (amount >= coins[i]) {
				int currentRequired = 1 + findMinimumCoins(coins, amount - coins[i], memo);
				coinsRequired = Math.min(coinsRequired, currentRequired);
			}
		}

		memo.put(amount, coinsRequired);
		return coinsRequired;
	}
}
