package practice.leetcode.may.week3;

import java.util.ArrayList;
import java.util.List;

public class FindAllAnagramsInAString {
public static void main(String[] args) {
		
		String s1 = "cbaebabacd";
		String s2 = "abc";
		List<Integer> result = findAnagrams(s1, s2);
		System.out.println("result "+result);
	}
	
    public static List<Integer> findAnagrams(String s, String p) {
    	List<Integer> anagramsStartingIndexList = new ArrayList<>();
    	
    	if(p.length() > s.length()) {
    		return anagramsStartingIndexList;
    	}
    	
    	int[] S1Dictionary = new int[26];
    	int[] S2Dictionary = new int[26];
    	char[] s1Char = p.toCharArray();
    	char[] s2Char = s.toCharArray();
    	for(int i =0 ; i < p.length() ; i++) {
    		S1Dictionary[s1Char[i] - 'a'] ++;
    		S2Dictionary[s2Char[i] - 'a'] ++;
    	}
        
    	boolean result = match(S1Dictionary,S2Dictionary);
    	if(result) {
    		anagramsStartingIndexList.add(0);
    	}
    	for(int j = p.length() ; j < s.length() ; j++) {
    		int oldIndex = j-p.length();
    		char oldChar = s2Char[oldIndex];
    		S2Dictionary[oldChar-'a']--;
    		char newChar = s2Char[j];
    		S2Dictionary[newChar - 'a']++;
    		result = match(S1Dictionary, S2Dictionary);
    		if(result) {
    			anagramsStartingIndexList.add(oldIndex+1);
    		}
    	}

    	return anagramsStartingIndexList;
    }

	private static boolean match(int[] S1Dictionary, int[] S2Dictionary) {
		
		for(int i = 0 ; i < 26 ; i++) {
			if(S1Dictionary[i] != S2Dictionary[i]) {
				return false;
			}
		}
		return true;
	}
}
