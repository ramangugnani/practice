package practice.leetcode.problems;

import practice.leetcode.TreeNode;

public class LowestCommonAncestorOfaBinaryTree_236 {
    public static void main(String[] args) {
        TreeNode node0 = new TreeNode(0);
        TreeNode node8 = new TreeNode(8);

        TreeNode node1 = new TreeNode(1, node0, node8);

        TreeNode node4 = new TreeNode(4);
        TreeNode node7 = new TreeNode(7);

        TreeNode node2 = new TreeNode(2, node7, node4);
        TreeNode node6 = new TreeNode(6);

        TreeNode node5 = new TreeNode(5, node6, node2);

        TreeNode root = new TreeNode(3, node5, node1);
        TreeNode result = lowestCommonAncestor(root, node5, node1);
        System.out.println(result.val);
        
        result = lowestCommonAncestor(root, node5, node6);
        System.out.println(result.val);
        
    }

    public static TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        TreeNode result = new TreeNode(Integer.MAX_VALUE);
        lowestCommonAncestorInner(root, p, q, result);
        return result;
    }

    public static boolean lowestCommonAncestorInner(TreeNode root, TreeNode p, TreeNode q, TreeNode result) {
        if (null == root) {
            return false;
        } else {
            boolean leftResult = false;
            boolean rightResult = false;
            if (null != root.left) {
                leftResult = lowestCommonAncestorInner(root.left, p, q, result);
            }

            if (null != root.right) {
                rightResult = lowestCommonAncestorInner(root.right, p, q, result);
            }
            // System.out.println(leftResult + " " + rightResult + " " + root.val);
            if (leftResult == true && rightResult == true && Integer.MAX_VALUE == result.val) {
                // System.out.println("here");
                result.val = root.val;
            }
            if ((leftResult == true || rightResult == true) && (p.val == root.val || q.val == root.val)) {
                // System.out.println("here2");
                result.val = root.val;
            }
            return root.val == p.val || root.val == q.val || leftResult || rightResult;
        }

    }
}
