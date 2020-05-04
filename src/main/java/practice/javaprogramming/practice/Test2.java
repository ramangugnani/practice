package practice.javaprogramming.practice;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class Test2 {

	public static void main(String[] args) {
		String[] pairs = null;
		pairs = new String[3];
		pairs[0] = "1 2";
		pairs[1] = "2 3";
		pairs[2] = "3 4";
		//pairs[3] = "8 6";
		System.out.println(minimalCost(9999, pairs));
	}

	public static int minimalCost(int n ,String [] pairs){

		Boolean[] elements = new Boolean[n+1];
		for(int i = 1 ;  i <= n ; i++){
			elements[i] = false;
		}

		ArrayList<Set<Integer>> listOfSet = null;
		if(null != pairs){
			listOfSet = new ArrayList<Set<Integer>>();
			for(String pair : pairs){
				String[] rods = pair.split(" ");
				Integer rod1 = Integer.parseInt(rods[0]);
				Integer rod2 = Integer.parseInt(rods[1]);
				elements[rod1]  = true;
				elements[rod2]  = true;
				boolean isSetFound = false;
				for(Set<Integer> setOFRods : listOfSet){
					if(setOFRods.contains(rod1) || setOFRods.contains(rod2)){
						setOFRods.add(rod1);
						setOFRods.add(rod2);
						isSetFound = true;
						break;
					}
				}
				if(!isSetFound){
					Set<Integer> newSet = new HashSet<>();
					newSet.add(rod1);
					newSet.add(rod2);
					listOfSet.add(newSet);
				}
			}
		}
		int weight = 0;
		for(int i = 1 ;  i <= n ; i++){
			if(elements[i] == false){
				weight = weight + (int) Math.ceil(Math.sqrt(1));
			}
		}
		if(null != listOfSet && listOfSet.size() > 0){
			for(Set<Integer> setOFRods : listOfSet){
				weight = weight + (int) Math.ceil(Math.sqrt(setOFRods.size()));
			}
		}
		return weight;
	}
}
