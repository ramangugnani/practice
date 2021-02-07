package practice.leetcode.problems;

public class CheckIfAll1sAreAtLeastLengthKPlacesAway_1437 {

	public static void main(String[] args) {
		System.out.println(kLengthApart(new int[] { 1, 0, 0, 0, 1, 0, 0, 1 }, 2));

		System.out.println(kLengthApart(new int[] { 1, 0, 0, 1, 0, 1 }, 2));

		System.out.println(kLengthApart(new int[] { 1, 1, 1, 1, 1 }, 0));

		System.out.println(kLengthApart(new int[] { 0, 1, 0, 1 }, 1));

	}

	public static boolean kLengthApart(int[] nums, int k) {
		Boolean ans = true;
		Integer previousIndex = null;
		Integer currentIndex = null;
		for (int i = 0; i < nums.length; i++) {
			if(nums[i] == 1) {
				currentIndex = i;
				if(null == previousIndex) {
					previousIndex = currentIndex;
					continue;
				}
				if(currentIndex - previousIndex > k) {
					previousIndex = currentIndex;
				}else {
					ans = false;
					break;
				}
			}
		}
		return ans;
	}
}
