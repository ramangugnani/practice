package practice.leetcode.problems;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class CoinChange_322 {
    public static void main(String[] args) {
        System.out.println(coinChange(new int[] { 1, 2, 5 }, 11));

        System.out.println(coinChange(new int[] { 2 }, 3));

        System.out.println(coinChange(new int[] { 1 }, 0));

        System.out.println(coinChange(new int[] { 1 }, 1));

        System.out.println(coinChange(new int[] { 1 }, 2));

    }

    public static int coinChange(int[] coins, int amount) {
        if (amount == 0){
            return 0;
        }
        Arrays.sort(coins);
        int[] values = new int[amount + 1];
        for (int i = 1; i <= amount; i++) {
            Integer value = Integer.MAX_VALUE;
            for (int j = 0; j < coins.length; j++) {
                if (coins[j] <= i) {
                    int restOfValue = values[i - coins[j]];
                    //System.out.println(i + " -- " + coins[j] + " - " + restOfValue);
                    if (restOfValue != -1) {
                        value = Math.min(value, 1 + restOfValue);
                    }
                }
            }
            if(value == Integer.MAX_VALUE) {
                value = -1;
            }
            values[i] = value;
        }
        //List<Integer> list =  Arrays.stream(values).boxed().collect(Collectors.toList());
        //System.out.println(list);
        return values[amount];
    }
}
