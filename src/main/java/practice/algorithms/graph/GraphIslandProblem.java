package practice.algorithms.graph;

import java.util.Random;

public class GraphIslandProblem {
	public static final Integer MAX_ROWS = 10;
	public static final Integer MAX_COLS = 10;
	public static void main(String[] args) {
		int[][] world = new int[MAX_ROWS][MAX_COLS];
		for(int i = 0 ; i <  MAX_ROWS ; ++i){
			for(int j = 0 ; j < MAX_COLS ; j++){
				world[i][j] = new Random().nextInt(2);
			}

		}
		for(int i = 0 ; i <  MAX_ROWS ; ++i){
			for(int j = 0 ; j < MAX_COLS ; j++){
				System.out.print(world[i][j]+" ");
			}
			System.out.println();
		}
		Integer numberOfIsland = calculateIsland(world);
		System.out.println("\n\n");
		System.out.println("Island "+numberOfIsland);
	}

	private static Integer calculateIsland(int[][] world) {
		Integer numberOfIsland = 0;

		Integer[][] directions = new Integer[4][2];
		directions[0][0] =  0; directions[0][1] =  1;
		directions[1][0] =  0; directions[1][1] = -1;
		directions[2][0] =  1; directions[2][1] =  0;
		directions[3][0] = -1; directions[3][1] =  0;


		for(int i = 0 ; i <  MAX_ROWS ; ++i){
			for(int j = 0 ; j < MAX_COLS ; j++){
				if(world[i][j] == 0){
					/* Start of a island */
					markVisitedRecursively(world,i,j,directions);
					numberOfIsland++;
				}
			}
		}
		return numberOfIsland;
	}

	private static void markVisitedRecursively(int[][] world, int row, int col, Integer[][] directions) {
		world[row][col] = 1;
		for(int k = 0 ; k < 4 ; k++){
			int nextRowDirection = row + directions[k][0];
			int nextColDirection = col + directions[k][1];
			if(nextRowDirection >= 0 && nextRowDirection < MAX_ROWS 
					&& nextColDirection >=  0 && nextColDirection < MAX_COLS 
					&& world[nextRowDirection][nextColDirection] == 0){
				markVisitedRecursively(world, row + directions[k][0], col + directions[k][1], directions);
			}
		}

	}
}
