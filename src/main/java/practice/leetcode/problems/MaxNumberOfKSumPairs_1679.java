package practice.leetcode.problems;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class MaxNumberOfKSumPairs_1679 {
    public static void main(String[] args) {
        System.out.println(maxOperations(new int[] { 1, 2, 3, 4 }, 5));

        System.out.println(maxOperations(new int[] { 3, 1, 3, 4, 3 }, 6));

    }

    public static int maxOperations(int[] nums, int k) {
        Map<Integer, Integer> myMap = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int val = myMap.getOrDefault(nums[i], 0);
            myMap.put(nums[i], val + 1);
        }
        // System.out.println(myMap);
        Integer answer = 0;
        for (int i = 0; i < nums.length; i++) {
            Integer val1 = myMap.get(nums[i]);
            if (null != val1 && val1 > 0) {
                myMap.put(nums[i], val1 - 1);
                Integer val2 = myMap.get(k - nums[i]);
                if (null != val2 && val2 > 0) {
                    answer++;
                    myMap.put(k - nums[i], val2 - 1);
                }
            }
        }
        return answer;
    }

    public static int maxOperationsNew(int[] nums, int k) {
        Arrays.sort(nums);
        Integer answer = 0;
        Integer i = 0;
        Integer j = nums.length - 1;
        while (i < j) {
            if (nums[i] + nums[j] == k) {
                answer++;
                i++;
                j--;
            } else if (nums[i] + nums[j] < k) {
                i++;
            } else {
                j--;
            }
        }
        return answer;
    }
}
