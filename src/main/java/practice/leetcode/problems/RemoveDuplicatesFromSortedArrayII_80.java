package practice.leetcode.problems;

public class RemoveDuplicatesFromSortedArrayII_80 {

    public static void main(String[] args) {
        int[] nums = new int[] {1,1,1,2,2,3};
        int result = removeDuplicates(nums);
        for(int i = 0; i < result; i++) {
            System.out.print(nums[i] +  " ");
        }
        System.out.println();
    }
    
    public static int removeDuplicates(int[] nums) {
        int i = 0;
        for(int num : nums) {
            // Base Condition to ignore 1st two values
            // Copy the values , if previous 2 values are smaller than current value
            if(i < 2 || num > nums[i-2]) {
                nums[i] = num;
                i++;
            }
        }
        return i;
    }
}
