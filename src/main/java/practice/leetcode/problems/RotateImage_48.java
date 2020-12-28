package practice.leetcode.problems;

public class RotateImage_48 {
    public static void main(String[] args) {
        int[][] matrix = new int[][] { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 } };
        System.out.println("==== INPUT ====");
        print(matrix);
        rotate(matrix);
        System.out.println("==== OUTPUT ====");
        print(matrix);

        int[][] matrix1 = new int[][] { { 1, 2, 3, 4 }, { 5, 6, 7, 8 }, { 9, 10, 11, 12 }, { 13, 14, 15, 16 } };
        System.out.println("==== INPUT ====");
        print(matrix1);
        rotate(matrix1);
        System.out.println("==== OUTPUT ====");
        print(matrix1);
    }

    public static void rotate(int[][] matrix) {
        Integer l = matrix.length - 1;

        // System.out.println(length);
        for (int i = 0; i < (l + 2) / 2; i++) {
            for (int j = i; j < l - i; j++) {
                //System.out.println(i + " " + j);
                Integer temp0 = matrix[i][j];
                Integer temp1 = matrix[j][l - i];
                Integer temp2 = matrix[l - i][l - j];
                Integer temp3 = matrix[l - j][i];

                matrix[i][j] = temp3;
                matrix[j][l - i] = temp0;
                matrix[l - i][l - j] = temp1;
                matrix[l - j][i] = temp2;

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
