package org.example.dsa;

import java.util.PriorityQueue;

public class LastStoneWeight {
	public int lastStoneWeight(int[] stones) {
		PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a, b) -> Integer.compare(b, a));
		for (int stone : stones) maxHeap.offer(stone);

		while (maxHeap.size() > 1) {
			int stoneX = maxHeap.poll();
			int stoneY = maxHeap.poll();

//			if (stoneX == stoneY) continue;

			if (stoneX >= stoneY) {
				maxHeap.offer(stoneX - stoneY);
			} else {
				maxHeap.offer(stoneY - stoneX);
			}
		}
		if (!maxHeap.isEmpty()) return maxHeap.peek();
		return 0;
	}
}
