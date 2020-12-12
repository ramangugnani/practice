package practice.leetcode.may.week3;

import java.util.List;

import practice.leetcode.TreeNode;

public class KthSmallestElementInaBst {
	public static void main(String[] args) {
		TreeNode root = new TreeNode(1);
		
		TreeNode node1 =  new TreeNode(2);
		//TreeNode node4 =  new TreeNode(4);
		//TreeNode node2 =  new TreeNode(2);

		//root.left = node1;
		root.right = node1;
		
		//node1.right = node2;
		int result = kthSmallest(root, 2);
		System.out.println("result --> "+result);
	}
	
	public static int kthSmallest(TreeNode root, int k) {		
		List<Integer> result = inorder( root,  k);
		return 0;
	}

	private static List<Integer> inorder(TreeNode root, int k) {
		Output output = new Output();
		output.index = 0;
		
		//Visit left node
		Output leftResult = null;
		if(null != root.left) {
			leftResult = inorder(root.left, k);
		}
		if(null != leftResult) {
			if(null != leftResult.kThSmallestValue) {
				return leftResult;
			}
			output.index = leftResult.index;
			if(output.index == k) {
				output.kThSmallestValue = root.left.val;
			}
		}
		
		
		//Visit center node
		output.index++;
		//System.out.println("VISITING "+root.val + " --> " + output.toString());
		if(output.index == k) {
			output.kThSmallestValue = root.val;
			//System.out.println("VISITIED "+root.val + " --> " + output.toString());
			return output;
		}
		
		//Visit right node
		Output rightResult = null;
		if(null != root.right) {
			rightResult = inorder(root.right, k);
		}
		if(null != rightResult) {
			if(null != rightResult.kThSmallestValue) {
				return rightResult;
			}
			output.index = output.index + rightResult.index;
			if(output.index == k) {
				output.kThSmallestValue = root.right.val;
			}
		}
		
		return output;
	}
	
	private static class Output{
		public Integer kThSmallestValue;
		public int index;
		/* (non-Javadoc)
		 * @see java.lang.Object#toString()
		 */
		@Override
		public String toString() {
			return "Output [kThSmallestValue=" + kThSmallestValue + ", index=" + index + "]";
		}	
		
	}
}


