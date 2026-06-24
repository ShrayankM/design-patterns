package org.example.dsa;

import java.util.HashMap;
import java.util.Map;

public class UniquePaths {
	public int uniquePaths(int m, int n) {
		Map<String, Integer> memo = new HashMap<>();
		return findPath(0, 0, m, n, memo);
	}

	private int findPath(int i, int j, int m, int n, Map<String, Integer> memo) {
		if (i >= m || i < 0) return 0;
		if (j >= n || j < 0) return 0;

		if (i == m - 1 && j == n - 1) return 1;

		String key = i + "#" + j;
		if (memo.containsKey(key)) return memo.get(key);

		int paths = findPath(i + 1, j, m, n, memo) + findPath(i, j + 1, m, n, memo);
		memo.put(key, paths);
		return paths;
	}
}
