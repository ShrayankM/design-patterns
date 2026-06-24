package org.example.dsa;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class CharacterReplacement {
	public int characterReplacement(String s, int k) {
		if (s.isBlank()) return 0;
		Map<Character, Integer> frequencyMap = new HashMap<>();

		int maxFrequency = 0;
		int maxLength = 0;

		int j = 0;
		for (int i = 0; i < s.length(); i++) {
			char currentChar = s.charAt(i);
			frequencyMap.put(currentChar, frequencyMap.getOrDefault(currentChar, 0) + 1);
			maxFrequency = Math.max(maxFrequency, frequencyMap.get(currentChar));

			if ((i - j + 1) - maxFrequency > k) {
				char charAtJ = s.charAt(j);
				frequencyMap.put(charAtJ, frequencyMap.get(charAtJ) - 1);
				j++;
			} else {
				maxLength = Math.max(maxLength, i - j + 1);
			}
		}
		return maxLength;
	}
}
