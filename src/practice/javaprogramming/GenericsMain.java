package practice.javaprogramming;

import java.util.ArrayList;
import java.util.List;

public class GenericsMain {
	public static void main(String[] args){
		List<Integer> listNum = new ArrayList<Integer>();
		listNum.add(1);
		listNum.add(2);
		listNum.add(3);
		Integer output = null;
		try {
			output = Generics.sortedElemet(listNum,5);
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println(output);
	}
}
