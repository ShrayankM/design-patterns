package org.example.dsa;

import java.util.Stack;

public class ReversePolish {
	public int evalRPN(String[] tokens) {
		Stack<Integer> numbers = new Stack<>();

		for (int i = 0; i < tokens.length; i++) {
			String currentStr = tokens[i];

			if (isAnOperator(currentStr)) {
				int b = numbers.pop();
				int a = numbers.pop();
				numbers.push(performOperationAndReturnResult(a, b, currentStr));
			} else {
				boolean isNegativeNumber = isAnOperator(currentStr.substring(0, 1));
				if (isNegativeNumber) {
					numbers.push(convertStringToNumber(currentStr.substring(1)) * -1);
				} else {
					numbers.push(convertStringToNumber(currentStr));
				}
			}
		}
		return numbers.peek();
	}

	private int convertStringToNumber(String str) {
		int currentNumber = 0;

		for (int i = 0; i < str.length(); i++) {
			char c = str.charAt(i);
			currentNumber = currentNumber * 10 + (c - '0');
		}
		return currentNumber;
	}

	private boolean isAnOperator(String str) {
		return "+".equals(str) || "-".equals(str) || "*".equals(str) || "/".equals(str);
	}

	private int performOperationAndReturnResult(int a, int b, String operation) {
		if ("+".equals(operation)) return a + b;
		if ("-".equals(operation)) return a - b;
		if ("*".equals(operation)) return a * b;
		if ("/".equals(operation)) return a / b;

		return 0;
	}
}
