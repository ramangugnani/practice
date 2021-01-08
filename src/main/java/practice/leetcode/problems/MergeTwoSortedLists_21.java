package practice.leetcode.problems;

import practice.leetcode.ListNode;

public class MergeTwoSortedLists_21 {
	public static void main(String[] args) {
		ListNode l1_1 = new ListNode(1);
		ListNode l1_2 = new ListNode(2);
		ListNode l1_3 = new ListNode(3);
		ListNode l1_4 = new ListNode(4);
		l1_1.next = l1_2;
		l1_2.next = l1_3;
		l1_3.next = l1_4;

		ListNode l2_1 = new ListNode(1);
		ListNode l2_2 = new ListNode(2);
		ListNode l2_3 = new ListNode(5);
		l2_1.next = l2_2;
		l2_2.next = l2_3;

		print(l1_1);
		print(l2_1);
		ListNode l_final = mergeTwoLists(l1_1, l2_1);
		print(l_final);
		l_final = mergeTwoLists(null, null);
		print(l_final);
		l_final = mergeTwoLists(l1_1, null);
		print(l_final);
		l_final = mergeTwoLists(null, l2_1);
		print(l_final);
		
	}

	public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
		if(null == l1) {
			return l2;
		}
		if(null == l2) {
			return l1;
		}
		ListNode node = new ListNode(0);
		ListNode head = node;
		while(null != l1 && null != l2) {
			if(l1.val < l2.val) {
				node.next = l1;
				node = node.next;
				l1 = l1.next;
			}else {
				node.next = l2;
				node = node.next;
				l2 = l2.next;				
			}
		}
		if(null != l1) {
			node.next = l1;
		}
		if(null != l2) {
			node.next = l2;
		}
		return head.next;
	}

	public static void print(ListNode list) {
		if (null == list) {
			return;
		}
		while (null != list) {
			System.out.print(list.val + " ");
			list = list.next;
		}
		System.out.println();
	}
}
