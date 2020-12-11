package practice.leetcode.may.week4;

import java.util.ArrayList;
import java.util.List;

public class IntervalListIntersections2 {
	public static void main(String[] args) {
		int[][] A = new int[][] { { 3, 5 } };
		System.out.println("============== A ==============");
		print(A);
		int[][] B = new int[][] { { 6, 10 } };
		System.out.println("============== B ==============");
		print(B);

		int[][] result = intervalIntersection(A, B);
		System.out.println("============== Result ==============");
		print(result);
	}

	public static int[][] intervalIntersection(int[][] A, int[][] B) {
		int n = A.length;
		int m = B.length;
		if (n == 0 || m == 0)
			return new int[0][0];

		List<int[]> res = new ArrayList<>();
		int i = 0;
		int j = 0;
		int[] aHead = null;
		int[] bHead = null;
		while (i < n && j < m) {
			aHead = A[i];
			bHead = B[j];

			int[] intersect = { Math.max(aHead[0], bHead[0]), Math.min(aHead[1], bHead[1]) };
			if (intersect[0] <= intersect[1]) {
				// add intersect
				res.add(intersect);
			}

			if (aHead[1] < bHead[1]) {
				i++;
			} else if (aHead[1] == bHead[1]) {
				i++;
				j++;
			} else {
				j++;
			}
		}

		int dim = res.size();
		int[][] finalRes = new int[dim][2];
		for (i = 0; i < dim; i++) {
			finalRes[i] = res.get(i);
		}
		return finalRes;
	}

	public static void print(int[] a) {
		for (int i = 0; i < a.length; i++) {
			System.out.print(a[i] + "\t");
		}
		System.out.println();
	}

	public static void print(int[][] a) {
		for (int i = 0; i < a.length; i++) {
			for (int j = 0; j < a[0].length; j++) {
				System.out.print(a[i][j] + "\t");
			}
			System.out.println();
		}
	}
}
