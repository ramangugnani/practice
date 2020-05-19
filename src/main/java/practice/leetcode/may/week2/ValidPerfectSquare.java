package practice.leetcode.may.week2;

public class ValidPerfectSquare {
	public static void main(String[] args) {

		for(int i = 0; i < 46341 ; i++) {
			System.out.print(i*i+",");
		}
		Integer res = (int)Math.sqrt(Integer.MAX_VALUE);
		System.out.println(res);
		Integer number = 2147483647;
		//Boolean result = isPerfectSquare(number);
		//Boolean result = isPerfectSquareNew(number);
		//System.out.println("result : "+ result);
	}

	public static boolean isPerfectSquare(int num) {
		for(Integer i = 0 ; i < Integer.MAX_VALUE ; i++) {
			Integer perfectSquare = i*i;
			if(perfectSquare < 0) {
				return false;
			}
			if(num == perfectSquare) {
				return true;
			}
			if(num < perfectSquare) {
				break;
			}
		}
		return false;
	}
	
	public static boolean isPerfectSquareNew(int num) {
		for(Integer i = 0 ; i < Integer.MAX_VALUE ; i++) {
			Integer perfectSquare = i*i;
			if(perfectSquare < 0) {
				return false;
			}
			if(num == perfectSquare) {
				return true;
			}
			if(num < perfectSquare) {
				break;
			}
		}
		return false;
	}
}
