package practice.algorithms.strings;

public class AllPermutation {
	public static void main(String[] args) {
		String str = "012";
		allPermutation(str,0,str.length()-1);
	}

	private static void allPermutation(String str, int l, int r) {
		if(l == r){
			System.out.println(str.toString());
		}else{
			for(int i = l ; i <= r ; i++){
				str = swap(str,l,i);
				allPermutation(str, l+1, r);
				str = swap(str,l,i);
			}
		}
	}

	private static String swap(String str, int i, int j) {
		char[] charArray = str.toCharArray();
		char temp = charArray[i];
		charArray[i] =  charArray[j];
		charArray[j] = temp;
		return String.valueOf(charArray);
	}
}
