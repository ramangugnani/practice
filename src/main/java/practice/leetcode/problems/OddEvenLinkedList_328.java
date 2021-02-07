package practice.leetcode.problems;

import practice.leetcode.ListNode;

public class OddEvenLinkedList_328 {
	public static void main(String[] args) {
		ListNode node_1 = new ListNode(1);
		 ListNode node_2 = new ListNode(2);
		 ListNode node_3 = new ListNode(3);
		 ListNode node_4 = new ListNode(4);
		 ListNode node_5 = new ListNode(5);
		 node_1.next = node_2;
		 node_2.next = node_3;
		 node_3.next = node_4;
		 node_4.next = node_5;

		print(node_1);
		ListNode ans = oddEvenList(node_1);
		print(ans);

	}

	public static ListNode oddEvenList(ListNode head) {
		if (null == head) {
			return null;
		}
		ListNode temp = head;

		ListNode oddH = temp;
		temp = temp.next;
		ListNode evenH = null;
		if (temp != null) {
			evenH = temp;
			temp = temp.next;
		}

		ListNode oddHItr = oddH;
		ListNode evenHItr = evenH;

		while (temp != null) {
			oddHItr.next = temp;
			oddHItr = oddHItr.next;
			temp = temp.next;
			if (temp != null) {
				evenHItr.next = temp;
				evenHItr = evenHItr.next;
				temp = temp.next;
			}
		}
		oddHItr.next = null;
		if (null != evenHItr) {
			evenHItr.next = null;
		}
		// print(oddH);
		// print(evenH);

		oddHItr.next = evenH;
		return oddH;
	}

	public static void print(ListNode head) {
		ListNode temp = head;
		while (temp != null) {
			System.out.print(temp.val + " ");
			temp = temp.next;
		}
		System.out.println();
	}

}
