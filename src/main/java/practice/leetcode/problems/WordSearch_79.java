package practice.leetcode.problems;

public class WordSearch_79 {

    public static void main(String[] args) {
        // char[][] board = new char[][] { { 'A', 'B', 'C', 'E' }, { 'S', 'F', 'C', 'S'
        // }, { 'A', 'D', 'E', 'E' } };
        // System.out.println(exist(board, "ABCCED"));
        //
        // char[][] board1 = new char[][] { { 'A', 'B', 'C', 'E' }, { 'S', 'F', 'C', 'S'
        // }, { 'A', 'D', 'E', 'E' } };
        // System.out.println(exist(board1, "SEE"));
        //
        // System.out.println(exist(board1, "ABCB"));

        // char[][] board2 = new char[][] { { 'C', 'A', 'A' }, { 'A', 'A', 'A' }, { 'B',
        // 'C', 'D' } };
        // System.out.println(exist(board2, "AAB"));

        char[][] board3 = new char[][] { { 'A', 'B', 'C', 'E' }, { 'S', 'F', 'E', 'S' }, { 'A', 'D', 'E', 'E' } };
        System.out.println(exist(board3, "ABCESEEEFS"));

    }

    public static boolean exist(char[][] board, String word) {
        Integer rows = board.length;
        Integer cols = board[0].length;

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                // if starting character matches
                if (board[i][j] == word.charAt(0)) {
                    boolean[][] visited = new boolean[rows][cols];
                    visited[i][j] = true;
                    System.out.println("STARTING i " + i + " j " + j + " index " + 0);
                    boolean result = bfs(board, visited, word, 0, i, j, rows, cols);
                    if (result) {
                        return result;
                    }
                }
            }
        }
        return false;
    }

    private static boolean bfs(char[][] board, boolean[][] visited, String word, int index, int i, int j, int rows,
            int cols) {
        if (index == word.length() - 1) {
            return true;
        } else {
            // System.out.println("i " + i + " j " + j + " index " + index + " char " +
            // word.charAt(index + 1));
            Boolean result = false;
            // proceed right
            int i1 = i + 1;
            int j1 = j;
            if (i1 < rows && i1 >= 0 && j1 < cols && j1 >= 0 && visited[i1][j1] == false
                    && board[i1][j1] == word.charAt(index + 1)) {
                visited[i1][j1] = true;
                // System.out.println("A i1 " + i1 + " j1 " + j1);
                result = bfs(board, visited, word, index + 1, i1, j1, rows, cols);
                if (result == true) {
                    return true;
                } else {
                    visited[i1][j1] = false;
                }
            }

            // proceed left
            i1 = i - 1;
            j1 = j;
            if (i1 < rows && i1 >= 0 && j1 < cols && j1 >= 0 && visited[i1][j1] == false
                    && board[i1][j1] == word.charAt(index + 1)) {
                visited[i1][j1] = true;
                // System.out.println("B i1 " + i1 + " j1 " + j1);
                result = bfs(board, visited, word, index + 1, i1, j1, rows, cols);
                if (result == true) {
                    return true;
                } else {
                    visited[i1][j1] = false;
                }
            }

            // proceed up
            i1 = i;
            j1 = j - 1;
            if (i1 < rows && i1 >= 0 && j1 < cols && j1 >= 0 && visited[i1][j1] == false
                    && board[i1][j1] == word.charAt(index + 1)) {
                visited[i1][j1] = true;
                // System.out.println("C i1 " + i1 + " j1 " + j1);
                result = bfs(board, visited, word, index + 1, i1, j1, rows, cols);
                if (result == true) {
                    return true;
                } else {
                    visited[i1][j1] = false;
                }
            }
            // proceed down
            i1 = i;
            j1 = j + 1;
            if (i1 < rows && i1 >= 0 && j1 < cols && j1 >= 0 && visited[i1][j1] == false
                    && board[i1][j1] == word.charAt(index + 1)) {
                visited[i1][j1] = true;
                // System.out.println("D i1 " + i1 + " j1 " + j1);
                result = bfs(board, visited, word, index + 1, i1, j1, rows, cols);
                if (result == true) {
                    return true;
                } else {
                    visited[i1][j1] = false;
                }
            }
        }
        return false;
    }
}
