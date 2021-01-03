package practice.leetcode.problems;

import java.util.*;

public class MaximumUnitsOnaTruck_1710 {
    public static void main(String[] args) {
        System.out.println(maximumUnits(new int[][] { { 1, 3 }, { 2, 2 }, { 3, 1 } }, 4));

        System.out.println(maximumUnits(new int[][] { { 5, 10 }, { 2, 5 }, { 4, 7 }, { 3, 9 } }, 10));

    }

    public static int maximumUnits(int[][] boxTypes, int truckSize) {
        Integer answer = 0;
        List<List<Integer>> boxTypesList = new ArrayList<>();
        for (int i = 0; i < boxTypes.length; i++) {
            List<Integer> boxTypesSingle = new ArrayList<>();
            boxTypesSingle.add(boxTypes[i][1]);
            boxTypesSingle.add(boxTypes[i][0]);
            boxTypesList.add(boxTypesSingle);
        }
        Collections.sort(boxTypesList, new MyCompare());
        Integer i = truckSize;
        Integer j = 0;
        while (i > 0 && j < boxTypesList.size()) {
            List<Integer> boxTypesSingle = boxTypesList.get(j);
            if (i - boxTypesSingle.get(1) > 0) {
                answer = answer + (boxTypesSingle.get(1) * boxTypesSingle.get(0));
            } else {
                answer = answer + (boxTypesSingle.get(0) * i);
            }
            i = i - boxTypesSingle.get(1);
            j++;


        }
        return answer;
    }

    public static class MyCompare implements Comparator<List<Integer>> {

        @Override
        public int compare(List<Integer> o1, List<Integer> o2) {
            return o2.get(0) - o1.get(0);
        }

    }
}
