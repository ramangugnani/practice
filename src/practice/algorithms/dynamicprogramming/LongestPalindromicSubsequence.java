package practice.algorithms.dynamicprogramming;

public class LongestPalindromicSubsequence {
	public static void main(String[] args) {
		String seq = "GEEKSFORGEEKS";
		System.out.println("The lnegth of the lps is "+ longestPalindromicSubsequence(seq));
	}

	private static Integer longestPalindromicSubsequence(String seq) {
		int length = seq.length();
		int arr[][] = new  int[length][length];

		//making diagonal 0ne's , thus treating each number in itself as a palindrome of length one
		for(int i = 0 ; i < length ; ++i){
			arr[i][i] = 1;
		}

		for(int cl = 2 ; cl <= length  ; cl++){
			for(int row = 0 ; row < length - cl +1; row++){
				int col = row +cl -1;
				if(seq.charAt(row) == seq.charAt(col) && cl == 2){
					arr[row][col] = 2;
				}else if(seq.charAt(row) == seq.charAt(col)){
					arr[row][col] = arr[row+1][col-1] + 2;
				}else{
					arr[row][col] = Math.max(arr[row][col-1], arr[row+1][col]);
				}
			}
		}
		return arr[0][length-1];
	}
}
