package practice.algorithms.dynamicprogramming;

public class MatrixMultiplication {
	public static void main(String[] args) {

		int[][] rowByCol = new int[5][2];
		rowByCol[0][0] = 2; rowByCol[0][1] = 3;
		rowByCol[1][0] = 3; rowByCol[1][1] = 4;
		rowByCol[2][0] = 4; rowByCol[2][1] = 5;
		rowByCol[3][0] = 5; rowByCol[3][1] = 1;
		rowByCol[4][0] = 1; rowByCol[4][1] = 3;
		
		int cost = matrixMultiplication(rowByCol);
		System.out.println(cost);
	}

	private static int matrixMultiplication(int[][] rowByCol) {
		int auxilaryCost[][] = new int[rowByCol[0].length][rowByCol.length];
		return 0;
	}
}
