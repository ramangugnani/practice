package practice.designpattern.problem.problem03;

public class Cashier {
	GroceryStore myStore;
	public void takePosition(GroceryStore store){
		myStore = store;
	}
	public double getBill(GroceryItem[] item){
		double total = 0;
		int itemNumber = 0;;
		while(item[itemNumber] != null){
			total = total + item[itemNumber].getPrice();
			System.out.println(item[itemNumber].getName() + " " + item[itemNumber].getPrice());
			itemNumber++;
		}
		System.out.println("TOTAL "+total);
		return total;
	}
	public void pay(double amount){
		myStore.money = myStore.money + amount;
	}
}
