package org.example.dsa;

public class ReverseLinkedList {
	public static class ListNode {
		 int val;
		 ListNode next;
		 ListNode() {}
		 ListNode(int val) { this.val = val; }
		 ListNode(int val, ListNode next) { this.val = val; this.next = next; }
	}

	public ListNode reverseList(ListNode head) {
		if (head == null) return null;
		if (head.next == null) return head;

		ListNode prev = null;
		ListNode nextNode = head.next;

		while (true) {
			head.next = prev;
			prev = head;
			head = nextNode;

			if (head == null) break;
			nextNode = nextNode.next;
		}
		return prev;
	}

}


// prev -> 4 -> 3 -> 2 -> 1 -> null
// head -> *
// next -> *