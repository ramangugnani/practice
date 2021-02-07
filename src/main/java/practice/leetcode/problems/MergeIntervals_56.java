package practice.leetcode.problems;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class MergeIntervals_56 {

	public static void main(String[] args) {

		System.out.println("============");
		int[][] ans = merge(new int[][] { { 1, 3 }, { 2, 6 }, { 8, 10 }, { 15, 18 } });
		print(ans);
		System.out.println("============");
		ans = merge(new int[][] { { 1, 4 }, { 4, 5 } });
		print(ans);
	}

	public static int[][] merge(int[][] intervals) {
		Arrays.sort(intervals, new MySort());
		// System.out.println(start);
		// System.out.println(end);

		List<int[]> mySets = new ArrayList<>();
		int[] set = new int[2];
		set[0] = intervals[0][0];
		set[1] = intervals[0][1];
		mySets.add(set);
		//System.out.println(intervals[0][0] + ", " + intervals[0][1]);
		for (int i = 1; i < intervals.length; i++) {
			//System.out.println(intervals[i][0] + ", " + intervals[i][1]);
			// net set start less than previous end
			// merge them
			if (intervals[i][0] <= set[1]) {
				set[1] = Math.max(intervals[i][1], set[1]);
			} else {
				// start new set
				int[] newSet = new int[2];
				set = newSet;
				set = intervals[i];
				mySets.add(set);
			}
		}
		int[][] answer = new int[mySets.size()][2];
		for (int i = 0; i < mySets.size(); i++) {
			answer[i] = mySets.get(i);
		}
		return answer;
	}

	public static void print(int[][] ans) {
		for (int i = 0; i < ans.length; i++) {
			System.out.println(ans[i][0] + "," + ans[i][1]);
		}
	}

	public static class MySort implements Comparator<int[]> {

		@Override
		public int compare(int[] o1, int[] o2) {
			return o1[0] - o2[0];
		}

	}
}
