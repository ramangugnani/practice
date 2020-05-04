package practice.designpattern.problem.problem03;

import java.util.Random;

public class Customer {
	GroceryItem[] myShoppingBasket = new GroceryItem[20];
	Random random = new Random();
	double myMoney = 100.0;
	public void shop(GroceryStore store){
		selectGroceries(store);
		checkOut(store);
	}
	private void selectGroceries(GroceryStore store) {
		int itemsInMyBasket = 0;
		for(int i =0 ; i < store.KIND_OF_ITEMS; i++){
			for(int j = 0 ; j < 3 ; j++){
				if(random.nextInt(2) ==1){
					myShoppingBasket[itemsInMyBasket] = store.item[i];
					store.itemCount[i] = store.itemCount[i] - 1;
					itemsInMyBasket = itemsInMyBasket +1;
				}
			}
		}
	}
	private void checkOut(GroceryStore store){
		Cashier cashier = store.getCashier();
		double total = cashier.getBill(myShoppingBasket);
		myMoney = myMoney -total;
		cashier.pay(total);
	}
	
}
