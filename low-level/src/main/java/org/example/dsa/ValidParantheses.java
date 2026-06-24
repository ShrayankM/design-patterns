package org.example.dsa;

import java.util.Stack;

public class ValidParantheses {
	public boolean isValid(String s) {
		Stack<Character> stack = new Stack<>();

		for (int i = 0; i < s.length(); i++) {
			char currentChar = s.charAt(i);
			if ('{' == currentChar || '[' == currentChar || '(' == currentChar) {
				stack.push(currentChar);
			} else {
				if (stack.isEmpty()) return false;
				char topOfStack = stack.pop();

				boolean isMatching = isMatching(currentChar, topOfStack);
				if (!isMatching) return false;
			}
		}
		return stack.isEmpty();
	}

	private boolean isMatching(char closingBracket, char openingBracket) {
		if (closingBracket == '}' && openingBracket == '{') return true;
		if (closingBracket == ')' && openingBracket == '(') return true;
		if (closingBracket == ']' && openingBracket == '[') return true;

		return false;
	}
}
