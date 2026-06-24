package org.example.dsa;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class GroupAnagrams {
	public List<List<String>> groupAnagrams(String[] strs) {
		Map<String, List<String>> groupMap = new HashMap<>();

		for (int i = 0; i < strs.length; i++) {
			String s = strs[i];
			String key = getKey(s);
			groupMap.computeIfAbsent(key, k -> new ArrayList<>()).add(s);
		}
		return groupMap.values().stream().toList();
	}

	private static String getKey(String str) {
		int [] frequency = new int [26];

		for (int i = 0; i < str.length(); i++) {
			char c = str.charAt(i);
			frequency[c - 'a']++;
		}

		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < frequency.length; i++) {
			sb.append(frequency[i]).append("#");
		}
		return sb.toString();
	}

	public boolean hasDuplicate(int[] nums) {
		Set<Integer> unique = new HashSet();

		for (int n : nums) {
			if (unique.contains(n)) return true;

			unique.add(n);
		}
		return false;
	}
}
