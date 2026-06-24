package org.example.dsa;

import org.example.dsa.ReverseLinkedList.ListNode;

public class MergeTwoSortedLists {
	public static class ListNode {
		int val;
		ListNode next;
		ListNode() {}
		ListNode(int val) { this.val = val; }
		ListNode(int val, ListNode next) { this.val = val; this.next = next; }
	}

	public ListNode mergeTwoLists(ListNode a, ListNode b) {
		if (a == null && b == null) return null;
		if (a == null) return b;
		if (b == null) return a;


		ListNode result = new ListNode(-1);
		ListNode t = result;

		while (a != null && b != null) {
			if (a.val <= b.val) {
				t.next = a;
				a = a.next;
			} else {
				t.next = b;
				b = b.next;
			}
			t = t.next;
		}

		if (a == null) t.next = b;
		if (b == null) t.next = a;

		return result.next;
	}
}
