package practice.leetcode.problems;

import java.util.LinkedList;
import java.util.Queue;

import practice.leetcode.TreeNode;

public class MaximumWidthOfBinaryTree_662 {
    public static void main(String[] args) {
        TreeNode node5 = new TreeNode(5);
        TreeNode node3 = new TreeNode(3);

        TreeNode node4 = new TreeNode(4, node3, node5);

        TreeNode node9 = new TreeNode(9);
        TreeNode node2 = new TreeNode(2, null, node9);

        TreeNode node1 = new TreeNode(2, node4, node2);
        System.out.println(widthOfBinaryTree(node1));

        TreeNode node1_1 = new TreeNode(Integer.MIN_VALUE);
        TreeNode node1_3 = new TreeNode(3);

        TreeNode node1_2 = new TreeNode(Integer.MIN_VALUE, node1_1, node1_3);

        System.out.println(widthOfBinaryTree(node1_2));

    }

    public static int widthOfBinaryTree(TreeNode root) {
        if (root == null) {
            return 0;
        }
        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        root.val = 0;
        int max = 1;
        while (!queue.isEmpty()) {
            int size = queue.size();
            max = Math.max(max, queue.peekLast().val - queue.peekFirst().val + 1);
            for (int i = 0; i < size; i++) {
                root = queue.poll();
                if (root.left != null) {
                    root.left.val = root.val * 2;
                    queue.offer(root.left);
                }
                if (root.right != null) {
                    root.right.val = root.val * 2 + 1;
                    queue.offer(root.right);
                }
            }
        }
        return max;
    }

}
