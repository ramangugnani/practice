package practice.leetcode.problems;

public class ProductOfArrayExceptSelf_238 {

	public static void main(String[] args) {
		int[] input = new int[] {1,2,3,4};
		int[] output = productExceptSelf(input);
		for(int num : output) {
			System.out.print(num + " ");
		}
		System.out.println();
	}
	
    public static int[] productExceptSelf(int[] nums) {
        int ans[] = new int[nums.length];
        ans[0] = 1;
        for(int i = 1 ; i < nums.length ; i++) {
        	ans[i] = ans[i-1] * nums[i - 1];
        }
        int right = 1;
        for(int i = nums.length - 1 ; i >= 0 ; i--) {
        	ans[i] = ans[i] * right;
        	right = right * nums[i];
        }
        return ans;
    }
}
