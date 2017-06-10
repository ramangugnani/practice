package practice.algorithms.binarytree;

public class LargestBSTInGivenBinaryTree {
	public static void main(String[] args) {
		int i =0;
		for(BinaryTreeNode binaryTreeNode : GenerateBinaryTree.getTrees() ){
			System.out.println("************************ TREE "+(++i)  + "**************************");
			System.out.println(largestBST(binaryTreeNode));
		}
	}

	/* Returns size of the largest BST subtree in a Binary Tree */
	static int  largestBST(BinaryTreeNode node) {
		MinMax val = largestBSTUtil(node);
		return val.maxSize;
	}

	/* largestBSTUtil() updates *max_size_ref for the size of the largest BST
    subtree.   Also, if the tree rooted with node is non-empty and a BST,
    then returns size of the tree. Otherwise returns 0.*/
	static MinMax largestBSTUtil(BinaryTreeNode node) {

		/* Base Case */
		if (node == null) {
			return new MinMax();    // Size of the BST is 0
		}

        //post order traversal of tree. First visit left and right then
        //use information of left and right to calculate largest BST.
        MinMax leftMinMax = largestBSTUtil(node.getLeftNode());
        MinMax rightMinMax =largestBSTUtil(node.getRightNode());
        
        MinMax m = new MinMax();

        //if either of left or right subtree says its not BST or the data
        //of this node is not greater/equal than max of left and less than minimum of right
        //then subtree with this node as root will not be BST. 
        //Return false and max size of left and right subtree to parent
        if(leftMinMax.isBst == false || rightMinMax.isBst == false || (leftMinMax.max > node.getData() || rightMinMax.min <= node.getData())){
            m.isBst = false;
            m.maxSize = Math.max(leftMinMax.maxSize, rightMinMax.maxSize);
            return m;
        }
        
        //if we reach this point means subtree with this node as root is BST.
        //Set isBST as true. Then set size as size of left + size of right + 1.
        //Set min and max to be returned to parent.
        m.isBst = true;
        m.maxSize = leftMinMax.maxSize + rightMinMax.maxSize + 1;
     
        //if root.left is null then set root.data as min else
        //take min of left side as min
        m.min = node.getLeftNode() != null ? leftMinMax.min : node.getData();
  
        //if root.right is null then set root.data as max else
        //take max of right side as max.
        m.max = node.getRightNode() != null ? rightMinMax.max : node.getData();
   
        return m;
	}
}
