package practice.leetcode.problems;

public class BeautifulArrangement_526 {

    public static void main(String[] args) {
        System.out.println(countArrangement(1));

        System.out.println(countArrangement(2));

        System.out.println(countArrangement(3));
    }

    public static int  count = 0;
    
    public static int countArrangement(int N) {
        if (N == 0) return 0;
        helper(N, 1, new int[N + 1]);
        return count;
    }
    
    private static void helper(int N, int pos, int[] used) {
        if (pos > N) {
            count++;
            return;
        }
        
        for (int i = 1; i <= N; i++) {
            if (used[i] == 0 && (i % pos == 0 || pos % i == 0)) {
                used[i] = 1;
                helper(N, pos + 1, used);
                used[i] = 0;
            }
        }
    }
}
