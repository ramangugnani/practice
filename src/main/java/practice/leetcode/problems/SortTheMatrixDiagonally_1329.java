package practice.leetcode.problems;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SortTheMatrixDiagonally_1329 {

    public static void main(String[] args) {
        int[][] mat = new int[][] { { 3, 3, 1, 1 }, { 2, 2, 1, 2 }, { 1, 1, 1, 2 } };
        // print(mat);
        mat = diagonalSort(mat);
        System.out.println("OP");
        print(mat);
    }

    public static int[][] diagonalSort(int[][] mat) {
        int m = mat.length;
        int n = mat[0].length;
        // going bottom to top
        for (int x = m - 1; x >= 0; x--) {
            int i = x;
            int j = 0;
            List<Integer> myList = new ArrayList<>();
            do {
                // System.out.println(i + "-" + j);
                myList.add(mat[i][j]);
                i++;
                j++;
            } while (i < m && j < n);
            Collections.sort(myList);
            i = x;
            j = 0;
            int counter = 0;
            do {
                mat[i][j] = myList.get(counter++);
                i++;
                j++;
            } while (i < m && j < n);
        }

        // going left to right
        for (int x = 1; x < n; x++) {
            int i = 0;
            int j = x;
            List<Integer> myList = new ArrayList<>();
            do {
                // System.out.println(i + "+" + j);
                myList.add(mat[i][j]);
                i++;
                j++;
            } while (i < m && j < n);
            Collections.sort(myList);
            i = 0;
            j = x;
            int counter = 0;
            do {
                mat[i][j] = myList.get(counter++);
                i++;
                j++;
            } while (i < m && j < n);
        }

        return mat;
    }

    private static void print(int[][] mat) {
        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat[0].length; j++) {
                System.out.print(mat[i][j] + "\t");
            }
            System.out.println();
        }

    }
}
