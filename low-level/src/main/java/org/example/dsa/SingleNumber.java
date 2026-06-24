package org.example.dsa;

public class SingleNumber {
	public int singleNumber(int[] nums) {
		int number = 0;

		for (int num : nums) {
			number = number ^ num;
		}
		return number;
	}
}
