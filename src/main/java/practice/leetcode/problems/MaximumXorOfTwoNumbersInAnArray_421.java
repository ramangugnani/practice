package practice.leetcode.problems;

import java.util.ArrayList;
import java.util.List;

public class MaximumXorOfTwoNumbersInAnArray_421 {
	public static void main(String[] args) {
		System.out.println(findMaximumXOR(new int[] { 3, 10, 5, 25, 2, 8 }));

		System.out.println(findMaximumXOR(new int[] { 0 }));

		System.out.println(findMaximumXOR(new int[] { 2, 4 }));

		System.out.println(findMaximumXOR(new int[] { 8, 10, 2 }));

		System.out.println(findMaximumXOR(new int[] { 14, 70, 53, 83, 49, 91, 36, 80, 92, 51, 66, 70 }));

	}

	public static int findMaximumXOR(int[] nums) {
		if (nums.length == 1) {
			return 0;
		}
		Integer answer = 0;
		answer = backtrack(nums, new ArrayList<>(), 0);
		return answer;
	}

	private static Integer backtrack(int[] nums, List<Integer> tempList, Integer start) {
		if (tempList.size() == 2) {
			//System.out.println(tempList + " --> " + (tempList.get(0) ^ tempList.get(1)));
			return tempList.get(0) ^ tempList.get(1);
		}
		Integer answer = 0;
		for (int i = start; i < nums.length; i++) {
			tempList.add(nums[i]);
			answer = Math.max(answer, backtrack(nums, tempList, i + 1));
			tempList.remove(tempList.size() - 1);

		}
		return answer;
	}
}
