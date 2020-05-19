package practice.leetcode.may.week1;

public class FirstBadVersion {
	public static void main(String[] args) {

	}

	public static int firstBadVersion(int n) {
		Integer left = 0;
		Integer right = n;
		
		while(left < right) {
			Integer mid = left + (right - left)/2;
			if(isBadVersion(mid)) {
				//left = left;
				right = mid;
			}else {
				left = mid + 1;
				//right = right;
			}
		};

		return left;
	}

	public static boolean isBadVersion(int version) {
		return false;
	}
}
