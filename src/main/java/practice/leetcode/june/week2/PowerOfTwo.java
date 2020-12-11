package practice.leetcode.june.week2;

import java.util.ArrayList;
import java.util.List;

public class PowerOfTwo {
	public static void main(String[] args) {
		System.out.println("result " + isPowerOfTwo(9));
	}

	public static boolean isPowerOfTwo(int n) {

		for (int number : numbers) {
			if (number == n) {
				return true;
			}
			if(n < number) {
				return false;
			}
		}
		return false;
	}

	private static List<Integer> numbers = null;
	static {
		numbers = new ArrayList<>();
		numbers.add(Integer.parseInt("1", 2));
		numbers.add(Integer.parseInt("10", 2));
		numbers.add(Integer.parseInt("100", 2));
		numbers.add(Integer.parseInt("1000", 2));
		numbers.add(Integer.parseInt("10000", 2));
		numbers.add(Integer.parseInt("100000", 2));
		numbers.add(Integer.parseInt("1000000", 2));
		numbers.add(Integer.parseInt("10000000", 2));
		numbers.add(Integer.parseInt("100000000", 2));
		numbers.add(Integer.parseInt("1000000000", 2));
		numbers.add(Integer.parseInt("10000000000", 2));
		numbers.add(Integer.parseInt("100000000000", 2));
		numbers.add(Integer.parseInt("1000000000000", 2));
		numbers.add(Integer.parseInt("10000000000000", 2));
		numbers.add(Integer.parseInt("100000000000000", 2));
		numbers.add(Integer.parseInt("1000000000000000", 2));
		numbers.add(Integer.parseInt("10000000000000000", 2));
		numbers.add(Integer.parseInt("100000000000000000", 2));
		numbers.add(Integer.parseInt("1000000000000000000", 2));
		numbers.add(Integer.parseInt("10000000000000000000", 2));
		numbers.add(Integer.parseInt("100000000000000000000", 2));
		numbers.add(Integer.parseInt("1000000000000000000000", 2));
		numbers.add(Integer.parseInt("10000000000000000000000", 2));
		numbers.add(Integer.parseInt("100000000000000000000000", 2));
		numbers.add(Integer.parseInt("1000000000000000000000000", 2));
		numbers.add(Integer.parseInt("10000000000000000000000000", 2));
		numbers.add(Integer.parseInt("100000000000000000000000000", 2));
		numbers.add(Integer.parseInt("1000000000000000000000000000", 2));
		numbers.add(Integer.parseInt("10000000000000000000000000000", 2));
		numbers.add(Integer.parseInt("100000000000000000000000000000", 2));
		numbers.add(Integer.parseInt("1000000000000000000000000000000", 2));
	}
}
