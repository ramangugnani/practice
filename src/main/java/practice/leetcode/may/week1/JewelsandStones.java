package practice.leetcode.may.week1;

import java.util.HashSet;
import java.util.Set;

public class JewelsandStones {
	public static void main(String[] args) {
		String j = "aA";
		String s = "aAAbbbb";
		int answer = numJewelsInStones(j, s);
		System.out.println("Answer : " + answer);
	}

	public static int numJewelsInStones(String J, String S) {
		if(null == J) {
			return 0;
		}
		if(null == S) {
			return 0;
		}
		Set<Character> jewels = new HashSet<Character>();
		for(Character jewel :  J.toCharArray()) {
			jewels.add(jewel);
		}
		Integer JewelsInStones = 0;
		for(Character stone : S.toCharArray()) {
			if(jewels.contains(stone)) {
				JewelsInStones++;
			}
			
		}
		return JewelsInStones;
	}
}
