package org.example.dsa;

public class LongestPalindromeSubstring {
	public String longestPalindrome(String s) {
		int L = s.length();

		int [][] dp = new int [L][L];

		int startIndex = 0;
		int maxLength = 1;

		// base case single character
		for (int i = 0; i < L; i++) {
			dp[i][i] = 1;
		}

		// base case 2 characters
		for (int i = 0; i < L - 1; i++) {
			if (s.charAt(i) == s.charAt(i + 1)) {
				dp[i][i + 1] = 1;
				startIndex = i;
				maxLength = 2;
			}
		}

		// substring from length 3 & onwards
		for (int substringLenght = 3; substringLenght <= L; substringLenght++) {
			for (int i = 0; i < L - substringLenght + 1; i++) {
				int j = i + substringLenght - 1;

				if (s.charAt(i) == s.charAt(j) && dp[i + 1][j - 1] == 1) {
					dp[i][j] = 1;

					if (j - i + 1 > maxLength) {
						maxLength = (j - i + 1);
						startIndex = i;
					}
				}
			}
		}
		return s.substring(startIndex, startIndex + maxLength);
	}
}
