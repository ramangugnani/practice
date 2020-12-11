package practice.leetcode.june.week1;

public class ReverseString {
	public static void main(String[] args) {
		char[] s = new char[] {'a','b','c'};
		print(s);
		reverseString(s);
		print(s);
	}

	public static void reverseString(char[] s) {
		if(null != s) {
			for(int i = 0 ; i < s.length/2 ; i++) {
				char temp = s[i];
				s[i] = s[s.length-i-1];
				s[s.length-i-1] = temp;
			}
		}
	}
	
	private static void print(char[] s) {
		if(null != s) {
			for(int i = 0 ; i < s.length ; i++) {
				System.out.print(s[i]+" ");
			}
			System.out.println();
		}
	}
}
