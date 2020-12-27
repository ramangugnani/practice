package practice.leetcode.problems;

import java.util.ArrayList;
import java.util.List;

public class DetermineIfStringHalvesAreAlike_1704 {
	public static void main(String[] args) {
		System.out.println(halvesAreAlike("book"));
		System.out.println(halvesAreAlike("textbook"));
		System.out.println(halvesAreAlike("MerryChristmas"));
		System.out.println(halvesAreAlike("AbCdEfGh"));
		
		System.out.println(halvesAreAlike("ioeuAOASOiocAeanuEOITeAaZeUEoIeOoIuOEuUuIoiAoOUOEuuOuaEiAWEoioiIaUAeauoIOiOIIoAuaAUuEUOeaoXoEEUuoUoOEIEELUeoIOAAiEoAiaUIaeUIoIiOaaEoIiiIUaeeoiAxOeEIOieueeaaUAOiIOTaAIiIIUAeOoeUOiuUOeEIoUiUIiiAoeoUIieEaaeEoUOOUhEeilouEIVauKioAOAAoaIoUoIiOIuavOEieUeuOOuIiAiiueEUagiUZiueoAiUPueAAOIeUaiOaeeAEOEauEeOOIoUEeaEOiOEUAeuhaiEEAUIoEIIoeAeEOAoUiIuooIsOUAuiEaIUEeeouIoEoeoIouueoaOEuua"));

	}

	public static boolean halvesAreAlike(String s) {
		Integer leftVowels = 0;
		Integer rightVowels = 0;
		List<Character> myVowels = new ArrayList<Character>(){
			{
				add('a');
				add('e');
				add('i');
				add('o');
				add('u');
				add('A');
				add('E');
				add('I');
				add('O');
				add('U');

			}
		};
		for (int i = 0; i < s.length() / 2; i++) {
			if(myVowels.contains(s.charAt(i))) {
				leftVowels++;
			}
		}
		for (int i = s.length() / 2; i < s.length(); i++) {
			if(myVowels.contains(s.charAt(i))) {
				rightVowels++;
			}
		}
		System.out.println(leftVowels + " " + rightVowels);
		return leftVowels.equals(rightVowels) ? true : false;
	}
}
