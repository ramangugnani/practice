package practice.leetcode.problems;

import java.util.*;

public class CourseSchedule_207 {

    public static void main(String[] args) {
        System.out.println(canFinish(2, new int[][] { { 1, 0 } }));

        System.out.println(canFinish(2, new int[][] { { 1, 0 }, { 0, 1 } }));

    }

    public static boolean canFinish(int numCourses, int[][] prerequisites) {
        if (prerequisites.length == 0) {
            return true;
        }
        List<Set<Integer>> adjList = new ArrayList<>();
        for (int i = 0; i < numCourses; i++) {
            adjList.add(new HashSet<>());
        }
        for (int i = 0; i < prerequisites.length; i++) {
            adjList.get(prerequisites[i][0]).add(prerequisites[i][1]);
        }
        Queue<Integer> leaves = new LinkedList<>();
        for (int i = 0; i < numCourses; i++) {
            if (adjList.get(i).size() == 0) {
                leaves.add(i);
            }
        }
        Integer coursesCompleted = numCourses;
        while (leaves.size() > 0) {
            // System.out.println(" leaves " + leaves);
            Integer queueSize = leaves.size();
            for (int i = 0; i < queueSize; i++) {
                Integer leave = leaves.poll();
                coursesCompleted--;
                for (int j = 0; j < numCourses; j++) {
                    // System.out.println(j + " adjList.get(j) " + adjList.get(j));
                    if (adjList.get(j).contains(leave)) {
                        // System.out.println(j + " adjList.get(j) " + adjList.get(j));
                        adjList.get(j).remove(leave);
                        // System.out.println(j + " adjList.get(j) " + adjList.get(j));
                        // System.out.println(" degree " + adjList.get(j).size());
                        if (adjList.get(j).size() == 0) {
                            leaves.add(j);
                        }
                    }
                }
            }
        }
        if (coursesCompleted == 0) {
            return true;
        } else {
            return false;
        }
    }
}
