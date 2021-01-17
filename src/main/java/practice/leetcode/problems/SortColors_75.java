package practice.leetcode.problems;

public class SortColors_75 {

	public static void main(String[] args) {
		int[] nums = new int[] { 2, 0, 2, 1, 1, 0 };
		sortColors(nums);
		print(nums);

		nums = new int[] { 2, 0, 1 };
		sortColors(nums);
		print(nums);

		nums = new int[] { 0 };
		sortColors(nums);
		print(nums);

		nums = new int[] { 1 };
		sortColors(nums);
		print(nums);

		nums = new int[] { 2 };
		sortColors(nums);
		print(nums);

	}

	public static void sortColors(int[] nums) {
		int low = 0;
		int mid = 0;
		int high = nums.length - 1;
		while (mid <= high) {
			if (nums[mid] == 0) {
				Integer temp = nums[mid];
				nums[mid] = nums[low];
				nums[low] = temp;
				low++;
				mid++;
			} else if (nums[mid] == 1) {
				mid++;
			} else {
				Integer temp = nums[high];
				nums[high] = nums[mid];
				nums[mid] = temp;
				high--;
			}
		}
	}

	public static void print(int[] nums) {
		for (int i = 0; i < nums.length; i++) {
			System.out.print(nums[i] + " ");
		}
		System.out.println();
	}
}
