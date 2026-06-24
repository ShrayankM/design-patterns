package org.example.dsa;

public class Anagram {
	public boolean isAnagram(String s, String t) {
		int [] frequency = new int [26];

		if (s.isEmpty() || t.isEmpty()) return false;
		if (s.length() != t.length()) return false;

		for (int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);
			frequency[c - 'a']++;

			c = t.charAt(i);
			frequency[c - 'a']--;
		}

		for (int i = 0; i < 26; i++) {
			if (frequency[i] != 0) return false;
		}
		return true;
	}
}
