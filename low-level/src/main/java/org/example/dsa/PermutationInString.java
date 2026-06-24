package org.example.dsa;

public class PermutationInString {
	public boolean checkInclusion(String s1, String s2) {
		int L = s1.length();

		if (L > s2.length()) return false;

		int [] frequencyMapS1 = new int [26];
		int [] frequencyMapS2 = new int [26];

		for (int i = 0; i < L; i++) {
			char c = s1.charAt(i);
			frequencyMapS1[c - 'a']++;

			c = s2.charAt(i);
			frequencyMapS2[c - 'a']++;
		}

		int i = 0;
		int j = L - 1;

		while (j < s2.length()) {
			boolean found = checkFrequencyMapping(frequencyMapS1, frequencyMapS2);
			if (found) return true;

			frequencyMapS2[s2.charAt(i) - 'a']--;
			i++;

			j++;
			if (j == s2.length()) break;
			frequencyMapS2[s2.charAt(j) - 'a']++;
		}
		return false;
	}

	private boolean checkFrequencyMapping(int [] a, int [] b) {
		for (int i = 0; i < 26; i++) {
			if (a[i] != b[i]) return false;
		}
		return true;
	}
}
