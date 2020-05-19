package practice.leetcode.may.week3;

public class OnlineStockSpan {
	public static void main(String[] args) {
		StockSpanner obj = new StockSpanner();
		int price = 100;
		int result = obj.next(price);
		System.out.println("result "+result);
		
		price = 80;
		result = obj.next(price);
		System.out.println("result "+result);
		
		price = 60;
		result = obj.next(price);
		System.out.println("result "+result);
		
		price = 70;
		result = obj.next(price);
		System.out.println("result "+result);
		
		price = 60;
		result = obj.next(price);
		System.out.println("result "+result);
		
		price = 75;
		result = obj.next(price);
		System.out.println("result "+result);
		
		price = 85;
		result = obj.next(price);
		System.out.println("result "+result);
		
		
	}
}

class StockSpanner {
	private int[] priceArr ;
	private int[] spanArr;
	private int index = -1;
	public StockSpanner() {
		priceArr = new int[10000];
		spanArr = new int[10000];
	}

	public int next(int price) {
		index++;
		priceArr[index] = price; 
		if(index == 0) {
			spanArr[index] = 1;
		}else {
			spanArr[index] = 1;
			int tempIndex = index-1;
			while(tempIndex >=0 && priceArr[tempIndex] <= price) {
				spanArr[index] = spanArr[index] + spanArr[tempIndex];
				tempIndex = tempIndex - spanArr[tempIndex];
			}
		}
		return spanArr[index];
	}
}