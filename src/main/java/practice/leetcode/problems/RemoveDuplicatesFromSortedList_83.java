package practice.leetcode.problems;

import practice.leetcode.ListNode;

public class RemoveDuplicatesFromSortedList_83 {
    public static void main(String[] args) {
        ListNode listNode_1 = new ListNode(1);
        ListNode listNode_4 = new ListNode(1);
        ListNode listNode_2 = new ListNode(2);
        ListNode listNode_3 = new ListNode(3);
        ListNode listNode_5 = new ListNode(3);

        listNode_1.next = listNode_4;
        listNode_4.next = listNode_2;
        listNode_2.next = listNode_3;
        listNode_3.next = listNode_5;
        print(listNode_1);
        ListNode ans = deleteDuplicates(listNode_1);
        print(ans);
    }

    private static void print(ListNode ans) {
        while (ans != null) {
            System.out.print(ans.val + "-->");
            ans = ans.next;
        }
        System.out.println();

    }

    public static ListNode deleteDuplicates(ListNode head) {
        ListNode temp = new ListNode(-101);
        ListNode itr = head;
        ListNode prev = temp;
        temp.next = head;
        while (null != itr) {
            if (prev.val == itr.val) {
                prev.next = itr.next;
                itr = itr.next;
            } else {
                prev = itr;
                itr = itr.next;
            }
        }
        return temp.next;
    }
}
