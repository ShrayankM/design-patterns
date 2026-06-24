package org.example.dsa;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class TwoSum {
	public int[] twoSum(int[] nums, int target) {
		Map<Integer, Integer> numberIndexMap = new HashMap<>();

		Arrays.sort(nums);

		int [] result = new int [2];
		for (int i = 0; i < nums.length; i++) {
			int index = i;
			int number = nums[i];

			if (!numberIndexMap.isEmpty()) {
				int toFind = target - number;
				if (numberIndexMap.containsKey(toFind)) {
					result[0] = numberIndexMap.get(toFind);
					result[1] = index;
					return result;
				}
			}
			numberIndexMap.put(number, index);
		}
		return new int []{-1, -1};
	}
}
