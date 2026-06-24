package org.example.dsa;

import java.util.Stack;

class MinStack {
	private Stack<Integer> stack;
	private Stack<Integer> minStack;

	public MinStack() {
		this.stack = new Stack<>();
		this.minStack = new Stack<>();
	}

	public void push(int val) {
		this.stack.push(val);

		if (this.minStack.isEmpty() || this.minStack.peek() >= val) {
			this.minStack.push(val);
		}
	}

	public void pop() {
		int popped = this.stack.pop();
		if (this.minStack.peek() == popped) {
			this.minStack.pop();
		}
	}

	public int top() {
		return this.stack.peek();
	}

	public int getMin() {
		return this.minStack.peek();
	}
}

