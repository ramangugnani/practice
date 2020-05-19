package practice.leetcode.may.week2;

public class SingleElementInASortedArray {

	public static void main(String[] args) {
		int[] nums = new int[] {3,3,7,7,10,11,11};
		int result = singleNonDuplicate(nums);
		System.out.println("result : "+result);
	}
	
    public static int singleNonDuplicate(int[] nums) {
    	int result = 0;
    	for(int i = 0; i < nums.length ; i++) {
    		result = result ^ nums[i];
    	}
        return result;
    }
}
