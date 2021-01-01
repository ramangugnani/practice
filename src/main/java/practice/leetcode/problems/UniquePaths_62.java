package practice.leetcode.problems;

public class UniquePaths_62 {
    public static void main(String[] args) {
        System.out.println(uniquePaths(3, 7));

        System.out.println(uniquePaths(3, 2));

        System.out.println(uniquePaths(7, 3));

        System.out.println(uniquePaths(3, 3));

    }

    public static int uniquePaths(int m, int n) {
        if (m == 0 || n == 0) {
            return 0;
        }
        if (m == 1 || n == 1) {
            return 1;
        }
        int[][] memo = new int[m + 1][n + 1];

        for (int i = 1; i < m + 1; i++) {
            memo[i][1] = 1;
        }
        for (int j = 1; j < n + 1; j++) {
            memo[1][j] = 1;
        }
        for (int i = 2; i < m + 1; i++) {
            for (int j = 2; j < n + 1; j++) {
                memo[i][j] = memo[i - 1][j] + memo[i][j - 1];
            }
        }
        return memo[m][n];
    }

}
