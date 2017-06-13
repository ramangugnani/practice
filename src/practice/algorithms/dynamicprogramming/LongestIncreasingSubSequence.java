package practice.algorithms.dynamicprogramming;

public class LongestIncreasingSubSequence {
	public static void main(String[] args) {
		int arr[] = new int[]{10,22,9,33,21,50,41,60};
		int length = arr.length;
		int answer = longestIncreasingSubSequence(arr,length);
		System.out.println("LongestIncreasingSubSequence length is " + answer);
	}

	private static int longestIncreasingSubSequence(int[] arr, int length) {
		int max = Integer.MIN_VALUE;
		int[] list = new int[arr.length];
		for(int i = 0 ; i < length ; ++i)
			list[i] = 1;

		for(int i = 1 ; i < length ; ++i){
			for(int j = 0 ; j < i ; j++){
				if(arr[i] > arr[j] && list[i]< list[j]+1){
					list[i] = list[j]+1;
				}
			}
			max = Math.max(max, list[i]);
		}

		/* Printing the LongestIncreasingSubSequence */
		int checker = 1;
		for(int i = 0 ; i < length ; ++i){
			if(checker == list[i]){
				System.out.print(arr[i] + " ");
				checker++;
			}
		}
		System.out.println();
		return max;
	}
}
