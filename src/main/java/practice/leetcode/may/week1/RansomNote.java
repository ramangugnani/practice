package practice.leetcode.may.week1;

import java.util.Map;
import java.util.TreeMap;

public class RansomNote {
	public static void main(String[] args) {
		String ransomNote = "cbacb";

		String magazine = "abbdcc";
		
		Boolean result = canConstruct(ransomNote, magazine);
		System.out.println("result "+ result);
	}

	public static boolean canConstruct(String ransomNote, String magazine) {
		if(null == ransomNote) {
			return true;
		}
		if(null != ransomNote && null == magazine) {
			return false;
		}
		Map<Character,Long> magazineDic = new TreeMap<>();
		for(Character character : magazine.toCharArray()) {
			Long value = magazineDic.get(character);
			if(null == value) {
				magazineDic.put(character, 1L);
			}else {
				magazineDic.put(character, ++value);
			}
		}
		for(Character character : ransomNote.toCharArray()) {
			Long value = magazineDic.get(character);
			if(null == value) {
				return false;
			}else {
				value --;
				if(value == 0) {
					magazineDic.remove(character);
				}else {
					magazineDic.put(character, value--);
				}
			}
		}
		return true;
	}
}
