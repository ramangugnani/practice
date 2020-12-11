package practice.leetcode.may.week4;

import java.util.ArrayList;
import java.util.List;

public class IntervalListIntersections {
	public static void main(String[] args) {
		int[][] A = new int[][] {{3,5}  };
		System.out.println("============== A ==============");
		print(A);
		int[][] B = new int[][] {{6,10} };
		System.out.println("============== B ==============");
		print(B);

		int[][] result = intervalIntersection(A, B);
		System.out.println("============== Result ==============");
		print(result);
	}

	public static int[][] intervalIntersection(int[][] A, int[][] B) {
		if (null == A || null == B || A.length ==0 || B.length == 0) {
			int[][] result = new int[0][0];
			return result;
		}
		int max = Math.max(A[A.length - 1][1], B[B.length - 1][1]) + 1;
		//System.out.println("Max " + max);
		int[] a = new int[max];
		int[] b = new int[max];

		// int[][] output = new int[][];
		int counter = 1;
		for (int i = 0; i < A.length; i++) {
			for (int j = A[i][0]; j <= A[i][1]; j++) {
				a[j] = counter;
			}
			counter++;
		}
		counter = 1;
		for (int i = 0; i < B.length; i++) {
			for (int j = B[i][0]; j <= B[i][1]; j++) {
				b[j] = counter;
			}
			counter++;
		}
		print(a);
		print(b);
		List<Integer> startSet = new ArrayList<>();
		List<Integer> endSet = new ArrayList<>();
		
		boolean setstarted = false;
		if(a[0] > 0 && b[0] > 0 && a[0] == b[0]) {
			setstarted = true;
			startSet.add(0);
		}
		for(int i = 1 ; i < max ; i++) {
			if(a[i] == 0 || b[i] == 0) {
				// which means no valid combination exists
				if(setstarted == true) {
					//previous one was good , lets terminate
					setstarted = false;
					endSet.add(i-1);
				}else {
					// previous also no valid set
					continue;
				}
			}else {
				if(a[i-1] == a[i] && b[i-1] == b[i]) {
					continue;
				}else {
					if(setstarted) {
						setstarted = false;
						endSet.add(i-1);
					}
					setstarted = true;
					startSet.add(i);
				}
			}
			
		}
		
		if(setstarted) {
			endSet.add(max-1);
		}
		
		System.out.println(startSet);
		System.out.println(endSet);
		int[][] result = new int[startSet.size()][2];
		for(int i =0 ; i < startSet.size() ; i++) {
			result[i][0] = startSet.get(i);
			result[i][1] = endSet.get(i);
		}


		return result;
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
