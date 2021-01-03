package practice.leetcode.problems;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

public class MinimumHeightTrees_310 {
    public static void main(String[] args) {
        System.out.println(findMinHeightTrees(4, new int[][] { { 1, 0 }, { 1, 2 }, { 1, 3 } }));
    }

    public static List<Integer> findMinHeightTrees(int n, int[][] edges) {

        if(n == 1) {
            List<Integer> list = new ArrayList<>();
            list.add(0);
            return list;
        }
        
        List<Set<Integer>> adjancecyList = new ArrayList<>(n);
        int[] degree = new int[n];

        for (int i = 0; i < n; i++) {
            adjancecyList.add(new HashSet<>());
        }

        for (int i = 0; i < edges.length; i++) {
            adjancecyList.get(edges[i][0]).add(edges[i][1]);
            degree[edges[i][0]]++;
            adjancecyList.get(edges[i][1]).add(edges[i][0]);
            degree[edges[i][1]]++;
        }

        Queue<Integer> leaves = new LinkedList<>();

        for (int i = 0; i < n; i++) {
            if (degree[i] == 1) {
                leaves.add(i);
            }
        }
        while (n > 2) {
            Integer leavesSize = leaves.size();
            n = n - leavesSize;
            for (int i = 0; i < leavesSize; i++) {
                Integer leave = leaves.poll();
                // remove connections of the leave
                Set<Integer> neighbours = adjancecyList.get(leave);

                for (Integer neighbour : neighbours) {
                    adjancecyList.get(neighbour).remove(leave);
                    degree[neighbour]--;

                    if (degree[neighbour] == 1) {
                        leaves.add(neighbour);
                    }

                }
                adjancecyList.get(leave).clear();
                degree[leave] = 0;
            }
        }
        return new ArrayList<>(leaves);
    }

}
