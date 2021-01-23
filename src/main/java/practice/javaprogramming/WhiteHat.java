package practice.javaprogramming;

/*
 * m X n matrix
 * 1,2,3
 * -4,5,6
 * 7,-8,-9
 * 
 * any row in 1st col
 * any row in last col
 * 
 * move forward direction
 * 4 ->2,5,8 --> 3,6
 *       5 --> 3,6,9
 *       8 --> 6,9
 *       
 *  1 -> 2,5 -> 3,6
 *		   5 -> 3,6,9
 *
 *find  a path from 1st column  to last column with max sumation
 *integer over flow ? NO
 *all values not unique 
 * 0 < m < 1000
 * 0 < n < 1000
 */
public class WhiteHat {
	public static void main(String[] args) {
		int[][] matrix = new int[][] { { 1, 2, 3 }, { -4, 5, 6 }, { 7, -8, -9 } };
		System.out.println(getMaxSum(matrix));
	}

	public static int getMaxSum(int[][] matrix) {
		if (null == matrix) {
			return 0;
		}
		int m = matrix.length;
		if (m <= 0) {
			return 0;
		}
		int n = matrix[0].length;
		if (n <= 0) {
			return 0;
		}
		int[][] dp = new int[m][n + 1];
		int answer = 0;
		for (int j = 1; j <= n; j++) {
			for (int i = 0; i < m; i++) {
				dp[i][j] = matrix[i][j - 1] + getMax(i, j, dp, m, n);
				// evaluation max
				if (j == n) {
					answer = Math.max(answer, dp[i][j]);
				}
			}
		}
		return answer;
	}

	/*
	 * gives the max previous values with boundary checks
	 */
	private static int getMax(int i, int j, int[][] dp, int m, int n) {
		Integer answer = Integer.MIN_VALUE;
		// case 1 , upper value
		if (i - 1 >= 0 && j - 1 >= 0) {
			answer = Math.max(answer, dp[i - 1][j - 1]);
		}
		// case 2 , previous value
		if (j - 1 >= 0) {
			answer = Math.max(answer, dp[i][j - 1]);
		}
		// case 3 , lower value
		if (i + 1 < m && j - 1 >= 0) {
			answer = Math.max(answer, dp[i + 1][j - 1]);
		}
		return answer;
	}
}
