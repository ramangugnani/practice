package practice.leetcode.problems;

import practice.leetcode.TreeNode;

public class MaximumBinaryTree_654 {
    public static void main(String[] args) {
        System.out.println("===== 1 ====");
        print(constructMaximumBinaryTree(new int[] { 3, 2, 1, 6, 0, 5 }));
        System.out.println("===== 2 ====");
        print(constructMaximumBinaryTree(new int[] { 3, 2, 1 }));

    }

    public static TreeNode constructMaximumBinaryTree(int[] nums) {
        Integer index = -1;
        Integer value = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > value) {
                value = nums[i];
                index = i;
            }
        }
        TreeNode root = new TreeNode(value);
        tarverse(root, nums, 0, index - 1, index + 1, nums.length - 1);
        return root;
    }

    private static void tarverse(TreeNode root, int[] nums, int leftLowerValue, int leftHigherValue,
            int rightLowerValue, int rightHigherValue) {
        if (leftLowerValue > leftHigherValue) {
            root.left = null;
        } else {
            // create left tree
            Integer index = -1;
            Integer value = Integer.MIN_VALUE;
            for (int i = leftLowerValue; i <= leftHigherValue; i++) {
                if (nums[i] > value) {
                    value = nums[i];
                    index = i;
                }
            }
            TreeNode node = new TreeNode(value);
            root.left = node;
            tarverse(node, nums, leftLowerValue, index - 1, index + 1, leftHigherValue);
        }

        if (rightLowerValue > rightHigherValue) {
            root.right = null;
        } else {
            // create right tree
            Integer index = -1;
            Integer value = Integer.MIN_VALUE;
            for (int i = rightLowerValue; i <= rightHigherValue; i++) {
                if (nums[i] > value) {
                    value = nums[i];
                    index = i;
                }
            }
            TreeNode node = new TreeNode(value);
            root.right = node;
            tarverse(node, nums, rightLowerValue, index - 1, index + 1, rightHigherValue);
        }
    }

    public static void print(TreeNode root) {
        if (null == root) {
            return;
        }
        System.out.println(root.val);
        print(root.left);
        print(root.right);
    }

}
