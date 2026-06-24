package org.example.dsa;

public class BuySellStock {
	public int maxProfit(int[] prices) {
		int maxProfit = 0;
		int buyingPrice = prices[0];

		for (int i = 1; i < prices.length; i++) {
			int currentProfit = prices[i] - buyingPrice;
			maxProfit = Math.max(maxProfit, currentProfit);

			buyingPrice = Math.min(buyingPrice, prices[i]);
		}
		return maxProfit;
	}
}
