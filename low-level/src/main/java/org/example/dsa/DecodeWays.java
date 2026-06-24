package org.example.dsa;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

class DecodeWays {
		public int numDecodings(String s) {
			return calculateNumbers(0, s, new HashMap<>());
		}

		private int calculateNumbers(int currentPosition, String s, Map<Integer, Integer> memo) {
			if (currentPosition >= s.length()) return 1;

			if (memo.containsKey(currentPosition)) return memo.get(currentPosition);

			int ways = 0;
			for (int i = 1; i <= 2; i++) {
				if (currentPosition + i > s.length()) continue;

				String currentLetter = getMappingForNumber(s.substring(currentPosition, currentPosition + i));
				if (Objects.isNull(currentLetter)) continue;

				ways += calculateNumbers(currentPosition + i, s, memo);
			}

			memo.put(currentPosition, ways);
			return ways;
		}

	private String getMappingForNumber(String number) {
		if (number.charAt(0) == '0') return null;

		int intNumber = Integer.parseInt(number);
		if (intNumber <= 0 || intNumber > 26) return null;

		return String.valueOf((char) ('A' + intNumber - 1));
	}
}
