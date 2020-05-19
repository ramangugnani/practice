package practice.leetcode.may.week1;

import java.util.HashMap;
import java.util.Map;

public class MajorityElement {
	public static void main(String[] args) {
		int[] nums = new int[] { 2, 2, 2, 2, 3, 1 };
		int answer = majorityElement(nums);
		System.out.println("answer : " + answer);
	}

	public static int majorityElement(int[] nums) {
		Map<Integer, Integer> dictionary = new HashMap<>();
		int majorityNumber = (nums.length / 2) + 1;
		Integer result = 0;
		for (int i = 0; i < nums.length; i++) {
			Integer number = nums[i];
			Integer count = dictionary.get(number);
			if (null == count) {
				count = 1;
				dictionary.put(number, count);
			} else {
				count++;
				dictionary.put(nums[i], count);
				if (count >= majorityNumber) {
					result = nums[i];
					break;
				}
			}
		}
		return result;
	}
}
