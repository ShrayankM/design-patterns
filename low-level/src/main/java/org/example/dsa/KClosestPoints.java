package org.example.dsa;

import java.util.PriorityQueue;

public class KClosestPoints {
	public static class PointData {
		Double distance;
		int [] point;

		public PointData(Double distance, int [] point) {
			this.distance = distance;
			this.point = point;
		}
	}

	public int[][] kClosest(int[][] points, int k) {
		PriorityQueue<PointData> priorityQueue = new PriorityQueue<>((a, b) ->
				Double.compare(b.distance, a.distance));

		int N = points.length;
		for (int i = 0; i < N; i++) {
			int x = points[i][0];
			int y = points[i][1];

			Double distance = Math.sqrt((double) (x * x) + (y * y));
			priorityQueue.offer(new PointData(distance, new int []{x, y}));

			if (priorityQueue.size() > k) priorityQueue.poll();
		}

		int [][] result = new int[k][2];
		int index = 0;
		while (!priorityQueue.isEmpty()) {
			PointData pointData = priorityQueue.poll();

			result[index][0] = pointData.point[0];
			result[index][1] = pointData.point[1];
			index++;
		}
		return result;
	}
}
