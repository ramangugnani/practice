package practice.leetcode.problems;

import java.util.ArrayList;
import java.util.List;

public class Combinations_77 {
    public static void main(String[] args) {
        int n = 4;
        int k = 2;
        List<List<Integer>> subSets = combine(n, k);
        System.out.println("Output");
        for (List<Integer> subSet : subSets) {
            System.out.println(subSet);
        }
        System.out.println("Done");
    }

    public static List<List<Integer>> combine(Integer n, Integer k) {
        List<List<Integer>> list = new ArrayList<>();
        backtrack(list, new ArrayList<>(), 1, n, k);
        return list;
    }

    private static void backtrack(List<List<Integer>> list, List<Integer> tempList, int j, int n, int k) {
        if (tempList.size() == k) {
            list.add(new ArrayList<>(tempList));
        } else {
            for (int i = j; i <= n; i++) {
                tempList.add(i);
                backtrack(list, tempList, i + 1, n, k);
                tempList.remove(tempList.size() - 1);
            }
        }
    }
}
