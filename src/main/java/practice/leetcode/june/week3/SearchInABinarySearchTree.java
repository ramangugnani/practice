package practice.leetcode.june.week3;

import practice.leetcode.may.week3.TreeNode;

public class SearchInABinarySearchTree {
	public static void main(String[] args) {
		TreeNode node = new TreeNode(2);
		TreeNode node1 = new TreeNode(1);
		TreeNode node2 = new TreeNode(3);

		node.left = node1;
		node.right = node2;

		TreeNode result = searchBST(node, 1);
		if (null == result) {
			System.out.println("null");
		} else {
			System.out.println(result.val);
		}

	}

	public static TreeNode searchBST(TreeNode root, int val) {
		if (null == root) {
			return null;
		} else {
			if (root.val == val) {
				return root;
			} else {
				if (root.val > val) {
					return searchBST(root.left, val);
				} else {
					return searchBST(root.right, val);
				}
			}
		}
	}
}
