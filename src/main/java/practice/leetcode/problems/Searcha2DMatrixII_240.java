package practice.leetcode.problems;

public class Searcha2DMatrixII_240 {
	public static void main(String[] args) {
		System.out.println(searchMatrix(new int[][] { { 1, 4, 7, 11, 15 }, { 2, 5, 8, 12, 19 }, { 3, 6, 9, 16, 22 },
				{ 10, 13, 14, 17, 24 }, { 18, 21, 23, 26, 30 } }, 5));

		System.out.println(searchMatrix(new int[][] { { 1, 1 } }, 2));
	}

	public static boolean searchMatrix(int[][] matrix, int target) {
		int rowM = matrix.length;
		int colM = matrix[0].length;
		int i = 0;
		int j = colM - 1;
		while (i < rowM && j >= 0) {
			System.out.println(i + "," + j);
			if (target == matrix[i][j]) {
				return true;
			} else if (target > matrix[i][j]) {
				i++;
			} else {
				j--;
			}
		}
		return false;
	}
}
