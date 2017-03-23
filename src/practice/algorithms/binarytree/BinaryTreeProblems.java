package practice.algorithms.binarytree;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class BinaryTreeProblems {
	public static void main(String[] args) {
		for(BinaryTreeNode binaryTreeNode : GenerateBinaryTree.getTrees() ){
			System.out.println("SIZE OF TREE "+sizeOfTree(binaryTreeNode));
			System.out.println("HEIGHT OF TREE "+heightOfTree(binaryTreeNode));
			
			
			System.out.println("IN ORDER RECURSIVE TRAVERSAL ");
			inorderTraversal(binaryTreeNode);
			System.out.println("\nPRE ORDER RECURSIVE TRAVERSAL ");
			preTraversal(binaryTreeNode);
			System.out.println("\nPOST ORDER RECURSIVE TRAVERSAL ");
			postTraversal(binaryTreeNode);
			System.out.println("\nLEVEL ORDER TRAVERSAL ");
			levelOrderTraversal(binaryTreeNode);

			System.out.println("\nMIRROR LEVEL ORDER TRAVERSAL ");
			BinaryTreeNode reverseBinaryTree = null;
			reverseBinaryTree = mirrorImage(binaryTreeNode);
			levelOrderTraversal(reverseBinaryTree);
			
			System.out.println("\nLEFT VIEW ");
			leftView(binaryTreeNode);
			
			System.out.println("\nRIGHT VIEW ");
			rightView(binaryTreeNode);
			
			System.out.println("\nALL PATH FROM ROOT");
			BinaryTreeNode[] verticalNodes = new BinaryTreeNode[10];
			allPathFromRoot(binaryTreeNode,verticalNodes,0);

			System.out.println("\nDONE ");
		}
	}

	private static void inorderTraversal(BinaryTreeNode root) {
		if(null == root)
			return;
		inorderTraversal(root.getLeftNode());
		System.out.print(root.getData()+ " ");
		inorderTraversal(root.getRightNode());
	}

	private static void preTraversal(BinaryTreeNode root) {
		if(null == root)
			return;
		System.out.print(root.getData()+ " ");
		preTraversal(root.getLeftNode());
		preTraversal(root.getRightNode());
	}

	private static void postTraversal(BinaryTreeNode root) {
		if(null == root)
			return;
		postTraversal(root.getLeftNode());
		postTraversal(root.getRightNode());
		System.out.print(root.getData()+ " ");
	}

	private static void levelOrderTraversal(BinaryTreeNode root) {
		List<BinaryTreeNode>  queue = new ArrayList<>();
		queue.add(root);
		while(queue.size() != 0){
			BinaryTreeNode element = queue.remove(0);
			System.out.print(element.getData()+ " ");
			if(null != element.getLeftNode()){
				queue.add(element.getLeftNode());
			}
			if(null != element.getRightNode()){
				queue.add(element.getRightNode());
			}
		}
	}

	private static BinaryTreeNode mirrorImage(BinaryTreeNode root) {
		if(null == root)
			return root;

		BinaryTreeNode mirrorLeftNode = mirrorImage(root.getLeftNode());
		BinaryTreeNode mirrorRightNode = mirrorImage(root.getRightNode());
		BinaryTreeNode newNode =  new BinaryTreeNode(root.getData());
		newNode.setRightNode(mirrorLeftNode);
		newNode.setLeftNode(mirrorRightNode);
		return  newNode;

	}

	private static int sizeOfTree(BinaryTreeNode root){
		if(null == root)
			return 0;

		return 1 + sizeOfTree(root.getLeftNode()) + sizeOfTree(root.getRightNode());
	}

	private static int heightOfTree(BinaryTreeNode root){
		if(null == root)
			return 0;

		return 1 + Math.max(heightOfTree(root.getLeftNode()) , heightOfTree(root.getRightNode()));
	}

	private static void reverseLevelOrder(BinaryTreeNode root){

	}

	private static void leftView(BinaryTreeNode root){
		if(null == root)
			return;
		
		List<BinaryTreeNode>  queue = new ArrayList<>();
		Map<Integer,ArrayList<Integer>> levelByNodes = new LinkedHashMap<Integer,ArrayList<Integer>>();
		queue.add(root);
		// adding delimeter
		queue.add(null);
		int level = 0;
		
		while(queue.size() != 0){
			BinaryTreeNode element = queue.remove(0);
			if(null == element){
				if(queue.size() == 0)
					break;
				else{
					queue.add(null);
					level++;
					continue;
				}
			}
			ArrayList<Integer> nodes = levelByNodes.get(level);
			if(null == nodes)
				nodes = new ArrayList<>();
			nodes.add(element.getData());
			levelByNodes.put(level, nodes);
			if(null != element.getLeftNode()){
				queue.add(element.getLeftNode());
			}
			if(null != element.getRightNode()){
				queue.add(element.getRightNode());
			}
		}
		
		for(Map.Entry<Integer, ArrayList<Integer>> entry : levelByNodes.entrySet()){
			System.out.print(entry.getValue().get(0)+ " ");
		}
	}
	
	private static void rightView(BinaryTreeNode root){
		if(null == root)
			return;
		
		List<BinaryTreeNode>  queue = new ArrayList<>();
		Map<Integer,ArrayList<Integer>> levelByNodes = new LinkedHashMap<Integer,ArrayList<Integer>>();
		queue.add(root);
		// adding delimeter
		queue.add(null);
		int level = 0;
		
		while(queue.size() != 0){
			BinaryTreeNode element = queue.remove(0);
			if(null == element){
				if(queue.size() == 0)
					break;
				else{
					queue.add(null);
					level++;
					continue;
				}
			}
			ArrayList<Integer> nodes = levelByNodes.get(level);
			if(null == nodes)
				nodes = new ArrayList<>();
			nodes.add(element.getData());
			levelByNodes.put(level, nodes);
			if(null != element.getLeftNode()){
				queue.add(element.getLeftNode());
			}
			if(null != element.getRightNode()){
				queue.add(element.getRightNode());
			}
		}
		for(Map.Entry<Integer, ArrayList<Integer>> entry : levelByNodes.entrySet()){
			System.out.print(entry.getValue().get(entry.getValue().size() -1)+ " ");
		}
	}
	
	private static void allPathFromRoot(BinaryTreeNode root,BinaryTreeNode[] nodes,int level){
		if(null == root)
			return;

		nodes[level] =root;
		if(null == root.getLeftNode() && null == root.getRightNode()){
			for(int i = 0; i <= level ; ++i){
				System.out.print(nodes[i].toString());
			}
			System.out.println();
			return;
		}
		allPathFromRoot(root.getLeftNode(), nodes, level+1);
		allPathFromRoot(root.getRightNode(), nodes, level+1);
	}

}