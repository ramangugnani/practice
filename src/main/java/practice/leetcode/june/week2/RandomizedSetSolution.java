package practice.leetcode.june.week2;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

public class RandomizedSetSolution {

	public static void main(String[] args) {
		int target = 0;
		RandomizedSet randomizedSet = new RandomizedSet();
		System.out.println(randomizedSet.insert(target));
		System.out.println(randomizedSet.remove(target));
		System.out.println(randomizedSet.getRandom());

	}

	public static class RandomizedSet {

	    List<Integer> list;
	    Map<Integer, Integer> map;
	    Random rand;
	    public RandomizedSet() {
	        list = new ArrayList<>();
	        map = new HashMap<>();
	        rand = new Random();
	    }
	    
	    /** Inserts a value to the set. Returns true if the set did not already contain the specified element. */
	    public boolean insert(int val) {
	        if(map.containsKey(val)){
	            return false;
	        }
	        list.add(val);
	        map.put(val, list.size() - 1);
	        return true;
	    }
	    
	    /** Removes a value from the set. Returns true if the set contained the specified element. */
	    public boolean remove(int val) {
	        if(!map.containsKey(val)){
	            return false;
	        }
	        int index = map.get(val);
	        int lastElement = list.get(list.size() - 1);
	        list.set(index, lastElement);
	        map.put(lastElement, index);
	        list.remove(list.size() - 1);
	        map.remove(val);
	        return true;
	    }
	    
	    /** Get a random element from the set. */
	    public int getRandom() {
	        return list.get(rand.nextInt(list.size()));
	    }
	}

}
