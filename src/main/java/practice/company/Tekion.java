package practice.company;

public class Tekion {

    /*
     * non negative array target integer [2,3,7,0,0,0,2,1] , target = 10 smallest
     * contiguous sub array , sum of sub array should be equal to target o/p = 2
     * length of array window 2,3,7,0,0,0,2,1 p1 = 0 p2 = 0 Sum(p2-p1) == target
     * (Min (old ans, p2-p1+1) < target ==> p2++ (increase) > target ==> p1++ (to
     * reduce subset)
     */
    public static void main(String[] args) {
        System.out.println(getLeastSubArray(new int[] { 10, 0, 3, 7, 0, 0, 0, 2, 1 }, 10));
        
        System.out.println(getLeastSubArray(new int[] { 2, 3, 3, 2, 8 }, 10));

    }

    /**
     *  p1 = 0 , p2  = 0 , sum = 2
     *  p1 = 0 , p2  = 1 , sum = 5
     *  p1 = 0 , p2  = 2 , sum = 12
     *  p1 = 1 , p2  = 2 , sum = 10
     *  p1 = 1 , p2  = 3 , sum = 10
     *  p1 = 1 , p2  = 4 , sum = 10
     *  p1 = 1 , p2  = 5 , sum = 10
     *  p1 = 1 , p2  = 6 , sum = 12
     *  p1 = 2 , p2  = 6 , sum = 9
     *  p1 = 2 , p2  = 7 , sum = 10  --> 6
     *  p1 = 2 , p2  = 8 , sum = 10 
     *  
     *  
     *  p1 = 0 , p2  = 0 , sum = 2
     *  p1 = 0 , p2  = 1 , sum = 5
     *  p1 = 0 , p2  = 2 , sum = 8
     *  p1 = 0 , p2  = 3 , sum = 10 --> 4
     *  p1 = 0 , p2  = 4 , sum = 18
     *  p1 = 1 , p2  = 4 , sum = 16
     *  p1 = 2 , p2  = 4 , sum = 13
     *  p1 = 3 , p2  = 4 , sum = 10 --> 2
     *  p1 = 3 , p2  = 5 , sum =  break;
     */
    public static int getLeastSubArray(int[] input, int target) {
        // no base checks as of now
        Integer ans = Integer.MAX_VALUE;
        Integer p1 = 0;
        Integer p2 = 0;
        Integer sum = input[0];
        while (p2 < input.length || p1 < input.length) {
            if (sum == target) {
                ans = Math.min(ans, p2 - p1 + 1);
                if(p1 < p2) {
                    p1++;
                    if (p1 < input.length) {
                        sum += input[p1];
                    }else {
                        break;
                    }
                }else {    
                    p2++;
                    if (p2 < input.length) {
                        sum += input[p2];
                    }
                }
            } else if (sum < target) {
                p2++;
                if (p2 < input.length) {
                    sum += input[p2];
                }else {
                    break;
                }
            } else {
                // sum > target
                if (p1 < input.length) {
                    sum -= input[p1];
                }
                p1++;
            }
        }
        return ans;
    }
}
