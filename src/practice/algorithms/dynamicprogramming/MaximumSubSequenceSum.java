package practice.algorithms.dynamicprogramming;

public class MaximumSubSequenceSum {

	public static void main(String[] args) {
		int[] arr = {-2,-3,4,-1,-2,1,5,-3};
		int maximumSum = maximumSubsequenceSum(arr);
		System.out.println(maximumSum);
	}

	private static int maximumSubsequenceSum(int[] arr) {
		int[] maximumSumArray = new int[arr.length];
		maximumSumArray[0] = arr[0]; 
		for(int i = 1 ; i < arr.length ; ++i){
			maximumSumArray[i] = Math.max(maximumSumArray[i-1] + arr[i], arr[i]);
		}
		int output = maximumSumArray[0];
		for(int i = 1 ; i < arr.length   ; ++i){
			output = Math.max(maximumSumArray[i], output);
		}
		return output;
	}

}
