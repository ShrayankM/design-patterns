package org.example.dsa;

import java.util.PriorityQueue;

public class KthLargestInArrya {
	public int findKthLargest(int[] nums, int k) {
		PriorityQueue<Integer> priorityQueue = new PriorityQueue<>();

		for (int i = 0; i < nums.length; i++) {
			priorityQueue.offer(nums[i]);

			if (priorityQueue.size() > k) priorityQueue.poll();
		}
		if (!priorityQueue.isEmpty()) return priorityQueue.peek();
		return -1;
	}
}
