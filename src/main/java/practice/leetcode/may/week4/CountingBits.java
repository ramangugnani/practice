package practice.leetcode.may.week4;

public class CountingBits {
	public static void main(String[] args) {
		int num = 10;
		int[] result = countBits(num);
		for(int i = 0; i < result.length; i++) {
			System.out.print(result[i]+" ");
		}
	}

	public static int[] countBits(int num) {
		int[] res = new int[num+1];
		res[0] = 0;
		for(int i = 1 ; i <= num ; i++) {
			res[i] = res[i>>1] + (i & 1);
		}
		return res;
	}
}
