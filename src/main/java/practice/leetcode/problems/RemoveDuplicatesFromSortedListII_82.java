package practice.leetcode.problems;

import practice.leetcode.ListNode;

public class RemoveDuplicatesFromSortedListII_82 {

	public static void main(String[] args) {
		ListNode node1 = new ListNode(1);
		ListNode node2 = new ListNode(1);
		ListNode node3 = new ListNode(3);
		ListNode node4 = new ListNode(4);
		ListNode node5 = new ListNode(4);
		ListNode node6 = new ListNode(4);

		node1.next = node2;
		node2.next = node3;
		node3.next = node4;
		node4.next = node5;
		node5.next = node6;

		print(node1);
		ListNode node = deleteDuplicates(node1);
		print(node);

	}

	public static ListNode deleteDuplicates(ListNode head) {
		ListNode root = new ListNode(-101);
		ListNode traverse = root;
		ListNode temp = head;
		ListNode previous = head;
		Boolean deletePreviousNode = false;
		while (temp != null) {
			// if previous value != current value add the node
			if (traverse.val != temp.val) {
				if(deletePreviousNode) {
					traverse = previous;
					deletePreviousNode = false;
				}
				previous = traverse;
				
				traverse.next = temp;
				traverse = traverse.next;
				temp = temp.next;
			} else {
				// else skip the node
				deletePreviousNode = true;
				temp = temp.next;
			}
		}
		if(deletePreviousNode) {
			previous.next = null;
		}
		return root.next;
	}

	public static void print(ListNode head) {
		ListNode temp = head;
		if (null == temp) {
			return;
		}
		while (temp != null) {
			System.out.print(temp.val + " ");
			temp = temp.next;
		}
		System.out.println();
	}
}
