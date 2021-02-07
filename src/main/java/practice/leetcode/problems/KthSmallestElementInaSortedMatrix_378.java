package practice.leetcode.problems;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

public class KthSmallestElementInaSortedMatrix_378 {
	public static void main(String[] args) {
		System.out.println(kthSmallest(new int[][] { { 1, 5, 9 }, { 10, 11, 13 }, { 12, 13, 15 } }, 8));

		System.out.println(kthSmallest(new int[][] { { 1, 2 }, { 1, 3 } }, 2));

	}

	public static int kthSmallest(int[][] matrix, int k) {
		Queue<MyNode> myQ = new PriorityQueue<>(new MyNodeComp());
		int size = matrix.length;
		for (int i = 0; i < matrix.length; i++) {
			MyNode node = new MyNode();
			node.row = i;
			node.col = 0;
			node.val = matrix[node.row][node.col];
			myQ.add(node);
		}
		Integer count = 1;
		while (myQ.size() > 0) {
			MyNode node = myQ.poll();
			// System.out.println(node);
			if (count == k) {
				return node.val;
			}
			if (node.col + 1 < size) {
				node.col = node.col + 1;
				node.val = matrix[node.row][node.col];
				myQ.add(node);
			}
			count++;
		}
		return 0;
	}

	public static class MyNode {
		public int row;
		public int col;
		public int val;

		/*
		 * (non-Javadoc)
		 * 
		 * @see java.lang.Object#toString()
		 */
		@Override
		public String toString() {
			return "MyNode [row=" + row + ", col=" + col + ", val=" + val + "]";
		}

	}

	public static class MyNodeComp implements Comparator<MyNode> {

		@Override
		public int compare(MyNode o1, MyNode o2) {
			return o1.val - o2.val;
		}

	}
}
