package org.example.dsa;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class TopKFrequent {
	public int[] topKFrequent(int[] nums, int k) {
		Map<Integer, Integer> frequencyMap = new HashMap<>();

		for (int number : nums) {
			frequencyMap.put(number, frequencyMap.getOrDefault(number, 0) + 1);
		}

		PriorityQueue<Pair> minHeap = new PriorityQueue<>((a, b) ->
				Integer.compare(a.frequency, b.frequency));

		for (Map.Entry<Integer, Integer> entry : frequencyMap.entrySet()) {
			int key = entry.getKey();
			int value = entry.getValue();

			minHeap.offer(new Pair(key, value));
			if (minHeap.size() > k) {
				minHeap.poll();
			}
		}

		int i = 0;
		int [] result = new int[k];
		while (!minHeap.isEmpty()) {
			result[i++] = minHeap.poll().number;
		}
		return result;
	}

	class Pair {
		int number;
		int frequency;

		public Pair(int number, int frequency) {
			this.number = number;
			this.frequency = frequency;
		}
	}
}
