package org.example.dsa;

import java.beans.PropertyEditorSupport;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class SlidingWindowMaximum {
	public int[] maxSlidingWindow(int[] nums, int k) {
		PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a, b) -> Integer.compare(b, a));
		List<Integer> result = new ArrayList<>();

		for (int i = 0; i < k; i++) {
			maxHeap.offer(nums[i]);
		}
		result.add(maxHeap.peek());

		int j = 0;
		int i = k - 1;
		while (i < nums.length - 1) {
			int removeElement = nums[j];
			maxHeap.remove(removeElement);
			j++;

			i++;
			int addElement = nums[i];
			maxHeap.offer(addElement);

			result.add(maxHeap.peek());
		}

		int [] resultArray = new int[result.size()];
		int index = 0;
		for (int r : result) {
			resultArray[index] = r;
			index++;
		}
		return resultArray;
	}
}
