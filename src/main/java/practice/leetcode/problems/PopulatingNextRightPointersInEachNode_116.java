package practice.leetcode.problems;

import java.util.LinkedList;
import java.util.Queue;

public class PopulatingNextRightPointersInEachNode_116 {
    public static void main(String[] args) {

        Node node4 = new Node(4);
        Node node5 = new Node(5);
        Node node6 = new Node(6);
        Node node7 = new Node(7);

        Node node2 = new Node(2);
        node2.left = node4;
        node2.right = node5;
        Node node3 = new Node(3);
        node3.left = node6;
        node3.right = node7;

        Node node1 = new Node(1);
        node1.left = node2;
        node1.right = node3;
        connect(node1);
    }

    public static Node connect(Node root) {
        if(null == root) {
            return root;
        }
        Queue<Node> myQ = new LinkedList<>();
        myQ.add(root);
        while(myQ.size() > 0) {
            Integer size= myQ.size();
            Node prev = new Node(1);
            for(int i = 0 ; i < size ; i++) {
                Node node = myQ.poll();
                prev.next = node;
                prev = node;
                if(null != node.left) {
                    myQ.add(node.left);
                }
                
                if(null != node.right) {
                    myQ.add(node.right);
                }
            }
            prev.next = null;
        }
        return root;
    }

    public static class Node {
        public int val;
        public Node left;
        public Node right;
        public Node next;

        public Node() {
        }

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, Node _left, Node _right, Node _next) {
            val = _val;
            left = _left;
            right = _right;
            next = _next;
        }
    }
}
