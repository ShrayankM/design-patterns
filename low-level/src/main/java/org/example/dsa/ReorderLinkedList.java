package org.example.dsa;

import java.util.Stack;

public class ReorderLinkedList {
	public static class ListNode {
		int val;
		ListNode next;
		ListNode() {}
		ListNode(int val) { this.val = val; }
		ListNode(int val, ListNode next) { this.val = val; this.next = next; }
	}

	public void reorderList(ListNode head) {
		ListNode t = head;
		int nodesInList = 0;

		while (t != null) {
			nodesInList++;
			t = t.next;
		}

		int mid = (nodesInList % 2) == 0 ? (nodesInList / 2) - 1 : (nodesInList / 2);
		t = head;
		int index = 0;

		while (index < mid) {
			t = t.next;
			index++;
		}
		ListNode secondHalf = t.next;
		t.next = null;

		Stack<ListNode> stack = new Stack<>();
		while (secondHalf != null) {
			stack.push(secondHalf);
			secondHalf = secondHalf.next;
		}

		ListNode start = head;
		while (!stack.isEmpty()) {
			ListNode popped = stack.pop();
			ListNode startNext = start.next;

			start.next = popped;
			popped.next = startNext;
			start = startNext;
		}
	}
}
