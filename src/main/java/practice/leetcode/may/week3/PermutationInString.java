package practice.leetcode.may.week3;

public class PermutationInString {

	public static void main(String[] args) {
		
		String s1 = "adc";
		String s2 = "dcda";
		Boolean result = checkInclusion(s1, s2);
		System.out.println("result "+result);
	}
	
    public static boolean checkInclusion(String s1, String s2) {
    	if(s1.length() > s2.length()) {
    		return false;
    	}
    	
    	int[] S1Dictionary = new int[26];
    	int[] S2Dictionary = new int[26];
    	char[] s1Char = s1.toCharArray();
    	char[] s2Char = s2.toCharArray();
    	for(int i =0 ; i < s1.length() ; i++) {
    		S1Dictionary[s1Char[i] - 'a'] ++;
    		S2Dictionary[s2Char[i] - 'a'] ++;
    	}
        
    	boolean result = match(S1Dictionary,S2Dictionary);
    	if(result) {
    		return true;
    	}
    	for(int j = s1.length() ; j < s2.length() ; j++) {
    		int oldIndex = j-s1.length();
    		//System.out.println("oldIndex "+oldIndex);
    		char oldChar = s2Char[oldIndex];
    		S2Dictionary[oldChar-'a']--;
    		char newChar = s2Char[j];
    		S2Dictionary[newChar - 'a']++;
    		result = match(S1Dictionary, S2Dictionary);
    		if(result) {
    			return true;
    		}
    	}

    	return false;
    }

	private static boolean match(int[] S1Dictionary, int[] S2Dictionary) {
		//System.out.println("S1Dictionary "+S1Dictionary);
		//System.out.println("S2Dictionary "+S2Dictionary);
		
		for(int i = 0 ; i < 26 ; i++) {
			if(S1Dictionary[i] != S2Dictionary[i]) {
				return false;
			}
		}
		return true;
	}
    

}
