package practice.leetcode.june.week2;

public class SearchInsertPosition {
	public static void main(String[] args) {
		int[] nums = new int[] {1,3,5,6};
		int target = 0;
		System.out.println(searchInsert(nums, target));
	}

	public static int searchInsert(int[] nums, int target) {
		for(int i = 0; i < nums.length ; i++) {
			if(nums[i] == target) {
				return i;
			}else if(nums[i] > target) {
				return i;
			}
			else if(i+1 < nums.length && nums[i+1] > target) {
				return i+1;
			}
		}
		return nums.length;
	}
}
