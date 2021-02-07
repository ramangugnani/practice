package practice.leetcode.problems;

public class NextPermutation_31 {

	public static void main(String[] args) {
		int[] ip = new int[] { 1, 2, 3 };
		System.out.print("IP ");
		print(ip);
		nextPermutation(ip);
		System.out.print("OP ");
		print(ip);

		ip = new int[] { 3, 2, 1 };
		System.out.print("IP ");
		print(ip);
		nextPermutation(ip);
		System.out.print("OP ");
		print(ip);

		ip = new int[] { 1, 1, 5 };
		System.out.print("IP ");
		print(ip);
		nextPermutation(ip);
		System.out.print("OP ");
		print(ip);

		ip = new int[] { 1 };
		System.out.print("IP ");
		print(ip);
		nextPermutation(ip);
		System.out.print("OP ");
		print(ip);

	}

	public static void nextPermutation(int[] nums) {

	}

	public static void print(int[] nums) {
		for (int i = 0; i < nums.length; i++) {
			System.out.print(nums[i] + ",");
		}
		System.out.println();
	}
}
