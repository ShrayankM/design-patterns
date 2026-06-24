package org.example.dsa;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TripletSum {
		public List<List<Integer>> threeSum(int[] nums) {
			List<List<Integer>> result = new ArrayList();
			Arrays.sort(nums);
			for (int k = 0; k < nums.length; k++) {
				if (k > 0 && nums[k] == nums[k - 1]) continue;

				int i = k + 1; int j = nums.length - 1;
				while (i < j) {
					int target = nums[i] + nums[j] + nums[k];
					if (target == 0) {
						result.add(Arrays.asList(nums[i], nums[j], nums[k]));

						while (i < j && nums[i] == nums[i + 1]) i++;
						while (i < j && nums[j] == nums[j - 1]) j--;

						i++;
						j--;
					} else if (target > 0) {
						j--;
					} else {
						i++;
					}
				}
			}
			return result;
		}
}
