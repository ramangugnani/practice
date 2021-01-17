package practice.leetcode.problems;

public class SubarrayProductLessThanK_713 {

    public static void main(String[] args) {
        System.out.println(numSubarrayProductLessThanK(new int[] { 10, 5, 2, 6 }, 100));

        System.out.println(numSubarrayProductLessThanK(new int[] { 1, 1, 1 }, 1));

    }

    public static int numSubarrayProductLessThanK(int[] nums, int k) {
        if (k <= 1) {
            return 0;
        }
        int answer = 0;
        int product = 1;
        int left = 0;
        for (int right = 0; right < nums.length; right++) {
            product = product * nums[right];
            while (product >= k) {
                // reduce the window
                product = product / nums[left];
                left++;
            }
            answer = answer + 1 + (right - left);
        }

        return answer;
    }
}
