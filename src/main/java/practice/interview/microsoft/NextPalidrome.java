package practice.interview.microsoft;

public class NextPalidrome {
	public static void main(String[] args) {
		int[] number = new int[]{1,2,3};
		int[] nextPalindrome =  getNextPalindrome(number);
	}

	private static int[] getNextPalindrome(int[] number) {
		int sizeOfNumber = number.length;
		int[] num = all9s(number);
		/* not a all 9s */
		if(num == null){
			int centreOfNumber = number.length /2;
			
			boolean leftIsSmaller = false;
			int endOfLeftSide = centreOfNumber -1;
			int startOfRightSide = (number.length % 2) ==0 ? centreOfNumber +1 : centreOfNumber;
			//ignoring middle same digits
			while(endOfLeftSide >= 0 && number[endOfLeftSide] == number[startOfRightSide] ){
				endOfLeftSide--;
				startOfRightSide++;
			}
			
			// now need to find which part is smaller 
			if(endOfLeftSide < 0 || number[endOfLeftSide] < number[startOfRightSide]){
				leftIsSmaller = true;
			}
			
			//copying that
			while(endOfLeftSide >= 0){
				number[startOfRightSide] = number[endOfLeftSide];
				endOfLeftSide--;
				startOfRightSide++;
			}
			
			if(leftIsSmaller == true){
				int carry = 1;
				endOfLeftSide = centreOfNumber -1;
				// if odd then we need to increment the centre one
				if(number.length % 2 == 1){
					number[centreOfNumber] = number[centreOfNumber] + carry;
					//number can overflow
					carry = number[endOfLeftSide] / 10;
					number[endOfLeftSide] = number[endOfLeftSide]%10;
					startOfRightSide = centreOfNumber+1;
				}else{
					startOfRightSide = centreOfNumber;
				}
				
				//center part is done , now need to propagate on left and right and copying the carries over them
				while(endOfLeftSide >= 0){
					number[endOfLeftSide] = number[endOfLeftSide] + carry;
					carry = number[endOfLeftSide] / 10;
					number[endOfLeftSide] = number[endOfLeftSide] % 10;
					//copying side by side
					number[startOfRightSide++] = number[endOfLeftSide--];
				}
			}
		}
		return null;
	}

	static int[]  all9s(int[] number){
		boolean all9s = true;
		int[] num = null;
		for(int i = 0 ; i < number.length ; ++i){
			if(number[i] != 9){
				all9s = false;
				break;
			}
		}
		if(all9s){
			num = new int[number.length+1];
			num[0] = 1;
			num[number.length] = 1;
			for(int i = 1 ; i < number.length ; ++i){
				num[i] = 0;
			}
		}
		return num;
	}
}
