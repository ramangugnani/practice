package practice.algorithms.dynamicprogramming;

public class KnapSack {
	public static void main(String[] args) {

		int[] weight = new int[]{2,3,4,5};
		int[] cost = new int[]{3,4,5,6};
		int sackWeight = 7;

		System.out.println(maximumWeight(weight,cost,sackWeight));
	}

	private static int maximumWeight(int[] weightArr, int[] cost, int sackWeight) {
		int[] maximumSubWeight  = new int[sackWeight+1];
		for(int subWeight = 1 ; subWeight <= sackWeight ; ++subWeight){
			int maxSubCost = Integer.MIN_VALUE;

			for(int weightIndex = 0; weightIndex < weightArr.length ; weightIndex++){
				if(subWeight == weightArr[weightIndex])
					maxSubCost = cost[weightIndex];
			}

			for(int weightIndex = 0; weightIndex < weightArr.length ; weightIndex++){
				int weight = weightArr[weightIndex];
				if(weight <= subWeight){
					/* 				 sub weight cost    cost with weight + cost of local maximum sub weight  */
					maxSubCost = Math.max(maxSubCost,cost[weightIndex] + maximumSubWeight[subWeight-weight]); 
				}
			}
			maximumSubWeight[subWeight] = maxSubCost;
		}
		return maximumSubWeight[sackWeight];
	}
}
