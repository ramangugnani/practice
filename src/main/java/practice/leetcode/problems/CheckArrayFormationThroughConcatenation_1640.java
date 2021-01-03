package practice.leetcode.problems;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CheckArrayFormationThroughConcatenation_1640 {

    public static void main(String[] args) {
        int[] arr = new int[] { 85 };
        int[][] pieces = new int[][] { { 85 } };
        System.out.println(canFormArray(arr, pieces));

        arr = new int[] { 15, 88 };
        pieces = new int[][] { { 88 }, { 15 } };
        System.out.println(canFormArray(arr, pieces));

        arr = new int[] { 49, 18, 16 };
        pieces = new int[][] { { 16, 18, 49 } };
        System.out.println(canFormArray(arr, pieces));

        arr = new int[] { 91, 4, 64, 78 };
        pieces = new int[][] { { 78 }, { 4, 64 }, { 91 } };
        System.out.println(canFormArray(arr, pieces));

        arr = new int[] { 1, 3, 5, 7 };
        pieces = new int[][] { { 2, 4, 6, 8 } };
        System.out.println(canFormArray(arr, pieces));

    }

    public static boolean canFormArray(int[] arr, int[][] pieces) {
        String input = "";
        for (int i = 0; i < arr.length; i++) {
            input = input + Integer.valueOf(arr[i]).toString();
        }
        List<String> piecesStr = new ArrayList<>();
        for (int i = 0; i < pieces.length; i++) {
            String piece = "";
            for (int j = 0; j < pieces[i].length; j++) {
                piece = piece + Integer.valueOf(pieces[i][j]).toString();
            }
            piecesStr.add(piece);
        }
        // System.out.println("input " + input);
        // System.out.println("piecesStr " + piecesStr);

        Map<String, Boolean> memo = new HashMap<>();
        Boolean result = check(input, piecesStr, memo);

        return result;
    }

    private static Boolean check(String input, List<String> piecesStr, Map<String, Boolean> memo) {
        if (input == "") {
            return true;
        }
        if (memo.containsKey(input)) {
            return memo.get(input);
        }
        for (String piece : piecesStr) {
            if (input.startsWith(piece)) {
                String remaining = "";
                if (input.length() > piece.length()) {
                    remaining = input.substring(piece.length(), input.length());
                    // System.out.println("remaining " + remaining);
                }
                Boolean result = check(remaining, piecesStr, memo);
                memo.put(remaining, result);
                if (result) {
                    return true;
                }
            }
        }
        return false;
    }
}
