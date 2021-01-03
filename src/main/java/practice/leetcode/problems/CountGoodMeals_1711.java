package practice.leetcode.problems;

import java.util.*;

public class CountGoodMeals_1711 {
    public static void main(String[] args) {
        System.out.println(countPairs(new int[] { 1, 3, 5, 7, 9 }));

        System.out.println(countPairs(new int[] { 1, 1, 1, 3, 3, 3, 7 }));

    }

    public static int countPairs(int[] deliciousness) {
        Integer pairs = 0;
        Map<Integer,Integer> valueByFrequency = new HashMap<>();
        for(int i = 0 ; i < deliciousness.length ; i++) {
            for(int j = 0 ; j < 32 ; j++) {
                Integer pow = (int) Math.pow(2, j);
                //System.out.println(pow);
                Integer frequency = valueByFrequency.getOrDefault(pow - deliciousness[i], 0);
                pairs = pairs + frequency;
                pairs = pairs % (1000000007);
            }
            Integer freq = valueByFrequency.getOrDefault(deliciousness[i], 0);
            valueByFrequency.put(deliciousness[i], freq+1);
        }
        return pairs;
    }
}
