package org.example.dsa;

public class SearchInRotatedSorterArray {
	public int search(int[] nums, int target) {
		int i = 0, j = nums.length - 1;
		while (i < j) {
			int mid = i + (j - i) / 2;

			if (nums[mid] == target) return mid;

//			if (target >= nums[i] && target < nums[mid]) {
			if (target >= nums[i]) {
				j = mid - 1;
			} else {
				i = mid + 1;
			}
		}
		return nums[j] == target ? i : -1;
	}
}
