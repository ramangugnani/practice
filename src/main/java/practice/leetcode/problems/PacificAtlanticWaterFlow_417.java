package practice.leetcode.problems;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class PacificAtlanticWaterFlow_417 {

	public static void main(String[] args) {
		int[][] matrix = new int[][] { { 1, 2, 2, 3, 5 }, { 3, 2, 3, 4, 4 }, { 2, 4, 5, 3, 1 }, { 6, 7, 1, 4, 5 },
				{ 5, 1, 1, 2, 4 } };
		System.out.println(pacificAtlantic(matrix));
	}

	public static int[][] directions = new int[][] { { 0, 1 }, { 0, -1 }, { 1, 0 }, { -1, 0 } };

	public static Set<String> mySet = new HashSet<>();

	public static List<List<Integer>> pacificAtlantic(int[][] matrix) {
		List<List<Integer>> answer = new ArrayList<>();
		Integer maxRows = matrix.length;
		Integer maxCols = matrix[0].length;
		for (int row = 0; row < maxRows; row++) {
			for (int col = 0; col < maxCols; col++) {
				System.out.println("starting "+row + " " + col);
				IsTraverseBoth isPossible = traverse(matrix, row, col, maxRows, maxCols);
				if (isPossible.reachedAtlantic && isPossible.reachedPacific) {
					System.out.println("adding "+row + " " + col);
					List<Integer> res = new ArrayList<>();
					res.add(row);
					res.add(col);
					mySet.add(row + "-" + col);
					answer.add(res);
				}
				System.out.println("\n\n\n");
			}
		}
		return answer;
	}

	public static IsTraverseBoth traverse(int[][] matrix, int row, int col, Integer maxRows, Integer maxCols) {
		System.out.println(row + " " + col);
		if (row < 0 || col < 0) {
			IsTraverseBoth isTraverseBoth = new IsTraverseBoth();
			isTraverseBoth.reachedPacific = true;
			return isTraverseBoth;
		} else if (row >= maxRows || col >= maxCols) {
			IsTraverseBoth isTraverseBoth = new IsTraverseBoth();
			isTraverseBoth.reachedAtlantic = true;
			return isTraverseBoth;
		} else {
			// node has not reached boundary
			// check if either this node already can reach boundary
			if (mySet.contains(row + "-" + col)) {
				IsTraverseBoth isTraverseBoth = new IsTraverseBoth();
				isTraverseBoth.reachedAtlantic = true;
				isTraverseBoth.reachedPacific = true;
				return isTraverseBoth;
			} else {
				// check if it can reach its boundaries
				IsTraverseBoth isTraverseBoth = new IsTraverseBoth();
				IsTraverseBoth isTraverseInt = null;
				for (int direction = 0; direction < directions.length; direction++) {
					if (row + directions[direction][0] < 0 || row + directions[direction][0] >= maxRows
							|| col + directions[direction][1] < 0 || col + directions[direction][1] >= maxCols) {
						isTraverseInt = traverse(matrix, row + directions[direction][0], col + directions[direction][1],
								maxRows, maxCols);
					} else if (matrix[row + directions[direction][0]][col
							+ directions[direction][1]] <= matrix[row][col]) {
						isTraverseInt = traverse(matrix, row + directions[direction][0], col + directions[direction][1],
								maxRows, maxCols);
					}
				}
				isTraverseBoth.reachedAtlantic = isTraverseBoth.reachedAtlantic || isTraverseInt.reachedAtlantic;
				isTraverseBoth.reachedPacific = isTraverseBoth.reachedPacific || isTraverseInt.reachedPacific;
				return isTraverseBoth;
			}

		}
	}

	public static class IsTraverseBoth {
		public Boolean reachedPacific = false;

		public Boolean reachedAtlantic = false;

	}
}
