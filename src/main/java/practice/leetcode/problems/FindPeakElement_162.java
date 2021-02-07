package practice.leetcode.problems;

public class FindPeakElement_162 {

	public static void main(String[] args) {
		System.out.println(findPeakElement(new int[] { 1, 2, 3, 1 }));

		System.out.println(findPeakElement(new int[] { 1, 2, 1, 3, 5, 6, 4 }));

		System.out.println(findPeakElement(new int[] { 1, 0 }));

		System.out.println(findPeakElement(new int[] { 1 }));

	}

	public static int findPeakElement(int[] nums) {
		if(nums.length == 1) {
			return 0;
		}
		Integer ans = -1;
		for (int i = 0; i < nums.length; i++) {
			if (i == 0) {
				if (nums[i + 1] < nums[i]) {
					// System.out.println(nums[i] + " " + nums[i + 1]);
					ans = i;
					break;
				}
			}
			if (i == nums.length - 1) {
				if (nums[i] > nums[i - 1]) {
					// System.out.println(nums[i - 1] + " " + nums[i]);
					ans = i;
					break;
				}
			} else {
				if (nums[i + 1] < nums[i] && nums[i] > nums[i - 1]) {
					// System.out.println(nums[i - 1] + " " + nums[i] + " " + nums[i + 1]);
					ans = i;
					break;
				}
			}
		}
		return ans;
	}
}
