package practice.leetcode.problems;

public class CountOfMatchesInTournament_1688 {
    public static void main(String[] args) {
        System.out.println(numberOfMatches(7));

        System.out.println(numberOfMatches(14));

    }

    public static int numberOfMatches(int n) {
        int result = 0;
        while (n > 1) {
            if (n % 2 == 0) {
                result = result + (n / 2);
                n = n / 2;
            } else {
                result = result + ((n - 1) / 2);
                n = (n + 1) / 2;
            }
        }
        return result;
    }
}
