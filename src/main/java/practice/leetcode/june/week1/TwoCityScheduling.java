package practice.leetcode.june.week1;

import java.util.Arrays;
import java.util.Comparator;

public class TwoCityScheduling {

	public static void main(String[] args) {
		
		int[][] costs = new int[][] { { 259, 770 }, { 448, 54 }, { 926, 667 }, { 184, 139 }, { 840, 118 },
				{ 577, 469 } };
		int result = twoCitySchedCost(costs);
		System.out.println("result " + result);
	}

	public static int twoCitySchedCost(int[][] costs) {
        int N = costs.length/2;
        int[] refund = new int[N * 2];
        int minCost = 0, index = 0;
        for(int[] cost : costs){
            refund[index++] = cost[1] - cost[0];
            minCost += cost[0];
        }
        Arrays.sort(refund);
        for(int i = 0; i < N; i++){
            minCost += refund[i];
        }
        return minCost;
		
	}

	public static class Compare implements Comparator<Cost> {

		@Override
		public int compare(Cost o1, Cost o2) {
			return o1.diff - o2.diff;
		}

	}

	public static class Cost {
		int x;
		int y;
		int diff;

		/*
		 * (non-Javadoc)
		 * 
		 * @see java.lang.Object#toString()
		 */
		@Override
		public String toString() {
			return "Cost [x=" + x + ", y=" + y + ", diff=" + diff + "]";
		}

	}
}
