package practice.leetcode.june.week1;

public class Solution {
	Integer totalCount = 0;
	int[] newW = null;
	public Solution(int[] w) {
		newW = new int[w.length];
		for (int i = 0; i < w.length; i++) {
			newW[i] = totalCount + w[i];
			totalCount = newW[i];
		}
	}

	public int pickIndex() {
		int random = (int) (totalCount * Math.random());
		for(int i = 0 ; i < newW.length ; i++) {
			if(random < newW[i]) {
				return i;
			}
		}
		return -1;
	}


	public static void main(String[] args) {
		
		int[] w = new int[] { 1, 3, 1 };
		Solution obj = new Solution(w);
		System.out.println(obj.pickIndex());
		System.out.println(obj.pickIndex());
		System.out.println(obj.pickIndex());
		System.out.println(obj.pickIndex());
		System.out.println(obj.pickIndex());
		System.out.println(obj.pickIndex());
		System.out.println(obj.pickIndex());

	}
}
