package practice.leetcode.may.week4;

public class ConstructBinarySearchTreeFromPreorderTraversal {

	public static void main(String[] args) {
		int[] A = new int[] {1,3,7,1,7,5};
		int[] B = new int[] {1,9,2,5,1};
		
		int result = maxUncrossedLines(A, B);
		System.out.println("===== Result ===== " + result);
	}

    public static int maxUncrossedLines(int[] A, int[] B) {
        int[][] dp = new int[A.length+1][B.length+1];
        for(int i = 1 ; i <= A.length ; i++ ) {
        	for(int j =1 ; j <= B.length ; j++) {
        		if(A[i-1] == B[j-1]) {
        			dp[i][j] = 1 + dp[i-1][j-1];
        		}else {
        			dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
        		}
        	}
        }
    	return dp[A.length][B.length];
    }

}
