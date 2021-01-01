package practice.leetcode.problems;

public class JumpGame_55 {
	public static void main(String[] args) {
		System.out.println(canJumpNew(new int[] { 2, 3, 1, 1, 4 }));

		System.out.println(canJumpNew(new int[] { 3, 2, 1, 0, 4 }));

		System.out.println(canJumpNew(new int[] { 4, 0, 0, 0, 0 }));

		System.out.println(canJumpNew(new int[] { 0 }));

	}

	public static boolean canJump(int[] nums) {
		Integer max = 0;
		for (int i = 0; i < nums.length; i++) {
			max = Math.max(max - 1, nums[i]);
			if (max >= nums.length - 1 - i) {
				return true;
			} else if (max <= 0) {
				return false;
			}
		}
		return true;
	}

	public static boolean canJumpNew(int[] nums) {
		int maxPos = nums[0];

		for (int i = 1; i < nums.length; i++) {

			if (maxPos < i) {
				return false;
			}

			maxPos = Math.max(maxPos, nums[i] + i);

			if (maxPos >= nums.length) {
				return true;
			}
		}

		return true;
	}
}
