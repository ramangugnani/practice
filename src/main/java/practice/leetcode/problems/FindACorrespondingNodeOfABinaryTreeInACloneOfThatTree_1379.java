package practice.leetcode.problems;

import practice.leetcode.TreeNode;

public class FindACorrespondingNodeOfABinaryTreeInACloneOfThatTree_1379 {

    public static void main(String[] args) {
        TreeNode o1_6 = new TreeNode(6);
        TreeNode o1_19 = new TreeNode(19);
        TreeNode o1_4 = new TreeNode(4);
        TreeNode o1_3 = new TreeNode(3, o1_6, o1_19);
        TreeNode o1_7 = new TreeNode(6, o1_4, o1_3);

        TreeNode o2_6 = new TreeNode(6);
        TreeNode o2_19 = new TreeNode(19);
        TreeNode o2_4 = new TreeNode(4);
        TreeNode o2_3 = new TreeNode(3, o2_6, o2_19);
        TreeNode o2_7 = new TreeNode(6, o2_4, o2_3);

        System.out.println(o1_3.val + " " + o1_3);
        TreeNode node = getTargetCopy(o1_7, o2_7, o1_3);
        System.out.println(o2_3.val + " " + o2_3);
        System.out.println(node.val + " " + node);
    }

    public static final TreeNode getTargetCopy(final TreeNode original, final TreeNode cloned, final TreeNode target) {
        if (original == target) {
            return cloned;
        }
        if(original.left != null) {
            TreeNode left = getTargetCopy(original.left, cloned.left, target);
            if (null != left) {
                return left;
            }
        }
        if(original.right != null) {
            return getTargetCopy(original.right, cloned.right, target);
        }
        return null;
    }
}
