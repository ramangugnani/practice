package practice.leetcode.problems;

import practice.leetcode.ListNode;

public class SortList_148 {
	public static void main(String[] args) {
		ListNode node_1 = new ListNode(1);
		ListNode node_2 = new ListNode(2);
		ListNode node_3 = new ListNode(3);
		ListNode node_4 = new ListNode(4);

		node_4.next = node_2;
		node_2.next = node_1;
		node_1.next = node_3;

		print(node_1);
		ListNode ans = sortList(node_4);
		print(ans);
	}

	public static ListNode sortList(ListNode head) {
		if(null == head || null == head.next) {
			return head;
		}
		ListNode mid = mid(head);
		ListNode left = sortList(head);
		ListNode right = sortList(mid);
		ListNode ans = merge(left, right);
		return ans;
	}

	public static ListNode mid(ListNode head) {

	}

	public static ListNode merge(ListNode left, ListNode right) {

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
