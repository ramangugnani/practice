package practice.leetcode.problems;

import practice.leetcode.TreeNode;

public class ValidateBinarySearchTree_98 {
    public static void main(String[] args) {
        TreeNode node1 = new TreeNode(1);
        TreeNode node3 = new TreeNode(3);

        TreeNode node2 = new TreeNode(2, node1, node3);

        System.out.println(isValidBST(node2));

        TreeNode node1_1 = new TreeNode(Integer.MIN_VALUE);
        TreeNode node1_3 = new TreeNode(3);

        TreeNode node1_2 = new TreeNode(Integer.MIN_VALUE, node1_1, node1_3);

        System.out.println(isValidBST(node1_2));

    }

    public static Integer lastValue = null;

    public static Boolean isValidBST = true;

    public static boolean isValidBST(TreeNode root) {
        traverse(root);
        return isValidBST;
    }

    public static void traverse(TreeNode root) {
        if(isValidBST == false) {
            return;
        }
        if (null == root) {
            return;
        } else {
            traverse(root.left);
            Integer value = root.val;
            if (null == lastValue || value > lastValue) {
                lastValue = value;
            } else {
                isValidBST = false;
            }
            traverse(root.right);
        }
    }
}
