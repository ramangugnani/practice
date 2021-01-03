package practice.leetcode.problems;

import java.util.*;

public class TargetSum_494 {
    public static void main(String[] args) {
        System.out.println(findTargetSumWays(new int[] { 1, 1, 1, 1, 1 }, 3));

        System.out.println(findTargetSumWays(
                new int[] { 2, 107, 109, 113, 127, 131, 137, 3, 2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 47, 53 }, 8));

    }

    public static int findTargetSumWays(int[] nums, int S) {
        Map<String, Integer> memo = new HashMap<String, Integer>();
        return backtrack(nums, new ArrayList<Integer>(), S, 0, memo);
    }

    public static int backtrack(int[] nums, List<Integer> tempList, Integer totalSum, Integer start,
            Map<String, Integer> memo) {
        String key = start + "-" + (totalSum);
        if (memo.containsKey(key)) {
            return memo.get(key);
        }
        if (nums.length == tempList.size() && totalSum == 0) {
            return 1;
        }
        for (int i = start; i < nums.length; i++) {
            tempList.add(nums[i]);
            Integer count1 = backtrack(nums, tempList, totalSum - nums[i], start + 1, memo);
            tempList.remove(tempList.size() - 1);

            tempList.add(-nums[i]);
            Integer count2 = backtrack(nums, tempList, totalSum - (-nums[i]), start + 1, memo);
            tempList.remove(tempList.size() - 1);
            memo.put(key, count1 + count2);
            return count1 + count2;
        }
        memo.put(key, 0);
        return 0;
    }
}
