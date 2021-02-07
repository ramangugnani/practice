package practice.leetcode.problems;

import practice.leetcode.ListNode;

public class RemoveNthNodeFromEndOfList_19 {

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
		ListNode ans = removeNthFromEnd(node_1, 2);
		print(ans);
		
		node_1.next = null;
		print(node_1);
		ans = removeNthFromEnd(node_1, 1);
		print(ans);
		
		node_1.next = node_2;
		node_2.next = null;
		print(node_1);
		ans = removeNthFromEnd(node_1, 1);
		print(ans);
	}

	public static ListNode removeNthFromEnd(ListNode head, int n) {
		ListNode temp = new ListNode(0);
		temp.next = head;
		ListNode ptr1 = temp;
		for(int i = 0; i <= n ; i++) {
			ptr1 = ptr1.next;
		}
		ListNode ptr2 = temp;
		while(ptr1 != null) {
			ptr1 = ptr1.next;
			ptr2 = ptr2.next;
		}
		//System.out.println(ptr2.val);
		ptr2.next = ptr2.next.next;
		return temp.next;
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
