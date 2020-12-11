package practice.leetcode.june.week2;

public class IsSubsequence {
	public static void main(String[] args) {
		String s = "axc";
		String t = "ahbgdc";
		System.out.println(isSubsequence(s, t));
		System.out.println(isSubsequenceAdvanced(s, t));

	}

	public static boolean isSubsequence(String s, String t) {
		int[][] table = new int[t.length() + 1][s.length() + 1];
		for (int i = 0; i < t.length(); i++) {
			for (int j = 0; j < s.length(); j++) {
				// System.out.println(s.charAt(j) + "," + t.charAt(i));
				if (s.charAt(j) == t.charAt(i)) {
					table[i + 1][j + 1] = 1 + table[i][j];
				} else {
					table[i + 1][j + 1] = Math.max(table[i + 1][j], table[i][j + 1]);
				}
			}
		}
		if (table[t.length()][s.length()] == s.length()) {
			return true;
		} else {
			return false;
		}
	}

	public static boolean isSubsequenceAdvanced(String s, String t) {
		char[] sChars = s.toCharArray();
		char[] tChars = t.toCharArray();

		if (sChars.length == 0) {
			return true;
		}

		int jIndex = 0;
		int iIndex = 0;
		for (int i = 0; i < sChars.length; i++) {
			iIndex = i;
			char sChar = sChars[i];
			// System.out.println("sChar " + sChar + " iIndex " + iIndex);
			// System.out.println("jIndex " + jIndex + " tChars.length - 1 " +
			// (tChars.length - 1));
			if (jIndex >= tChars.length - 1) {
				return false;
			}
			for (int j = jIndex; j < tChars.length; j++) {
				char tChar = tChars[j];
				// System.out.println("tChar " + tChar + " j " + j);
				jIndex++;
				if (sChar == tChar) {
					break;
				}
			}
		}
		if (iIndex == sChars.length - 1) {
			return true;
		} else {
			return false;
		}
	}
}
