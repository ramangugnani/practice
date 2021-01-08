package practice.leetcode.problems;

public class KthMissingPositiveNumber_1539 {
    public static void main(String[] args) {
        System.out.println(findKthPositive(new int[] { 2, 3, 4, 7, 11 }, 5));

        System.out.println(findKthPositive(new int[] { 1, 2, 3, 4 }, 2));

        System.out.println(findKthPositive(new int[] { 1 }, 1));

    }

    public static int findKthPositive(int[] arr, int k) {
        Integer missingTillNow = 0;
        Integer i = 0;
        int counter = 0;
        for (counter = 0; counter < Integer.MAX_VALUE;) {
            counter++;
            if (i < arr.length && arr[i] == counter) {
                i++;
            } else {
                missingTillNow++;
                if (missingTillNow == k) {
                    break;
                }
            }
        }
        return counter;
    }

    public int findKthPositiveGood(int[] A, int k) {
        int l = 0, r = A.length, m;
        while (l < r) {
            m = (l + r) / 2;
            if (A[m] - 1 - m < k)
                l = m + 1;
            else
                r = m;
        }
        return l + k;
    }
}
