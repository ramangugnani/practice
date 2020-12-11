package practice.leetcode.june.week1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class QueueReconstructionByHeight {
	public static void main(String[] args) {
		int[][] people = new int[][] { { 7, 0 }, { 4, 4 }, { 7, 1 }, { 5, 0 }, { 6, 1 }, { 5, 2 } };
		print(people);
		int[][] sortedPeople = reconstructQueue(people);
		print(sortedPeople);
	}

	public static int[][] reconstructQueue(int[][] people) {
		if (null == people) {
			return null;
		}
		Arrays.sort(people, (p1, p2) -> p1[0] == p2[0] ? p1[1] - p2[1] : p2[0] - p1[0]);
		// Arrays.sort(people, new Compare());

		// print(people);

		List<int[]> answer = new ArrayList<>();

		for (int i = 0; i < people.length; i++) {
			answer.add(people[i][1], people[i]);
		}

		return answer.toArray(people);
	}

	public static class Compare implements Comparator<int[]> {

		@Override
		public int compare(int[] o1, int[] o2) {
			if (o1[0] == o2[0]) {
				return o1[1] - o2[1];
			} else {
				return o2[0] - o1[0];
			}
		}

	}

	private static void print(int[][] sortedPeople) {
		if (null == sortedPeople) {
			return;
		}
		for (int i = 0; i < sortedPeople.length; i++) {
			System.out.print("[" + sortedPeople[i][0] + "," + sortedPeople[i][1] + "] ");
		}
		System.out.println();
	}
}
