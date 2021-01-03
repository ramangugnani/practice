package practice.leetcode.problems;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

public class CourseScheduleII_210 {
    public static void main(String[] args) {
        int[] order = findOrder(2, new int[][] { { 1, 0 } });
        System.out.println("o/p");
        for (int i = 0; i < order.length; i++) {
            System.out.print(order[i] + " ");
        }
        System.out.println();

        System.out.println("o/p");
        order = findOrder(2, new int[][] { { 1, 0 }, { 0, 1 } });
        for (int i = 0; i < order.length; i++) {
            System.out.print(order[i] + " ");
        }
        System.out.println();

    }

    public static int[] findOrder(int numCourses, int[][] prerequisites) {

        Map<Integer, Set<Integer>> adjList = new HashMap<>();
        Map<Integer, Set<Integer>> adjListReverse = new HashMap<>();

        int[] answer = new int[numCourses];
        for (int i = 0; i < numCourses; i++) {
            adjList.put(i, new HashSet<>());
            adjListReverse.put(i, new HashSet<>());
        }
        for (int i = 0; i < prerequisites.length; i++) {
            adjList.get(prerequisites[i][0]).add(prerequisites[i][1]);
            adjListReverse.get(prerequisites[i][1]).add(prerequisites[i][0]);

        }
        Queue<Integer> leaves = new LinkedList<>();
        for (int i = 0; i < numCourses; i++) {
            if (adjList.get(i).size() == 0) {
                leaves.add(i);
            }
        }
        Integer coursesCompleted = 0;
        while (leaves.size() > 0) {
            Integer queueSize = leaves.size();
            for (int i = 0; i < queueSize; i++) {
                Integer leave = leaves.poll();
                answer[coursesCompleted] = leave;
                coursesCompleted++;
                Set<Integer> neighbours = adjListReverse.get(leave);
                for (Integer neighbour : neighbours) {
                    if (adjList.get(neighbour).contains(leave)) {
                        adjList.get(neighbour).remove(leave);
                        if (adjList.get(neighbour).size() == 0) {
                            leaves.add(neighbour);
                        }
                    }
                }
            }
        }
        if (coursesCompleted == numCourses) {
            return answer;
        } else {
            return new int[] {};
        }
    }
}
