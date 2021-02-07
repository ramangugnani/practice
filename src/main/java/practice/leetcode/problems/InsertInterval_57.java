package practice.leetcode.problems;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class InsertInterval_57 {
	public static void main(String[] args) {

		System.out.println("============");
		int[][] ans = insert(new int[][] { { 1, 3 }, { 6, 9 } }, new int[] { 2, 5 });
		print(ans);
		System.out.println("============");
		ans = insert(new int[][] { { 1, 2 }, { 3, 5 }, { 6, 7 }, { 8, 10 }, { 12, 16 } }, new int[] { 4, 8 });
		print(ans);
	}

	public static int[][] insert(int[][] intervals, int[] newInterval) {
		
		int[][] newIntervals = new int[intervals.length+1][2];
		for(int i = 0; i < intervals.length ; i++) {
			newIntervals[i] = intervals[i];
		}
		newIntervals[intervals.length][0] = newInterval[0];
		newIntervals[intervals.length][1] = newInterval[1];
		
		Arrays.sort(newIntervals, new MySort());
		// System.out.println(start);
		// System.out.println(end);

		List<int[]> mySets = new ArrayList<>();
		int[] set = new int[2];
		set[0] = newIntervals[0][0];
		set[1] = newIntervals[0][1];
		mySets.add(set);
		// System.out.println(intervals[0][0] + ", " + intervals[0][1]);
		for (int i = 1; i < newIntervals.length; i++) {
			// System.out.println(intervals[i][0] + ", " + intervals[i][1]);
			// net set start less than previous end
			// merge them
			if (newIntervals[i][0] <= set[1]) {
				set[1] = Math.max(newIntervals[i][1], set[1]);
			} else {
				// start new set
				int[] newSet = new int[2];
				set = newSet;
				set = newIntervals[i];
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
