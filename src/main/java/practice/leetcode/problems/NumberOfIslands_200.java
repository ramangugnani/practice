package practice.leetcode.problems;

public class NumberOfIslands_200 {

	public static void main(String[] args) {
		char[][] grid = new char[][] { { '1', '1', '0', '1', '0' }, { '1', '1', '0', '1', '0' },
				{ '1', '1', '0', '0', '0' }, { '0', '0', '0', '0', '0' } };
		System.out.println(numIslands(grid));
	}
	
	public static int[][] directions = new int[][] { { 0, 1 }, { 0, -1 }, { 1, 0 }, { -1, 0 } };

	public static int numIslands(char[][] grid) {
		Integer numberOfIslands = 0;
		Integer maxRows = grid.length;
		Integer maxCols = grid[0].length;
		for (int row = 0; row < maxRows; row++) {
			for (int col = 0; col < maxCols; col++) {
				if (grid[row][col] == '1') {
					// increase island
					numberOfIslands++;
					traverse(grid, row, col, maxRows, maxCols);
				}
			}
		}
		return numberOfIslands;
	}

	public static void traverse(char[][] grid, int row, int col,
			Integer maxRows, Integer maxCols) {
		if (grid[row][col] == '0') {
			return;
		} else {
			// mark it visited
			grid[row][col] = '0';
			// traverse its neighbors and mark them visited
			// right left down up
			for (int direction = 0; direction < directions.length; direction++) {
				if (!(row + directions[direction][0] < 0 
						|| row + directions[direction][0] >= maxRows
						|| col + directions[direction][1] < 0 
						|| col + directions[direction][1] >= maxCols)) {
					traverse(grid, row + directions[direction][0],
							col + directions[direction][1], maxRows,
							maxCols);
				}
			}
		}
	}

}
