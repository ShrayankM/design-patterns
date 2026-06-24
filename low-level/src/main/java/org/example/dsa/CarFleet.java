package org.example.dsa;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Stack;

public class CarFleet {
	static class CarData {
		int position;
		int speed;

		public CarData(int position, int speed) {
			this.position = position;
			this.speed = speed;
		}
	}

	public int carFleet(int target, int[] position, int[] speed) {
		Stack<Double> stack = new Stack<>();
		PriorityQueue<CarData> maxHeap = new PriorityQueue<>((a, b) ->
				Integer.compare(b.position, a.position));

		for (int i = 0; i < position.length; i++) {
			maxHeap.offer(new CarData(position[i], speed[i]));
		}

		while (!maxHeap.isEmpty()) {
			CarData carData = maxHeap.poll();
			Double timeTaken = (double) (target - carData.position) / carData.speed;

			if (stack.isEmpty() || stack.peek() < timeTaken) {
				stack.push(timeTaken);
			}
		}
		return stack.size();
	}
}
