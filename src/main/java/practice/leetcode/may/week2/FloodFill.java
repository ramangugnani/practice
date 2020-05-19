package practice.leetcode.may.week2;

public class FloodFill {
	public static void main(String[] args) {

		int[][] image = new int[][] { { 1, 1, 1 }, { 1, 1, 0 }, { 1, 0, 1 } };
		int sr = 0;
		int sc = 0;
		int newColor = 2;
		System.out.println("IMAGE");
		print(image);
		int[][] result = floodFill(image, sr, sc, newColor);
		System.out.println("NEW IMAGE");
		print(result);

	}

	public static int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
		int[][] visited = new int[image.length][image[0].length];
		int[][] directions = new int[][] { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 } };
		int oldColor = image[sr][sc];
		int maxDirectionX = image.length;
		int maxDirectionY = image[0].length;
		bfs(image, visited, directions, oldColor, newColor, sr, sc, maxDirectionX, maxDirectionY);
		return image;
	}

	private static void bfs(int[][] image, int[][] visited, int[][] directions, int oldColor, int newColor, int sr,
			int sc, int maxDirectionX, int maxDirectionY) {
		image[sr][sc] = newColor;
		visited[sr][sc] = 1;
		for (int i = 0; i < directions.length; i++) {
			int directionX = directions[i][0];
			int directionY = directions[i][1];
			//System.out.println((sr + directionX) + ", " + (sc + directionY));
			if (isSafe(sr + directionX, sc + directionY, maxDirectionX, maxDirectionY)
					&& visited[sr + directionX][sc + directionY] == 0
					&& image[sr + directionX][sc + directionY] == oldColor) {
				bfs(image, visited, directions, oldColor, newColor, sr + directionX, sc + directionY, maxDirectionX,
						maxDirectionY);
			}
		}
	}

	private static boolean isSafe(int newDirectionX, int newDirectionY, int maxDirectionX, int maxDirectionY) {
		if (newDirectionX >= 0 && newDirectionX < maxDirectionX && newDirectionY >= 0
				&& newDirectionY < maxDirectionY) {
			return true;
		} else {
			return false;
		}
	}

	public static void print(int[][] result) {
		for (int i = 0; i < result.length; i++) {
			for (int j = 0; j < result[i].length; j++) {
				System.out.print(result[i][j] + "\t");
			}
			System.out.println();
		}
	}
}
