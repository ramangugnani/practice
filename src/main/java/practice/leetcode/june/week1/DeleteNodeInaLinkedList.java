package practice.leetcode.june.week1;

import practice.leetcode.ListNode;

public class DeleteNodeInaLinkedList {
	public static void main(String[] args) {
		ListNode node1 = new ListNode(4);
		ListNode node2 = new ListNode(5);
		ListNode node3 = new ListNode(1);
		ListNode node4 = new ListNode(9);
		
		node1.next = node2;
		node2.next = node3;
		node3.next = node4;
		
		print(node1);
		deleteNode(node3);
		print(node1);
		
	}

	public static void deleteNode(ListNode node) {
        node.val = node.next.val;
        node.next = node.next.next;
    }
	
    private static void print(ListNode node) {
		while(node != null) {
			System.out.print(node.val+" ");
			node = node.next;
		}
		System.out.println();
	}
}
