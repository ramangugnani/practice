package practice.leetcode.may.week5;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class CourseSchedule {
	public static void main(String[] args) {
		int numCourses = 2;
		int[][] prerequisites = new int[][] { { 1, 0 },{0,1} };
		Boolean result = canFinish(numCourses, prerequisites);
		System.out.println("canFinishFinal " + result);
	}

	public static boolean canFinish(int numCourses, int[][] prerequisites) {
		if (numCourses <= 0 || prerequisites == null || prerequisites.length == 0 ||
	        	prerequisites[0] == null || prerequisites[0].length == 0) {
	        	return true;
	        }
	        int[] visited = new int[numCourses];
	        HashMap<Integer, List<Integer>> map = new HashMap<Integer, List<Integer>>();
	        //Put all start node into map.
	        for (int i = 0; i < prerequisites.length; i++) {
	        	if (!map.containsKey(prerequisites[i][1])) {
	        		map.put(prerequisites[i][1], new ArrayList<Integer>());
	        	}
	        	map.get(prerequisites[i][1]).add(prerequisites[i][0]);
	        }
	        //dfs on each start node in the pair
	        for (int i = 0; i < prerequisites.length; i++) {
	        	if (!dfs(prerequisites[i][0],visited,map)) {
	        		return false;
	        	}
	        }

	        return true;
	    }

	    public static boolean dfs (int node,int[] visited,HashMap<Integer, List<Integer>> map) {
	    	if (visited[node] == 1) {//has been through this path, true.
	    		return true;
	    	}
	    	if (visited[node] == -1) {//visiting a visited node from a deper level node, cycle
	    		return false;
	    	}
	    	//mark it -1 then after dfs mark it 1. Marking and backtracking skills
	    	visited[node] = -1;

	    	//Visit each child and make sure there is no cycle.
	    	if (map.containsKey(node)) {
	    		for (int nextNode : map.get(node)) {
	    			if (!dfs(nextNode,visited,map)) {
	    				return false;
	    			}
	    		}
	    	}
	    	
	    	visited[node] = 1;
	    	return true;
	    }
	
	private static void printGraph(Integer numCourses,HashMap<Integer, List<Integer>> adjancecyList) {

		for(int i = 0 ; i < numCourses ; i++) {
			List<Integer> neighbours = adjancecyList.get(i);
			System.out.print(i + "--> ");
			if(null != neighbours && neighbours.size() > 0) {
				for(Integer neighbour : neighbours) {
					System.out.print(" "+neighbour);
				}
				
			}
			System.out.println();
		}
	}
}
