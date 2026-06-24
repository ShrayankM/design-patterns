package org.example.dsa;

public class BananaEating {
	public int minEatingSpeed(int[] piles, int h) {
		int maxEatingRate = Integer.MIN_VALUE;
		int minEatingRate = 1;
		int minEatingSpeed = Integer.MAX_VALUE;

		for (int pile : piles) {
			maxEatingRate = Math.max(maxEatingRate, pile);
		}

		while (minEatingRate <= maxEatingRate) {
			int k = minEatingRate + (maxEatingRate - minEatingRate) / 2;
			int hours = hoursTakenToEat(k, piles);

			if (hours > h) minEatingRate = k + 1;
			else {
				maxEatingRate = k - 1;
				minEatingSpeed = Math.min(minEatingSpeed, k);
			}
		}
		return minEatingSpeed;
	}

	private int hoursTakenToEat(int k, int [] piles) {
		int hours = 0;
		for (int pile : piles) {
			hours = hours + Math.ceilDiv(pile, k);
		}
		return hours;
	}
}
