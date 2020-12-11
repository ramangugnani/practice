package practice.leetcode.problems;

import java.util.*;

public class ValidMountainArray_941 {
    public static void main(String[] args) {
        int[] arr = new int[] {2,1};
        System.out.println(validMountainArray(arr));
        
        arr = new int[] {3,5,6,4,6};
        System.out.println(validMountainArray(arr));
        
        arr = new int[] {1,2,3,9,8,7,6,5,4,3,2,1,0};
        System.out.println(validMountainArray(arr));
        
        arr = new int[] {9,8,7,6,5,4,3,2,1,0};
        System.out.println(validMountainArray(arr));
        
        arr = new int[] {2,0,2};
        System.out.println(validMountainArray(arr));
        
    }
    
    public static boolean validMountainArray(int[] arr) {
        if (arr.length < 3) {
            return false;
        }else {
            Integer deltaPositiveStart = 0;
            Integer deltaNegativeStart = 0;
            Integer previousValue = null;


            for (int i = 1 ; i < arr.length ; i++) {
                int delta = arr[i] - arr[i-1];
                if(delta == 0) {
                    return false;
                }else if(delta > 0 ) {
                    if (previousValue == null || previousValue == -1) {
                        deltaPositiveStart ++;
                        previousValue = 1;
                    }
                }else{
                    // delta < 0
                    if (previousValue == null || previousValue == 1) {
                        deltaNegativeStart ++;
                        previousValue = -1;
                    }
                }
                
                if(deltaNegativeStart > deltaPositiveStart || deltaNegativeStart > 1 || deltaPositiveStart > 1) {
                    return false;
                }
            }
            
            if(deltaNegativeStart == 1 && deltaPositiveStart == 1) {
                return true;
            }else {
                return false;
            }
            
        }
    }
}
