package practice.leetcode.problems;

public class SetMatrixZeroes_73 {

    public static void main(String[] args) {
        // int[][] matrix = new int[][] { { 1, 1, 1 }, { 1, 0, 1 }, { 1, 1, 1 } };
        // System.out.println("=== INPUT ====");
        // print(matrix);
        // setZeroes(matrix);
        // System.out.println("=== OUTPUT ====");
        // print(matrix);
        //
        // int[][] matrix1 = new int[][] { { 0, 1, 2, 0 }, { 3, 4, 5, 2 }, { 1, 3, 1, 5
        // } };
        // System.out.println("=== INPUT ====");
        // print(matrix1);
        // setZeroes(matrix1);
        // System.out.println("=== OUTPUT ====");
        // print(matrix1);

        int[][] matrix2 = new int[][] { { 1, 2, 3, 4 }, { 5, 0, 7, 8 }, { 0, 10, 11, 12 }, { 13, 14, 15, 0 } };
        System.out.println("=== INPUT ====");
        print(matrix2);
        setZeroes(matrix2);
        System.out.println("=== OUTPUT ====");
        print(matrix2);
    }

    public static void setZeroes(int[][] matrix) {

        boolean fr = false,fc = false;
        for(int i = 0; i < matrix.length; i++) {
            for(int j = 0; j < matrix[0].length; j++) {
                if(matrix[i][j] == 0) {
                    if(i == 0) fr = true;
                    if(j == 0) fc = true;
                    matrix[0][j] = 0;
                    matrix[i][0] = 0;
                }
            }
        }
        for(int i = 1; i < matrix.length; i++) {
            for(int j = 1; j < matrix[0].length; j++) {
                if(matrix[i][0] == 0 || matrix[0][j] == 0) {
                    matrix[i][j] = 0;
                }
            }
        }
        if(fr) {
            for(int j = 0; j < matrix[0].length; j++) {
                matrix[0][j] = 0;
            }
        }
        if(fc) {
            for(int i = 0; i < matrix.length; i++) {
                matrix[i][0] = 0;
            }
        }

    }

    public static void print(int[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }
}
