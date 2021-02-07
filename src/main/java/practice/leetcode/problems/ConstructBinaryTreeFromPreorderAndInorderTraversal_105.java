package practice.leetcode.problems;

import practice.leetcode.TreeNode;

public class ConstructBinaryTreeFromPreorderAndInorderTraversal_105 {
	public static void main(String[] args) {
		TreeNode root = buildTree(new int[] { 3, 9, 20, 15, 7 }, new int[] { 9, 3, 15, 20, 7 });
		printTree(root);
	}

	public static TreeNode buildTree(int[] preorder, int[] inorder) {
		return buildSubTree(preorder, inorder, 0, 0, inorder.length - 1);
	}

	public static TreeNode buildSubTree(int[] preorder, int[] inorder, int preStart, int inStart, int inEnd) {
		if (preStart > preorder.length - 1 || inStart > inEnd) {
			return null;
		} else {
			TreeNode node = new TreeNode(preorder[preStart]);

			int inIndex = 0; // Index of current root in inorder
			for (int i = inStart; i <= inEnd; i++) {
				if (inorder[i] == node.val) {
					inIndex = i;
				}
			}

			// iterate tree from inStart to inIndex -1
			node.left = buildSubTree(preorder, inorder, preStart + 1, inStart, inIndex - 1);

			// iterate tree from inIndex +1 to inEnd
			// pre Index will be addition of nodes count in left sub tree)
			node.right = buildSubTree(preorder, inorder, preStart + (inIndex - inStart + 1), inIndex + 1, inEnd);

			return node;
		}
	}

	public static void printTree(TreeNode root) {
		if (null == root) {
			return;
		} else {
			System.out.println(root.val);
			printTree(root.left);
			printTree(root.right);
		}
	}

}
