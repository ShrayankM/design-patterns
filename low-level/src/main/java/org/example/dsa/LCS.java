package org.example.dsa;

public class LCS {
	public int longestCommonSubsequence(String text1, String text2) {
		int N = text1.length();
		int M = text2.length();

		int [][] matrix = new int [N + 1][M + 1];

		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= M; j++) {
				if (text1.charAt(i - 1) == text2.charAt(j - 1)) {
					matrix[i][j] = 1 + matrix[i - 1][j - 1];
				} else {
					matrix[i][j] = Math.max(matrix[i][j - 1], matrix[i - 1][j]);
				}
			}
		}
		return matrix[N][M];
	}
}
