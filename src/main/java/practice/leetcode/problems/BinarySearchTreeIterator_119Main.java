package practice.leetcode.problems;

import practice.leetcode.may.week3.TreeNode;

public class BinarySearchTreeIterator_119Main {
    public static void main(String[] args) {
        TreeNode node9 = new TreeNode(9);
        TreeNode node20 = new TreeNode(20);

        TreeNode node15 = new TreeNode(15,node9,node20);
        
        TreeNode node3 = new TreeNode(3);
        
        TreeNode root = new TreeNode(7,node3,node15);
        BinarySearchTreeIterator_119 itr = new BinarySearchTreeIterator_119(root);
        System.out.println("NORMAL");
        itr.print(root);
        System.out.println("ITR");
        while(itr.hasNext()) {
            System.out.println(itr.next());
        }
    }
}
