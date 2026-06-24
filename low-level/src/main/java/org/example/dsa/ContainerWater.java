package org.example.dsa;

public class ContainerWater {
	public int maxArea(int[] heights) {
		int N = heights.length;

		int i = 0;
		int j = N - 1;

		int maxArea = 0;
		while (i < j) {
			int h1 = heights[i];
			int h2 = heights[j];

			int height = Math.min(h1, h2);
			int breadth = j - i;

			maxArea = Math.max(maxArea, (height * breadth));

			if (h1 > h2) j--;
			else         i++;
		}
		return maxArea;
	}
}
