package practice.leetcode.problems;

import java.util.HashMap;
import java.util.Map;

public class NumberOfRectanglesThatCanFormTheLargestSquare {
    public static void main(String[] args) {
        System.out.println(countGoodRectangles(new int[][] { { 5, 8 }, { 3, 9 }, { 5, 12 }, { 16, 5 } }));

        System.out.println(countGoodRectangles(new int[][] { { 2, 3 }, { 3, 7 }, { 4, 3 }, { 3, 7 } }));

        System.out.println(countGoodRectangles(new int[][] { { 5, 8 }, { 3, 9 }, { 3, 12 } }));

    }

    public static int countGoodRectangles(int[][] rectangles) {

        Map<Integer, Integer> map = new HashMap<>();
        Integer maxSize = 0;
        for (int i = 0; i < rectangles.length; i++) {
            int squareLength = Math.min(rectangles[i][0], rectangles[i][1]);
            map.put(squareLength, map.getOrDefault(squareLength, 0) + 1);
            if(squareLength > maxSize) {
                maxSize  = squareLength;
            }
        }
        return map.get(maxSize);
    }
    
    
}
