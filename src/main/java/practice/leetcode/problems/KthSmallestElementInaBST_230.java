package practice.leetcode.problems;

import java.util.ArrayList;
import java.util.List;

import practice.leetcode.TreeNode;

public class KthSmallestElementInaBST_230 {

    public static void main(String[] args) {
        TreeNode node2 = new TreeNode(2);

        TreeNode node1 = new TreeNode(1, null, node2);
        TreeNode node4 = new TreeNode(4);

        TreeNode root = new TreeNode(3, node1, node4);
        System.out.println(kthSmallest(root, 4));
    }

    public static int kthSmallest(TreeNode root, int k) {
        List<Integer> list = new ArrayList<>();
        traverse(root, list);
        return list.get(k - 1);
    }

    private static void traverse(TreeNode root, List<Integer> list) {
        if (null == root) {
            return;
        } else {
            traverse(root.left, list);
            list.add(root.val);
            traverse(root.right, list);
        }
    }
}
