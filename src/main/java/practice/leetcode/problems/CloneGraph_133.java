package practice.leetcode.problems;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import practice.leetcode.Node;

public class CloneGraph_133 {

	public static void main(String[] args) {
		Node node1 = new Node(1);
		Node node2 = new Node(2);
		Node node3 = new Node(3);
		Node node4 = new Node(4);

		List<Node> neighbors1 = new ArrayList<Node>();
		neighbors1.add(node3);
		neighbors1.add(node4);
		node1.neighbors = neighbors1;

		List<Node> neighbors2 = new ArrayList<Node>();
		neighbors2.add(node3);
		neighbors2.add(node4);
		node2.neighbors = neighbors2;

		List<Node> neighbors3 = new ArrayList<Node>();
		neighbors3.add(node1);
		neighbors3.add(node2);
		node3.neighbors = neighbors3;

		List<Node> neighbors4 = new ArrayList<Node>();
		neighbors4.add(node1);
		neighbors4.add(node2);
		node4.neighbors = neighbors4;

		System.out.println(node1.val + " " + node1);
		Node newNode = cloneGraph(node1);
		System.out.println(newNode.val + " " + newNode);

	}

	public static Node cloneGraph(Node node) {
		if(null == node) {
			return null;
		}
		Map<Integer, Set<Integer>> adjancecyList = new HashMap<>();
		traverse(node, adjancecyList);

		Map<Integer, Node> newNodes = new HashMap<>();

		for (Map.Entry<Integer, Set<Integer>> entry : adjancecyList.entrySet()) {
			Node newNode = new Node(entry.getKey());
			newNodes.put(entry.getKey(), newNode);
		}

		for (Map.Entry<Integer, Set<Integer>> entry : adjancecyList.entrySet()) {
			Node newNode = newNodes.get(entry.getKey());
			List<Node> newNodeNeighbors = new ArrayList<>();
			for (Integer newNighbor : entry.getValue()) {
				newNodeNeighbors.add(newNodes.get(newNighbor));
			}
			newNode.neighbors = newNodeNeighbors;
		}

		return newNodes.get(node.val);
	}

	private static void traverse(Node node, Map<Integer, Set<Integer>> adjancecyList) {
		Set<Integer> neighborsSet = new HashSet<>();
		for (Node nod : node.neighbors) {
			neighborsSet.add(nod.val);
		}
		adjancecyList.put(node.val, neighborsSet);

		for (Node nod : node.neighbors) {
			if (!adjancecyList.containsKey(nod.val)) {
				traverse(nod, adjancecyList);
			}
		}
	}
}
