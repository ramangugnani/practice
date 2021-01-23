package practice.leetcode.problems;

import java.util.Arrays;

public class DetermineIfTwoStringsAreClose_1657 {
    public static void main(String[] args) {
        System.out.println(closeStrings("abc", "bca"));

        System.out.println(closeStrings("a", "aa"));

        System.out.println(closeStrings("cabbba", "abbccc"));

        System.out.println(closeStrings("cabbba", "aabbss"));

    }

    public static boolean closeStrings(String word1, String word2) {
        if(word1.length() != word2.length()) {
            return false;
        }
        int[] word1C = new int[26];
        int[] word2C = new int[26];

        int[] word1F = new int[26];
        int[] word2F = new int[26];

        for (char ch : word1.toCharArray()) {
            word1C[ch - 'a'] = 1;
            word1F[ch - 'a']++;
        }
        for (char ch : word2.toCharArray()) {
            word2C[ch - 'a'] = 1;
            word2F[ch - 'a']++;
        }

        Arrays.sort(word1F);
        Arrays.sort(word2F);
        return Arrays.equals(word1C, word2C) && Arrays.equals(word1F, word2F);
    }
}
