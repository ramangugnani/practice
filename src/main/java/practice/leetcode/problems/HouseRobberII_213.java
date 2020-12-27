package practice.leetcode.problems;

import java.util.Arrays;

public class HouseRobberII_213 {
    public static void main(String[] args) {
        int[] nums = new int[] { 1, 2, 3, 1 };
        System.out.println(rob(nums));

        nums = new int[] { 2, 7, 9, 3, 1 };
        System.out.println(rob(nums));

        nums = new int[] { 2, 1 };
        System.out.println(rob(nums));

        nums = new int[] { 1 };
        System.out.println(rob(nums));
    }

    public static int rob(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        if (nums.length == 1) {
            return nums[0];
        }
        return Math.max(rob(nums, 0, nums.length - 1), rob(nums, 1, nums.length));
    }

    public static int rob(int[] nums, int start, int end) {
        System.out.println(start + "-" + end);
        int[] newNums = new int[nums.length];
        for (int i = start; i < end; i++) {
            Integer previousValue = i - 1 < 0 ? 0 : newNums[i - 1];
            Integer previousToPreviousValue = i - 2 < 0 ? 0 : newNums[i - 2];
            newNums[i] = Math.max(previousValue, previousToPreviousValue + nums[i]);
        }
        return newNums[end - 1];
    }

}
