package practice.leetcode.may.week1;

import java.util.HashMap;
import java.util.Map;

public class FirstUniqueCharacterInAString {

	public static void main(String[] args) {
		String s = "leel";
		int answer = firstUniqChar(s);
		System.out.println("answer : " + answer);

	}

	public static int firstUniqChar(String s) {
		Map<Character, Integer> dictionary = new HashMap<>(26);
		Integer i = 0;
		for (Character character : s.toCharArray()) {
			Integer index = dictionary.get(character);
			if (null == index) {
				dictionary.put(character, i);
			} else if (index >= 0) {
				dictionary.put(character, -1);
			}
			i++;
		}
		Integer index = Integer.MAX_VALUE;
		for (Map.Entry<Character, Integer> entry : dictionary.entrySet()) {
			Integer value = entry.getValue();
			if (value >= 0 && value < index) {
				index = value;
			}
		}
		if (index == Integer.MAX_VALUE) {
			return -1;
		} else {
			return index;
		}
	}
}
