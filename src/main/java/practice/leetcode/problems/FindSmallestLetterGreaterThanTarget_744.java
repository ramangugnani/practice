package practice.leetcode.problems;

import java.util.*;

public class FindSmallestLetterGreaterThanTarget_744 {
    public static void main(String[] args) {
        char[] letters = new char[] {'c', 'f', 'j'};
        char target = 'k';
        System.out.println(nextGreatestLetterNew(letters, target));
        
        
    }
    
    public static char nextGreatestLetter(char[] letters, char target) {
        Set<Character> mySet = new HashSet<>(); 
        Character answer = null;
        for(char letter : letters) {
            mySet.add(letter);
        }
        Integer initialOffset = target - 'a';
        for(int i = 1 ; i <= 26 ; i++) {
            Integer totalOffset = (initialOffset + i ) % 26;
            answer = (char) ( 'a' + totalOffset);
            if(mySet.contains(answer)) {
                return answer;
            }
        }
        return answer;
    }
    
    public static char nextGreatestLetterNew(char[] letters, char target) {
        for(char a : letters){
            if(a - target > 0) return a;
        }   
        return letters[0];
    }
}
