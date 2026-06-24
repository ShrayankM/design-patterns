package org.example.dsa;

import java.util.ArrayList;
import java.util.List;

public class ProductOfArray {
	public int[] productExceptSelf(int[] nums) {

		int N = nums.length;

		int [] leftPrefixProduct = new int [N];
		int [] rightPrefixProduct = new int [N];

		leftPrefixProduct[0] = 1;
		rightPrefixProduct[N - 1] = 1;

		for (int i = 1; i < N; i++) {
			leftPrefixProduct[i] = leftPrefixProduct[i - 1] * nums[i - 1];
		}

		for (int i = N - 2; i >= 0; i--) {
			rightPrefixProduct[i] = rightPrefixProduct[i + 1] * nums[i + 1];
		}

		int [] result = new int [N];
		for (int k = 0; k < N; k++) {
			result[k] = leftPrefixProduct[k] * rightPrefixProduct[k];
		}
		return result;
	}
}
