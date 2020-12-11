package practice.leetcode.may.week4;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PossibleBipartition {
	public static void main(String[] args) {
		int N = 3;
		int[][] dislikes = new int[][] { { 1, 2 }, { 1, 3 }, { 2, 3 } };
		Boolean result = possibleBipartition(N, dislikes);
		System.out.println("Result " + result);
	}

	public static boolean possibleBipartition(int N, int[][] dislikes) {
		Map<Integer, List<Integer>> adjancecyList = new HashMap<>();
		Map<Integer, Integer> colorMap = new HashMap<>(N);
		for (int i = 0; i < dislikes.length; i++) {
			int x = dislikes[i][0];
			int y = dislikes[i][1];

			List<Integer> listX = adjancecyList.getOrDefault(x, new ArrayList<>());
			listX.add(y);
			adjancecyList.put(x, listX);

			List<Integer> listY = adjancecyList.getOrDefault(y, new ArrayList<>());
			listY.add(x);
			adjancecyList.put(y, listY);

		}
		for(Map.Entry<Integer, List<Integer>> entry : adjancecyList.entrySet()) {
			System.out.print(entry.getKey()+" --> ");
			List<Integer> neighbours = entry.getValue();
			if (null != neighbours && neighbours.size() > 0) {
				for (Integer neighbour : neighbours) {
					System.out.print(neighbour+" ");
				}
			}
			System.out.println();
		}
		for (int i = 1; i <= N; i++) {
			if (!colorMap.containsKey(i) && !dfs(i, 0, colorMap, adjancecyList)) {
				return false;
			}
		}
		System.out.println(colorMap);
		return true;
	}

	private static boolean dfs(int person, int color, Map<Integer, Integer> colorMap,
			Map<Integer, List<Integer>> adjancecyList) {
		if (colorMap.containsKey(person)) {
			return colorMap.get(person) == color ? true : false;
		} else {
			colorMap.put(person, color);
			List<Integer> neighbours = adjancecyList.get(person);
			if (null != neighbours && neighbours.size() > 0) {
				for (Integer neighbour : neighbours) {
					if (!dfs(neighbour, color ^ 1, colorMap, adjancecyList)) {
						return false;
					}
				}
			}
			return true;
		}
	}
}
