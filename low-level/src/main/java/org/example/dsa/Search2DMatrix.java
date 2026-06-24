package org.example.dsa;

public class Search2DMatrix {
	public boolean searchMatrix(int[][] matrix, int target) {
		int r = matrix.length;
		int c = matrix[0].length;

		int i = 0, j = (r * c);
		while (i <= j) {
			int mid = i + (j - i) / 2;

			int row = (mid / c);
			int col = (mid / r);

			if (matrix[row][col] == target) return true;

			if (matrix[row][col] > target) j = mid - 1;
			else i = mid + 1;
		}
		return false;
	}
}
