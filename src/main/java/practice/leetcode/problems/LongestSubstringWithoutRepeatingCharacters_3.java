package practice.leetcode.problems;

public class LongestSubstringWithoutRepeatingCharacters_3 {
	public static void main(String[] args) {
		System.out.println("abcabcbb " + lengthOfLongestSubstring("abcabcbb"));

		System.out.println("bbbbb " + lengthOfLongestSubstring("bbbbb"));

		System.out.println("pwwkew " + lengthOfLongestSubstring("pwwkew"));

		System.out.println(" " + lengthOfLongestSubstring(""));

		System.out.println("a " + lengthOfLongestSubstring("a"));

		System.out.println("ab " + lengthOfLongestSubstring("ab"));

		System.out.println("aa " + lengthOfLongestSubstring("aa"));

		System.out.println("dvdf " + lengthOfLongestSubstring("dvdf"));

		System.out.println("abba " + lengthOfLongestSubstring("abba"));

	}

	public static int lengthOfLongestSubstring(String s) {
		if (s.length() == 0) {
			return 0;
		}
		int result = 0;
		int[] cache = new int[256];
		for (int i = 0, j = 0; i < s.length(); i++) {
			if (cache[s.charAt(i)] > 0) {
				j = Math.max(j, cache[s.charAt(i)]);
			}
			cache[s.charAt(i)] = i + 1;
			result = Math.max(result, i - j + 1);
		}
		return result;
	}
}
