package practice.leetcode.problems;

import java.util.Arrays;

public class SpiralMatrixII_59 {
    public static int[][] generateMatrix(int n) {
        int[][] answer = new int[n][n];
        int y = n -1;
        int val = 1;
        for(int k = 0 ; k < n/2 ; k++) {
            int i = k;
            int j = k;
            for(int x = 0; x < y; x++) {
                //System.out.format("[%d][%d] =1=> %d \n",i,j,val);
                answer[i][j] = val++;
                j++;
            }
            for(int x = 0; x < y; x++) {
                //System.out.format("[%d][%d] =2=> %d \n",i,j,val);
                answer[i][j] = val++;
                i++;
            }
            for(int x = 0; x < y; x++) {
                //System.out.format("[%d][%d] =3=> %d \n",i,j,val);
                answer[i][j] = val++;
                j--;
            }
            for(int x = 0; x < y; x++) {
                //System.out.format("[%d][%d] =4=> %d \n",i,j,val);
                answer[i][j] = val++;
                i--;
            }
            y -= 2;
        }
        if(n%2 == 1) {
            //System.out.format("[%d][%d] =5=> %d \n",n/2,n/2,n*n);
            answer[n/2][n/2] = val;
        }
        return answer;
    }
    
    private static void print(int[][] r) {
        for (int[] s: r) {
            System.out.println(Arrays.toString(s));
        }
    }
    
    public static void main(String[] args) {
        int[][] answer = generateMatrix(19);
        print(answer);
    }
}
