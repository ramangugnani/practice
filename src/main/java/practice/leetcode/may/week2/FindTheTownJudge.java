package practice.leetcode.may.week2;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class FindTheTownJudge {
	public static void main(String[] args) {
		int N = 3;
		int[][] trust = new int[][] {{1,2},{2,3}};
		int result = findJudge(N, trust);
		System.out.println("result : "+ result);
	}

	public static int findJudge(int N, int[][] trust) {
		Set<Integer> people = new HashSet<>();
		Map<Integer,Integer> judge = new HashMap<>();
		for(int i = 1 ; i <= N ; i++) {
			people.add(i);
			judge.put(i, 0);
		}
		for(int i = 0; i < trust.length; i++) {
			people.remove(trust[i][0]);
			Integer trustCount = judge.get(trust[i][1]);
			trustCount++;
			judge.put(trust[i][1], trustCount);
		}

		Iterator<Integer> itr = people.iterator();
		while(itr.hasNext()) {
			Integer expectedJudge = itr.next();
			if((N-1) == judge.get(expectedJudge)) {
				return expectedJudge;
			}
		}
		return -1;
	}
}
