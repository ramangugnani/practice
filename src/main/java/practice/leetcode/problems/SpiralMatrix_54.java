package practice.leetcode.problems;

import java.util.ArrayList;
import java.util.List;

public class SpiralMatrix_54 {
	public static void main(String[] args) {
		System.out.println(spiralOrder(new int[][] { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 } }));

		System.out.println(spiralOrder(new int[][] { { 1, 2, 3, 4 }, { 5, 6, 7, 8 }, { 9, 10, 11, 12 } }));

		System.out.println(
				spiralOrder(new int[][] { { 1, 2, 3, 4 }, { 5, 6, 7, 8 }, { 9, 10, 11, 12 }, { 13, 14, 15, 16 } }));

	}

	public static List<Integer> spiralOrder(int[][] matrix) {
		List<Integer> ans = new ArrayList<Integer>();
		int rowMax = matrix.length - 1;
		int colMax = matrix[0].length - 1;
		int rowMin = 0;
		int colMin = 0;
		int direction = 1;
		int i = 0;
		int j = 0;
		while (rowMin < rowMax && colMin < colMax) {

			if (direction == 1) {
				// go right
				// columns will be changed row will remain same
				for (; j < colMax; j++) {
					// System.out.println("R " + i + "," + j);
					ans.add(matrix[i][j]);
				}
			} else if (direction == 2) {
				// go down
				// rows will be changed column will remain same
				for (; i < rowMax; i++) {
					// System.out.println("D " + i + "," + j);
					ans.add(matrix[i][j]);
				}

			} else if (direction == 3) {
				// go left
				// columns will be changed row will remain same
				for (; j > colMin; j--) {
					// System.out.println("L " + i + "," + j);
					ans.add(matrix[i][j]);
				}
			} else if (direction == 0) {
				// go up
				// rows will be changed column will remain same
				for (; i > rowMin; i--) {
					// System.out.println("U " + i + "," + j);
					ans.add(matrix[i][j]);
				}

				// reset the locations once down
				rowMin++;
				colMin++;
				rowMax--;
				colMax--;
				i = rowMin;
				j = colMin;
			}
			direction = (direction + 1) % 4;
		}
		if (rowMin == rowMax && colMin == colMax) {
			// System.out.println("S " + rowMin + "," + colMin);
			ans.add(matrix[rowMin][colMin]);
		} else if (rowMin == rowMax) {
			for (j = colMin; j <= colMax; j++) {
				// System.out.println("RS " + rowMin + "," + j);
				ans.add(matrix[rowMin][j]);
			}
		} else if (colMin == colMax) {
			for (i = rowMin; i <= rowMax; i++) {
				// System.out.println("DS " + i + "," + colMin);
				ans.add(matrix[i][colMin]);
			}
		}
		return ans;
	}
}
