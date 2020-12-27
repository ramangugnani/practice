package practice.leetcode.problems;

public class DecodeWays_91 {

	public static void main(String[] args) {
		System.out.println(numDecodings("12"));

		System.out.println(numDecodings("226"));

		System.out.println(numDecodings("0"));

		System.out.println(numDecodings("1"));

		System.out.println(numDecodings("2101"));

	}

	public static int numDecodings(String s) {
		if (null == s || s.length() == 0) {
			return 0;
		}
		int[] memory = new int[s.length() + 1];
		memory[0] = 1;

		if (Integer.valueOf(s.charAt(0) - 48) > 0) {
			memory[1] = 1;
		} else {
			memory[1] = 0;
		}
		for (Integer i = 1; i < s.length(); i++) {

			Integer previousValue = Integer.valueOf(s.substring(i, i+1));
			Integer previousPreviousValue = Integer.valueOf(s.substring(i-1, i+1));
		      
			// System.out.println("previousValue " + previousValue);
			// System.out.println("previousPreviousValue " + previousPreviousValue);

			if (previousValue >= 1 && previousValue <= 9) {
				memory[i + 1] = memory[i + 1] + memory[i];
			}

			if (previousPreviousValue >= 10 && previousPreviousValue <= 26) {
				memory[i + 1] = memory[i + 1] + memory[i - 1];
			}
		}
		return memory[s.length()];
	}
}
