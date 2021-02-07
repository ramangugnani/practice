package practice.leetcode.problems;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import practice.leetcode.TreeNode;

public class VerticalOrderTraversalOfaBinaryTree_987 {
	public static void main(String[] args) {

		TreeNode node_4 = new TreeNode(4);
		TreeNode node_5 = new TreeNode(5);
		TreeNode node_6 = new TreeNode(6);
		TreeNode node_7 = new TreeNode(7);

		TreeNode node_2 = new TreeNode(2, node_4, node_6);
		TreeNode node_3 = new TreeNode(3, node_5, node_7);

		TreeNode root = new TreeNode(1, node_2, node_3);
		System.out.println(verticalTraversal(root));
	}

	public static List<List<Integer>> verticalTraversal(TreeNode root) {
		Map<Integer, List<Integer>> myMap = new TreeMap<>();
		List<List<Integer>> ans = new ArrayList<List<Integer>>();
		traverse(root, 0, myMap);
		// System.out.println(myMap);
		for (Map.Entry<Integer, List<Integer>> entry : myMap.entrySet()) {
			Collections.sort(entry.getValue());
			ans.add(entry.getValue());
		}
		return ans;
	}

	public static void traverse(TreeNode root, Integer index, Map<Integer, List<Integer>> myMap) {
		if (null == root) {
			return;
		} else {
			List<Integer> myList = myMap.getOrDefault(index, new ArrayList<>());
			myMap.put(index, myList);
			myList.add(root.val);
			traverse(root.left, index - 1, myMap);
			traverse(root.right, index + 1, myMap);
		}
	}
}
