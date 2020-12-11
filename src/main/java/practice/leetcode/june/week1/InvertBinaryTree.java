package practice.leetcode.june.week1;

import practice.leetcode.may.week3.TreeNode;

public class InvertBinaryTree {
	public static void main(String[] args) {
		TreeNode root = new TreeNode(4);
		
		TreeNode node1 = new TreeNode(2);
		TreeNode node2 = new TreeNode(7);
		TreeNode node3 = new TreeNode(1);
		TreeNode node4 = new TreeNode(3);
		TreeNode node5 = new TreeNode(6);
		TreeNode node6 = new TreeNode(9);
		
		root.left = node1;
		root.right = node2;
		
		node1.left = node3;
		node1.right = node4;
		
		node2.left = node5;
		node2.right = node6;
		
		TreeNode result = invertTree(root);
	}

	public static TreeNode invertTree(TreeNode root) {

        if(null == root){
            return null;
        }
        
		TreeNode rootMirror = new TreeNode(root.val);
		
		if(null != root.left) {
			rootMirror.right = invertTree(root.left);
		}
			
		if(null != root.right) {
			rootMirror.left = invertTree(root.right);
		}
		
		return rootMirror;
	}
}
