package practice.algorithms.linkedlist;

import java.util.ArrayList;
import java.util.List;

public class InterviewBit {

	public static void main(String[] args) {

		//primesum(10);
		//System.out.println(isPower(10));
		//System.out.println(isPalindrome1(5));
		//System.out.println(reverse(-1146467285));
		List<ArrayList<Integer>> a = new ArrayList<>();
		ArrayList<Integer> a1 = new ArrayList<>(4);
		a1.add(1);a1.add(2);a1.add(3);a1.add(4);a1.add(21);
		ArrayList<Integer> a2 = new ArrayList<>(4);
		a2.add(5);a2.add(6);a2.add(7);a2.add(8);a2.add(22);
		ArrayList<Integer> a3 = new ArrayList<>(4);
		a3.add(9);a3.add(10);a3.add(11);a3.add(12);a3.add(23);
		ArrayList<Integer> a4 = new ArrayList<>(4);
		a4.add(13);a4.add(14);a4.add(15);a4.add(16);a4.add(24);
		ArrayList<Integer> a5 = new ArrayList<>(4);
		a5.add(17);a5.add(18);a5.add(19);a5.add(20);a5.add(25);
		a.add(a1);
		a.add(a2);
		a.add(a3);
		a.add(a4);
		a.add(a5);
		System.out.println(spiralOrder(a));
	}
	public static ArrayList<Integer>   primesum(int a) {
		boolean[] primeNumberList = new boolean[a+1];
		ArrayList<Integer> output = new ArrayList<Integer>();
		int lastNumberToIterate = (int)Math.sqrt(a);
		for(int i = 2; i <= lastNumberToIterate ; ++i){
			int number = i;
			int j= 2;
			number = i * j;
			while(number <=a){
				primeNumberList[number]= Boolean.TRUE;
				j++;
				number = i * j;
			}
		}
		for(int k = 2 ; k <= (a+1)/2 ; ++k){
			if(primeNumberList[k] ==Boolean.FALSE && primeNumberList[a-k] == Boolean.FALSE){
				if(output.size() ==0){
					output.add(k);
					output.add(a-k);
				}
				if(output.get(0)>k ){
					output.clear();
					output.add(k);
					output.add(a-k);
				}
			}
		}
		System.out.println(output);
		return output;
	}
	public int titleToNumber(String a) {
		char[] characterArray = a.toCharArray();
		int j = 0;
		int answer = 0;
		for(int i = characterArray.length -1; i >= 0 ; --i){
			answer = answer + (int) Math.pow(26,j)*(characterArray[characterArray.length-1]-'A'+1);
		}
		return answer;
	}

	public static boolean isPower(int a) {
		if(a == 1)
			return true;
		int limit = (int)Math.sqrt(a);
		for(int i = limit ; i > 1 ; --i){
			int j = 2;
			int number = (int)Math.pow(i,j);
			while(number <= a){
				if(number == a)
					return true;

				j++;
				number = (int)Math.pow(i,j);
			}
		}
		return false;
	}

	public static boolean isPalindrome(int a) {
		if (a < 0)
			return false;
		int divisor = 1;
		while(a / divisor >= 10){
			divisor = divisor * 10;
		}
		while(a > 10){
			int left = a / divisor;
			int right = a % 10;
			if(left != right)
				return false;


			a = a % divisor;
			a = a / 10;
			divisor = divisor/ 100;
			//a = (a % divisor)/10;
		}
		return true;
	}

	public static boolean isPalindrome1(int a) {
		if (a < 0)
			return false;
		int rev = 0;
		int b = a;
		while (a != 0)
		{
			rev = rev * 10 + a % 10;
			a /= 10;
		}
		if(rev == b)
			return true;
		else
			return false;
	}

	public static int reverse(int a) {
		boolean isNegative = a >= 0 ? false:true;
		long c = (long)Math.abs(a);

		long result = 0;
		while(c != 0){
			result = result*10 + (c%10);
			c = c/ 10;
		}
		if(isNegative)
			result = result - 2 * result;

		if(result < Integer.MIN_VALUE || result > Integer.MAX_VALUE)
			return 0;
		else
			return (int)result;
	}

	public static void  arrange(ArrayList<Integer> a) {
		int n = a.size();
		for (int i = 0; i < n; i++)
			a.set(i, a.get(1) + (a.get(a.get(i)) % n) * n);

		for (int i = 0; i < n; i++)
			a.set(i , a.get(1) / n);

	}

	public static ArrayList<Integer> spiralOrder(final List<ArrayList<Integer>> a) {
		ArrayList<Integer> result = new ArrayList<Integer>();
		int x1 = 0, y1 = 0;
		int x2 = 0 , y2 = a.get(0).size()-1;
		int x3 = a.size()-1 , y3 = 0;
		int x4 = a.size()-1 , y4 = a.get(0).size()-1;
		int initialSize = (x4+1)*(y2+1);
		
		if(initialSize == 1){
			result.add(a.get(0).get(0));
			return result;
		}
		while(true){
			for(int i = y1 ; i < y2 ; i++){
				if(result.size() == initialSize)
					break;
				System.out.println("[A]"+x1+","+i);
				result.add(a.get(x1).get(i));
			}
			
			
			
			for(int i = x2 ; i < x4 ; i++){
				if(result.size() == initialSize)
					break;
				System.out.println("[B]"+i+","+y2);
				result.add(a.get(i).get(y2));
			}
			
			
			for(int i = y4 ; i > y3 ; i--){
				if(result.size() == initialSize)
					break;
				System.out.println("[C]"+x3+","+i);
				result.add(a.get(x3).get(i));
			}
			
			
			for(int i = x3 ; i > x1 ; i--){
				if(result.size() == initialSize)
					break;
				System.out.println("[D]"+i+","+y3);
				result.add(a.get(i).get(y3));
			}
			
			if(result.size() == initialSize)
				break;
			
			x1++;y1++;
			x2++;y2--;
			x4--;y4--;
			x3--;y3++;
			
			if(x1 == y1 && y1 == x2 && x2 ==  y2 && y2 == x4 && x4 == y4 && y4 == x3 && x3 == y3){
				result.add(a.get(x1).get(y1));
				break;
			}
		}
		return result;
	}

}
