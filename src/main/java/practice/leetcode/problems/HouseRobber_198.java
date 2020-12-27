package practice.leetcode.problems;

public class HouseRobber_198 {
    public static void main(String[] args) {
        int [] nums = new int[] {1,2,3,1};
        System.out.println(rob(nums));
     
        nums = new int[] {2,7,9,3,1};
        System.out.println(rob(nums));
        
        nums = new int[] {2,1};
        System.out.println(rob(nums));
        
        nums = new int[] {1,2};
        System.out.println(rob(nums));
    }

    public static int rob(int[] nums) {
        if(nums.length == 0) {
            return 0;
        }
        for(int i = 0 ; i < nums.length ; i++) {
            Integer previousValue = i-1 < 0 ? 0 : nums[i-1];
            Integer previousToPreviousValue = i-2 < 0 ? 0 : nums[i-2];
            nums[i] = Math.max(previousValue, previousToPreviousValue + nums[i]);
        }
        return nums[nums.length-1];
    }
}
