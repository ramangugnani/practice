package practice.leetcode.problems;

import java.util.*;

public class TargetSum_494 {
    public static void main(String[] args) {
        System.out.println(findTargetSumWays(new int[] { 1, 1, 1, 1, 1 }, 3));
        
        System.out.println(findTargetSumWays(
                new int[] { 2,107,109,113,127,131,137,3,2,3,5,7,11,13,17,19,23,29,47,53 }, 8));
        
    }

    public static int findTargetSumWays(int[] nums, int S) {
        return backtrack(nums, new ArrayList<Integer>(), S, 0, 0);
    }

    public static int backtrack(int[] nums, List<Integer> tempList, int S, int totalSum, int start) {
        if (nums.length == tempList.size() && S == totalSum) {
            System.out.println(tempList);
            return 1;
        }
        for (Integer i = start; i < nums.length; i++) {
            Integer count = 0;
            tempList.add(nums[i]);
            count += backtrack(nums, tempList, S, totalSum + nums[i], start + 1);
            tempList.remove(tempList.size() - 1);

            tempList.add(-nums[i]);
            count += backtrack(nums, tempList, S, totalSum - nums[i], start + 1);
            tempList.remove(tempList.size() - 1);
            return count;
        }
        return 0;
    }
}
