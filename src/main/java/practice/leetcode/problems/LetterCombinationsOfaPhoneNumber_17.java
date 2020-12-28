package practice.leetcode.problems;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LetterCombinationsOfaPhoneNumber_17 {

    public static void main(String[] args) {
        System.out.println(letterCombinations("23"));
        System.out.println("=======================");
        System.out.println(letterCombinations(""));
        System.out.println("=======================");
        System.out.println(letterCombinations("2"));
        System.out.println("=======================");
    }

    public static List<String> letterCombinations(String digits) {
        Map<Integer, List<String>> myMap = new HashMap<>();
        List<String> answer = new ArrayList<String>();
        myMap.put(2, Arrays.asList("a", "b", "c"));
        myMap.put(3, Arrays.asList("d", "e", "f"));
        myMap.put(4, Arrays.asList("g", "h", "i"));
        myMap.put(5, Arrays.asList("j", "k", "l"));
        myMap.put(6, Arrays.asList("m", "n", "o"));
        myMap.put(7, Arrays.asList("p", "q", "r", "s"));
        myMap.put(8, Arrays.asList("t", "u", "v"));
        myMap.put(9, Arrays.asList("w", "x", "y", "z"));

        letterCombination(digits, 0, digits.length(), "", answer, myMap);
        return answer;
    }

    private static void letterCombination(String digits, int index, Integer length, String word, List<String> answer,
            Map<Integer, List<String>> myMap) {
        if (index == length) {
            if (word.length() > 0) {
                // System.out.println(word);
                answer.add(word);
            }
        } else {
            Integer number = Integer.valueOf(digits.charAt(index) - '0');
            List<String> alphabects = myMap.get(number);
            for (String alphabect : alphabects) {
                letterCombination(digits, index + 1, length, word + alphabect, answer, myMap);
            }
        }
    }

}
