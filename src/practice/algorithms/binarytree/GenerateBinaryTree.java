package practice.algorithms.binarytree;

public class GenerateBinaryTree {
	
	public static BinaryTreeNode[] getTrees(){
		BinaryTreeNode[] treeNodes = new BinaryTreeNode[1];
		treeNodes[0] = getTree1();
		return treeNodes;
	}

	private static BinaryTreeNode getTree1(){
		/**
		 * 				  1
		 * 			2			3
		 * 		4		5	6		7
		 */
		BinaryTreeNode node1 = new BinaryTreeNode(1);
		BinaryTreeNode node2 = new BinaryTreeNode(2);
		BinaryTreeNode node3 = new BinaryTreeNode(3);
		BinaryTreeNode node4 = new BinaryTreeNode(4);
		BinaryTreeNode node5 = new BinaryTreeNode(5);
		BinaryTreeNode node6 = new BinaryTreeNode(6);
		BinaryTreeNode node7 = new BinaryTreeNode(7);
		
		
		node1.setLeftNode(node2);
		node1.setRightNode(node3);
		
		node2.setLeftNode(node4);
		node2.setRightNode(node5);
		
		node3.setLeftNode(node6);
		node3.setRightNode(node7);
		
		return node1;
	}
}
