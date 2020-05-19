package practice.leetcode.may.week2;

public class CheckStraightLine {
	public static void main(String[] args) {
		int[][] coordinates = new int[6][2];
		//[[1,1],[2,2],[3,4],[4,5],[5,6],[7,7]]
		coordinates[0][0] = -10000;
		coordinates[0][1] = -10000;
		
		coordinates[1][0] = 2;
		coordinates[1][1] = 2;
		
		coordinates[2][0] = 3;
		coordinates[2][1] = 3;
		
		coordinates[3][0] = 4;
		coordinates[3][1] = 4;
		
		coordinates[4][0] = 5;
		coordinates[4][1] = 5;
		
		coordinates[5][0] = 10000;
		coordinates[5][1] = 10000;
				
		Boolean result = checkStraightLine(coordinates);
		
		System.out.println("result : "+result);
	}

	public static boolean checkStraightLine(int[][] coordinates) {
		if(coordinates.length == 2) {
			return true;
		}
		Integer num = coordinates[1][1] - coordinates[0][1];
		Integer den = coordinates[1][0] - coordinates[0][0];
		
		for(int i = 2 ; i < coordinates.length ; i++) {
			Integer numNew = coordinates[i][1] - coordinates[0][1];
			Integer denNew = coordinates[i][0] - coordinates[0][0];
			if(num * denNew != den * numNew) {
				return false;
			}
		}
		return true;
	}
}
