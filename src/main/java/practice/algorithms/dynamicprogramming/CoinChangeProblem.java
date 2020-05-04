package practice.algorithms.dynamicprogramming;

public class CoinChangeProblem {
	public static void main(String[] args) {

		int[] coins = new int[3];
		coins[0] = 1;coins[1] = 2;coins[2] = 3;
		int totalMoney = 7;
		System.out.println(minimumCoinsRequired(coins,totalMoney));

	}
	public static int minimumCoinsRequired(int[] coins , int totalMoney ){
		int[] subMoney = new int[totalMoney+1];
		for(int i = 1 ; i <= totalMoney ; ++i){
			subMoney[i] = minimum (i,subMoney,coins);
		}
		return subMoney[totalMoney];
	}
	private static int minimum(int subMoney, int[] subMoneyList, int[] coins) {
		int minimumValue = Integer.MAX_VALUE;
		for(int i = 0 ; i < coins.length ; ++i){
			if(subMoney - coins[i] >= 0  ){
				int subMoneyInedx  = subMoney - coins[i];
				int value = subMoneyList[subMoneyInedx];

				minimumValue = Math.min(minimumValue, value+1);	
			}
		}
		return minimumValue;
	}
}
