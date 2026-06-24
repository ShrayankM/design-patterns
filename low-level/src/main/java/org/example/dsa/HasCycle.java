package org.example.dsa;


public class HasCycle {
	public static class ListNode {
		int val;
		ListNode next;
		ListNode() {}
		ListNode(int val) { this.val = val; }
		ListNode(int val, ListNode next) { this.val = val; this.next = next; }
	}

	public boolean hasCycle(ListNode head) {
		if (head == null) return false;
		if (head.next == null) return false;

		ListNode fast = head;
		ListNode slow = head;

		while (fast != null) {
			fast = fast.next.next;
			slow = slow.next;

			if (fast == slow) return true;
		}
		return false;
	}
}
