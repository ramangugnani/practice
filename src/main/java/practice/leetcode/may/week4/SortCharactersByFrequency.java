package practice.leetcode.may.week4;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SortCharactersByFrequency {

	public static void main(String[] args) {
		String s= "Aabb";
		String result = frequencySort(s);
		System.out.println("result : "+result);
	}
	
    public static String frequencySort(String s) {
    	Map<Character,Integer> myMap = new HashMap<>();
    	for(Character c : s.toCharArray()) {
    		Integer value = myMap.getOrDefault(c, 0);
    		myMap.put(c, ++value);
    	}
    	List<Map.Entry<Character,Integer>> myList = new ArrayList<>(myMap.entrySet());
    	
    	Collections.sort(myList,new MapComparator());
    	
    	System.out.println(myList);
    	StringBuilder str = new StringBuilder();
    	for(Map.Entry<Character,Integer> entry : myList) {
    		for(Integer i = 0 ; i < entry.getValue() ; i++) {
    			str.append(entry.getKey());
    		}
    	}
    	return str.toString();
    }
    public static class Pair{
    	Character c;
    	Integer count;
    }
    public static class MapComparator implements Comparator<Map.Entry<Character,Integer>>{

		@Override
		public int compare(Map.Entry<Character,Integer> o1, Map.Entry<Character,Integer> o2) {
			return o2.getValue().compareTo(o1.getValue());
		}
    	
    }
}
