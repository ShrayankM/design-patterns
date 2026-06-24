package org.example.dsa;

import org.example.dsa.ReorderLinkedList.ListNode;

import java.util.List;

public class TempMain {
	public static void main(String[] args) {
		ReorderLinkedList reorderLinkedList = new ReorderLinkedList();

//		ListNode a = new ListNode(1, new ListNode(2, new ListNode(4, new ListNode(6))));
		ListNode b = new ListNode(2, new ListNode(3, new ListNode(5, new ListNode(8, new ListNode(9)))));

//		ListNode merged = mergeTwoSortedLists.mergeTwoLists(a, b);
		reorderLinkedList.reorderList(b);

		// Expected: 4 -> 3 -> 2 -> 1 -> null
		StringBuilder sb = new StringBuilder();
		for (ListNode cur = b; cur != null; cur = cur.next) {
			sb.append(cur.val);
			if (cur.next != null) sb.append(" -> ");
		}
		System.out.println(sb);
	}
}