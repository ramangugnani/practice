package practice.leetcode.problems;

public class CountSortedVowelStrings_1641 {
    public static void main(String[] args) {
        System.out.println(countVowelStrings(1));

        System.out.println(countVowelStrings(2));

        System.out.println(countVowelStrings(3));

        System.out.println(countVowelStrings(33));

    }

    public static int countVowelStrings(int n) {
        int[][] dp = new int[n + 1][6];
        for (int i = 1; i <= n; ++i)
            for (int k = 1; k <= 5; ++k)
                dp[i][k] = dp[i][k - 1] + (i > 1 ? dp[i - 1][k] : 1);

        for (int i = 1; i <= n; ++i) {
            for (int k = 1; k <= 5; ++k) {
                System.out.print(dp[i][k] + "\t");
            }
            System.out.println();
        }

        return dp[n][5];
    }
}
