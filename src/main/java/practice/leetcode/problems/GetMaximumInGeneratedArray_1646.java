package practice.leetcode.problems;

public class GetMaximumInGeneratedArray_1646 {

    public static void main(String[] args) {
        System.out.println(getMaximumGenerated(7));

        System.out.println(getMaximumGenerated(2));

        System.out.println(getMaximumGenerated(3));

    }

    public static int getMaximumGenerated(int n) {
        if (n == 0) {
            return 0;
        } else if (n == 1) {
            return 1;
        } else {
            int[] arr = new int[n + 1];
            int answer = 0;
            arr[0] = 0;
            arr[1] = 1;
            for (int i = 2; i <= n; i++) {
                if (i % 2 == 0) {
                    arr[i] = arr[i / 2];
                } else {
                    arr[i] = arr[i / 2] + arr[(i / 2) + 1];
                }
                //System.out.println("Z " + arr[i]);
                answer = Math.max(answer, arr[i]);
            }
            return answer;
        }
    }
}
