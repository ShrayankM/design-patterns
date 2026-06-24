package org.example.dsa;

import java.util.HashSet;
import java.util.Set;

public class LongestConsecutiveSubString {
	public int lengthOfLongestSubstring(String s) {
		Set<Character> uniqueChars = new HashSet<>();

		if (s.isEmpty()) return 0;
		if (s.isBlank()) return 1;

		int N = s.length();
		int maxLength = 1;

		int i = 0, j = 0;
		uniqueChars.add(s.charAt(0));
		while (true) {
			maxLength = Math.max(maxLength, (j - i + 1));

			j++;
			if (j >= N) break;

			char currentCharAtJ = s.charAt(j);
			while (uniqueChars.contains(currentCharAtJ)) {
				uniqueChars.remove(s.charAt(i));
				i++;
			}
			uniqueChars.add(s.charAt(j));
		}
		return maxLength;
	}
}
