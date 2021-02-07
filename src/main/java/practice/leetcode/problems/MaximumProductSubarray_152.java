package practice.leetcode.problems;

public class MaximumProductSubarray_152 {
	public static void main(String[] args) {
		System.out.println(maxProduct(new int[] { 2, 3, -2, 4 }));

		System.out.println(maxProduct(new int[] { -2, 0, -1 }));

	}

	public static int maxProduct(int[] nums) {
		int ans = Integer.MIN_VALUE;
		int[] oldTemp = new int[nums.length];
		for (int i = 0; i < nums.length; i++) {
			oldTemp[i] = nums[i];
			ans = Math.max(oldTemp[i], ans);
		}
		for (int i = 1; i < nums.length; i++) {
			int[] newTemp = new int[nums.length];
			for (int j = i; j < nums.length; j++) {
				newTemp[j] = oldTemp[j - 1] * nums[j];
				// System.out.print(temp[i][j] + "\t");
				ans = Math.max(newTemp[j], ans);
			}
			oldTemp = newTemp;
			// System.out.println();
		}
		return ans;
	}
}
