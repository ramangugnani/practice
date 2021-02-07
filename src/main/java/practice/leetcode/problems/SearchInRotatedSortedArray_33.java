package practice.leetcode.problems;

public class SearchInRotatedSortedArray_33 {
	public static void main(String[] args) {
		System.out.println(search(new int[] { 4, 5, 6, 7, 0, 1, 2 }, 0));

		System.out.println(search(new int[] { 4, 5, 6, 7, 0, 1, 2 }, 3));

		System.out.println(search(new int[] { 1 }, 0));

		System.out.println(search(new int[] { 1 }, 1));

	}

	public static int search(int[] nums, int target) {
		int low = 0;
		int high = nums.length - 1;
		while (low <= high) {
			int mid = (low + high) / 2;
			if (nums[mid] == target) {
				return mid;
			}
			if (nums[low] <= nums[mid]) {
				if (target >= nums[low] && target < nums[mid]) {
					high = mid - 1;
				} else {
					low = mid + 1;
				}
			} else {
				if (target > nums[mid] && target <= nums[high]) {
					// strictly increasing
					low = mid + 1;
				} else {
					high = mid - 1;
				}
			}
		}
		return -1;
	}
}
