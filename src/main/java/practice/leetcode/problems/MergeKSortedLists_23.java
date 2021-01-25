package practice.leetcode.problems;

import java.util.Comparator;
import java.util.PriorityQueue;

import javax.swing.UIDefaults.LazyValue;

import practice.leetcode.ListNode;

public class MergeKSortedLists_23 {

    public static void main(String[] args) {
        ListNode[] lists = new ListNode[3];

        ListNode node1_1 = new ListNode(1);
        ListNode node1_2 = new ListNode(4);
        node1_1.next = node1_2;
        ListNode node1_3 = new ListNode(5);
        node1_2.next = node1_3;

        ListNode node2_1 = new ListNode(1);
        ListNode node2_2 = new ListNode(3);
        node2_1.next = node2_2;
        ListNode node2_3 = new ListNode(4);
        node2_2.next = node2_3;

        ListNode node3_1 = new ListNode(2);
        ListNode node3_2 = new ListNode(6);
        node3_1.next = node3_2;
        ListNode node3_3 = new ListNode(8);
        node3_2.next = node3_3;

        lists[0] = node1_1;
        lists[1] = node2_1;
        lists[2] = node3_1;

        for (int i = 0; i < lists.length; i++) {
            print(lists[i]);
        }

        ListNode ans = mergeKLists(lists);
        print(ans);
    }

    public static ListNode mergeKLists(ListNode[] lists) {
        ListNode root = new ListNode(Integer.MIN_VALUE);
        ListNode temp = root;
        PriorityQueue<ListNode> myQ = new PriorityQueue<>(new MyComp());
        for(int i = 0; i < lists.length ; i++) {
            ListNode node = lists[i];
            if(null != node) {
                myQ.add(node);
            }
        }
        while(myQ.size() > 0){
            ListNode node = myQ.poll();
            temp.next = node;
            temp = temp.next;
            if(null != node.next) {
                myQ.add(node.next);
            }
        }
        return root.next;
    }

    public static class MyComp implements Comparator<ListNode> {

        @Override
        public int compare(ListNode o1, ListNode o2) {
            return o1.val - o2.val;
        }

    }

    public static void print(ListNode list) {
        ListNode temp = list;
        while (temp != null) {
            System.out.print(temp.val + "-->");
            temp = temp.next;
        }
        System.out.println();
    }
}
