package practice.leetcode.problems;

public class ConcatenationOfConsecutiveBinaryNumbers_1680 {
	public static void main(String[] args) {

		System.out.println(concatenatedBinary(1));

		System.out.println(concatenatedBinary(3));

		System.out.println(concatenatedBinary(12));

	}

	public static int concatenatedBinary(int n) {
		long ans = 1;
		for (int i = 2; i <= n; i++) {
			String bin = Integer.toBinaryString(i);
			//System.out.println(bin);
			ans = (ans << bin.length()) + i;
			//System.out.println("ans " + ans);
			ans = ans % 1000000007;
		}
		return (int)ans;
	}
}
