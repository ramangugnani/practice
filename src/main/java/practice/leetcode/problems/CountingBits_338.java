package practice.leetcode.problems;

public class CountingBits_338 {
    public static void main(String[] args) {
        int[] ans = countBits(2);
        for (int i = 0; i < ans.length; i++) {
            System.out.print(ans[i] + " ");
        }
        System.out.println();

        ans = countBits(5);
        for (int i = 0; i < ans.length; i++) {
            System.out.print(ans[i] + " ");
        }
        System.out.println();

    }

    public static int[] countBits(int num) {
        int[] answer = new int[num + 1];
        if (num == 0) {
            return answer;
        }
        answer[1] = 1;
        for (int i = 2; i < num + 1; i++) {
            answer[i] = (i % 2) + answer[i / 2];
        }
        return answer;
    }
}
