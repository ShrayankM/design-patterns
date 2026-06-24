package org.example.dsa;

public class PalindromicSubstrings {
	public int countSubstrings(String s) {
		int L = s.length();
		int count = 0;

		int [][] dp = new int [L][L];

		// single character base case
		for (int i = 0; i < L; i++) {
			dp[i][i] = 1;
			count++;
		}

		// 2 characters base case
		for (int i = 0; i <= L - 2; i++) {
			if (s.charAt(i) == s.charAt(i + 1)) {
				dp[i][i + 1] = 1;
				count++;
			}
		}

		// length-3 & above
		for (int substringLength = 3; substringLength <= L; substringLength++) {
			for (int i = 0; i <= L - substringLength; i++) {
				int j = i + substringLength - 1;

				if (s.charAt(i) == s.charAt(j) && dp[i + 1][j - 1] == 1) {
					dp[i][j] = 1;
					count++;
				}
			}
		}
		return count;
	}
}
