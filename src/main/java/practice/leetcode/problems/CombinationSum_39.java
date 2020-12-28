package practice.leetcode.problems;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CombinationSum_39 {
	public static void main(String[] args) {
		List<List<Integer>> subSets = combinationSum(new int[] { 2, 3, 6, 7 }, 7);
		System.out.println("Output");
		for (List<Integer> subSet : subSets) {
			System.out.println(subSet);
		}
		System.out.println("Done");
	}

	public static List<List<Integer>> combinationSum(int[] candidates, int target) {
		List<List<Integer>> list = new ArrayList<>();
		Arrays.sort(candidates);
		backtrack(list, new ArrayList<>(), candidates, 0, 0, target);
		return list;
	}

	private static void backtrack(List<List<Integer>> list, List<Integer> tempList, int[] candidates, int start,
			int sum, int target) {
		if (sum > target) {
			return;
		} else if (sum == target) {

			list.add(new ArrayList<>(tempList));
		} else {
			for (int i = start; i < candidates.length; i++) {
				tempList.add(candidates[i]);
				backtrack(list, tempList, candidates, i, sum + candidates[i], target);
				tempList.remove(tempList.size() - 1);
			}
		}
	}
}
