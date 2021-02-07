package practice.leetcode.problems;

public class PathWithMinimumEffort_1631 {
	public static void main(String[] args) {
		System.out.println(minimumEffortPath(new int[][] { { 1, 2, 2 }, { 3, 8, 2 }, { 5, 3, 5 } }));

		System.out.println(minimumEffortPath(new int[][] { { 1, 2, 3 }, { 3, 8, 4 }, { 5, 3, 5 } }));

		System.out.println(minimumEffortPath(new int[][] { { 1, 2, 1, 1, 1 }, { 1, 2, 1, 2, 1 }, { 1, 2, 1, 2, 1 },
				{ 1, 2, 1, 2, 1 }, { 1, 1, 1, 2, 1 } }));

		System.out.println(minimumEffortPath(new int[][] { { 1 } }));

	}

	public static int minimumEffortPath(int[][] heights) {
		int rowM = heights.length;
		int colM = heights[0].length;
		Integer[][] newHights = new Integer[rowM + 1][colM + 1];
		for (int i = 0; i <= rowM; i++) {
			newHights[i][0] = null;
		}
		for (int i = 0; i <= colM; i++) {
			newHights[0][i] = null;
		}
		for (int i = 1; i <= rowM; i++) {
			for (int j = 1; j <= colM; j++) {

				// System.out.println(i + "," + j);
				Integer newHeightFromTop = (i - 2) >= 0 ? Math.abs(heights[i - 1][j - 1] - heights[i - 2][j - 1])
						: null;
				Integer curHeightFromTop = newHights[i - 1][j];
				Integer newHeightFromTopFinal = getMax(newHeightFromTop, curHeightFromTop);

				// System.out.println("newHeightFromTop " + newHeightFromTop + "
				// curHeightFromTop " + curHeightFromTop
				// + " newHeightFromTopFinal " + newHeightFromTopFinal);

				Integer newHeightFromSide = (j - 2 >= 0) ? Math.abs(heights[i - 1][j - 1] - heights[i - 1][j - 2])
						: null;
				Integer curHeightFromSide = newHights[i][j - 1];
				Integer newHeightFromSideFinal = getMax(newHeightFromSide, curHeightFromSide);

				// System.out.println("newHeightFromSide " + newHeightFromSide + "
				// curHeightFromSide " + curHeightFromSide
				// + " newHeightFromSideFinal " + newHeightFromSideFinal);

				Integer newHeight = getMin(newHeightFromTopFinal, newHeightFromSideFinal);
				// System.out.println("newHeight " + newHeight);
				newHights[i][j] = newHeight;
			}
		}

		for (int i = 0; i <= rowM; i++) {
			for (int j = 0; j <= colM; j++) {
				System.out.print(newHights[i][j] + "\t");
			}
			System.out.println();
		}
		return newHights[rowM][colM] == null ? 0 : newHights[rowM][colM];
	}

	public static Integer getMax(Integer a, Integer b) {
		if (null == a) {
			return b;
		}
		if (null == b) {
			return a;
		}
		return Math.max(a, b);
	}

	public static Integer getMin(Integer a, Integer b) {
		if (null == a) {
			return b;
		}
		if (null == b) {
			return a;
		}
		return Math.min(a, b);
	}
}
