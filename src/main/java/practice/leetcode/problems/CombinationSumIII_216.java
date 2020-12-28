package practice.leetcode.problems;

import java.util.ArrayList;
import java.util.List;

public class CombinationSumIII_216 {
	public static void main(String[] args) {
		List<List<Integer>> subSets = combinationSum3(3, 7);
		System.out.println("Output");
		for (List<Integer> subSet : subSets) {
			System.out.println(subSet);
		}
		System.out.println("Done");
		
		subSets = combinationSum3(3, 9);
		System.out.println("Output");
		for (List<Integer> subSet : subSets) {
			System.out.println(subSet);
		}
		System.out.println("Done");
		
		subSets = combinationSum3(4, 1);
		System.out.println("Output");
		for (List<Integer> subSet : subSets) {
			System.out.println(subSet);
		}
		System.out.println("Done");

	}
	

	public static List<List<Integer>> combinationSum3(int k, int n) {
		List<List<Integer>> list = new ArrayList<>();
		backtrack(list, new ArrayList<>(), 1, k, 0, n);
		return list;
	}

	private static void backtrack(List<List<Integer>> list, List<Integer> tempList, int start, int size, int sum,
			int target) {

		if (sum > target || tempList.size() > size) {
			return;
		} else if (sum == target && tempList.size() == size) {
			list.add(new ArrayList<>(tempList));
		} else {
			for (int i = start; i < 10; i++) {
				tempList.add(i);
				backtrack(list, tempList, i + 1, size, sum + i, target);
				tempList.remove(tempList.size() - 1);
			}
		}
	}
}
