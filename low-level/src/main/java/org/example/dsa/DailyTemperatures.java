package org.example.dsa;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class DailyTemperatures {
	static class DayTemperature {
		int day;
		int temperature;

		public DayTemperature(int day, int temperature) {
			this.day = day;
			this.temperature = temperature;
		}
	}

	public int[] dailyTemperatures(int[] temperatures) {
		Stack<DayTemperature> stack = new Stack<>();
		List<Integer> resultList = new ArrayList<>();
		resultList.add(0);
		stack.push(new DayTemperature(temperatures.length - 1, temperatures[temperatures.length - 1]));

		for (int i = temperatures.length - 2; i >= 0; i--) {
			int currentDayTemperature = temperatures[i];
			while (!stack.isEmpty() && stack.peek().temperature <= currentDayTemperature) stack.pop();

			if (stack.isEmpty()) {
				resultList.add(0);
			} else {
				DayTemperature currentTop = stack.peek();
				resultList.add(currentTop.day - i);
			}
			stack.push(new DayTemperature(i, currentDayTemperature));
		}

		int [] result = new int[temperatures.length];
		int k = temperatures.length - 1;

		for (int r : resultList) {
			result[k--] = r;
		}
		return result;
	}
}
