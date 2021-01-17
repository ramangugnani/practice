package practice.leetcode.problems;

import practice.leetcode.ListNode;

public class AddTwoNumbers_2 {
    public static void main(String[] args) {
        ListNode l1_1 = new ListNode(2);
        ListNode l1_2 = new ListNode(4);
        ListNode l1_3 = new ListNode(3);
        l1_1.next = l1_2;
        l1_2.next = l1_3;

        ListNode l2_1 = new ListNode(5);
        ListNode l2_2 = new ListNode(6);
        ListNode l2_3 = new ListNode(4);
        l2_1.next = l2_2;
        l2_2.next = l2_3;

        print(l1_1);
        print(l2_1);
        ListNode ans = addTwoNumbers(l1_1, l2_1);
        print(ans);

        ListNode l3_1 = new ListNode(9);

        ListNode l4_1 = new ListNode(9);

        print(l3_1);
        print(l4_1);
        ans = addTwoNumbers(l3_1, l4_1);
        print(ans);

        ListNode l5_1 = new ListNode(0);

        ListNode l6_1 = new ListNode(0);

        print(l5_1);
        print(l6_1);
        ans = addTwoNumbers(l5_1, l6_1);
        print(ans);

        ListNode l7_1 = new ListNode(9);
        ListNode l7_2 = new ListNode(9);
        ListNode l7_3 = new ListNode(9);
        ListNode l7_4 = new ListNode(9);
        ListNode l7_5 = new ListNode(9);
        ListNode l7_6 = new ListNode(9);
        ListNode l7_7 = new ListNode(9);
        l7_1.next = l7_2;
        l7_2.next = l7_3;
        l7_3.next = l7_4;
        l7_4.next = l7_5;
        l7_5.next = l7_6;
        l7_6.next = l7_7;

        ListNode l8_1 = new ListNode(9);
        ListNode l8_2 = new ListNode(9);
        ListNode l8_3 = new ListNode(9);
        ListNode l8_4 = new ListNode(9);
        l8_1.next = l8_2;
        l8_2.next = l8_3;
        l8_3.next = l8_4;

        print(l7_1);
        print(l8_1);
        ans = addTwoNumbers(l7_1, l8_1);
        print(ans);

    }

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode root = new ListNode(0);
        ListNode trav = root;
        Integer carry = 0;
        while (l1 != null && l2 != null) {
            Integer sum = l1.val + l2.val + carry;
            ListNode node = new ListNode(sum % 10);
            trav.next = node;
            trav = trav.next;
            carry = sum / 10;
            l1 = l1.next;
            l2 = l2.next;
        }
        while (l1 != null) {
            Integer sum = l1.val + carry;
            ListNode node = new ListNode(sum % 10);
            trav.next = node;
            trav = trav.next;
            carry = sum / 10;
            l1 = l1.next;
        }
        while (l2 != null) {
            Integer sum = l2.val + carry;
            ListNode node = new ListNode(sum % 10);
            trav.next = node;
            trav = trav.next;
            carry = sum / 10;
            l2 = l2.next;
        }
        if (carry > 0) {
            ListNode node = new ListNode(carry);
            trav.next = node;
        }

        return root.next;
    }

    public static void print(ListNode l) {
        ListNode temp = l;
        while (temp != null) {
            System.out.print(temp.val + " ");
            temp = temp.next;
        }
        System.out.println();
        return;
    }
}
