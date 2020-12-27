package practice.leetcode.problems;

import java.util.*;

public class FindAllDuplicatesInAnArray_442 {
	public static void main(String[] args) {
		System.out.println(findDuplicates(new int[] { 4, 3, 2, 7, 8, 2, 3, 1 }));
	}

	public static List<Integer> findDuplicates(int[] nums) {
		List<Integer> arrayList = new ArrayList<Integer>();
		for (int num : nums) {
			Integer index = Math.abs(num);
			Integer valueToBeAdded = index;
			Integer value = nums[--index];
			if (value > 0) {
				nums[index] = -value;
			} else {
				// duplicate
				arrayList.add(valueToBeAdded);
			}
		}
		return arrayList;
	}
}
