package practice.algorithms.dynamicprogramming;

public class CuttingARod {
	public static void main(String[] args) {
		int[] rodPrice = {0,1,5,8,9,10,17,17,20};
		int rodLengthGiven = 8;
		int price = maxPrice(rodPrice,rodLengthGiven);
		System.out.println(price);
	}

	private static int maxPrice(int[] rodPrice, int rodLengthGiven) {
		int[] subMaxPrice = new int[rodPrice.length+1];
		for(int i = 1 ; i <= rodLengthGiven ; ++i){
			int subLength = i;
			int maximumPrice = Integer.MIN_VALUE;
			for(int j = 1; j <= subLength ; ++j){
				maximumPrice = Math.max(maximumPrice, subMaxPrice[subLength-j] + rodPrice[j]);
			}
			subMaxPrice[subLength] = maximumPrice;
		}
		return subMaxPrice[rodLengthGiven];
	}
}
