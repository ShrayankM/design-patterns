package org.example.dsa;

import java.util.ArrayList;
import java.util.List;

public class EncodeDecode {
	public String encode(List<String> strs) {
		StringBuilder sb = new StringBuilder();

		for (String s : strs) {
			int size = s.length();
			sb.append(size).append("#").append(s);
		}
		return sb.toString();
	}

	public List<String> decode(String str) {
		List<String> decodedStrings = new ArrayList<>();

		int index = 0;
		while (index < str.length()) {
			int lenghtOfCurrentString = 0;
			while (str.charAt(index) != '#') {
				int currentNumber = str.charAt(index++) - '0';
				lenghtOfCurrentString = lenghtOfCurrentString * 10 + currentNumber;
			}

			StringBuilder sb = new StringBuilder();
			int j = ++index;
			while (index < (j + lenghtOfCurrentString)) sb.append(str.charAt(index++));

			decodedStrings.add(sb.toString());
		}
		return decodedStrings;
	}
}


// "Hello","World"
// 5#Hello5#World