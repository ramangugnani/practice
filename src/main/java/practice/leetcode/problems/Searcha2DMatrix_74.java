package practice.leetcode.problems;

public class Searcha2DMatrix_74 {

	public static void main(String[] args) {
		int[][] matrix = new int[][] { { 1, 3, 5, 7 }, { 10, 11, 16, 20 }, { 23, 30, 34, 60 } };
		System.out.println(searchMatrix(matrix, 3));
	}

	public static boolean searchMatrix(int[][] matrix, int target) {
		Integer row = matrix.length;
		Integer col = matrix[0].length;
		Integer i = 0;
		Integer j = row * col - 1;
		while (i <= j) {
			Integer mid = (i + j) / 2;
			Integer nodeRow = mid / col;
			Integer nodeCol = mid % col;
			// value will be on left side
			if (matrix[nodeRow][nodeCol] > target) {
				j = mid - 1;
			} else if (matrix[nodeRow][nodeCol] < target) { // value will be on right side
				i = mid + 1;
			} else {
				return true;
			}
		}
		return false;
	}
}
