package practice.leetcode.may.week4;

import java.util.HashMap;
import java.util.Map;

public class ContiguousArray {

	public static void main(String[] args) {
		int[] nums = new int[] { 0, 1, 0 };
		int result = findMaxLength(nums);
		System.out.println("result : " + result);
	}

	public static int findMaxLength(int[] nums) {
		Map<Integer, Integer> map = new HashMap<>();
        map.put(0, -1);

		int maxLength = 0;
		Integer totalCount = 0;

		for (int i = 0; i < nums.length; i++) {
			totalCount = totalCount + (nums[i] == 1 ? 1 : -1);
			Integer startIndex = map.get(totalCount);
			if (null != startIndex) {
				maxLength = Math.max(i - startIndex, maxLength);
			} else {
				map.put(totalCount, i);
			}
		}
		return maxLength;
	}
}
