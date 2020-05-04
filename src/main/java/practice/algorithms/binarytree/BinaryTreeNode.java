package practice.algorithms.binarytree;

public class BinaryTreeNode {

	private Integer data;
	private BinaryTreeNode leftNode,rightNode;
	
	public BinaryTreeNode(Integer data) {
		this.data = data;
	}
	public Integer getData() {
		return data;
	}
	public void setData(Integer data) {
		this.data = data;
	}
	public BinaryTreeNode getLeftNode() {
		return leftNode;
	}
	public void setLeftNode(BinaryTreeNode leftNode) {
		this.leftNode = leftNode;
	}
	public BinaryTreeNode getRightNode() {
		return rightNode;
	}
	public void setRightNode(BinaryTreeNode rightNode) {
		this.rightNode = rightNode;
	}
	@Override
	public String toString() {
		return getData()+ " ";
	}
	
}
