package practice.designpattern.problem.problem03;

public class GroceryStore {
	Cashier myCashier;
	public int KIND_OF_ITEMS = 4;
	public GroceryItem[] item = new GroceryItem[KIND_OF_ITEMS];
	public int [] itemCount = new int[KIND_OF_ITEMS];
	double money = 1000.0;
	
	public GroceryStore() {
		item[0] = new GroceryItem("milk", 2.12);
		item[1] = new GroceryItem("butter", 2.50);
		item[2] = new GroceryItem("eggs", 0.89);
		item[3] = new GroceryItem("bread", 1.59);
		for(int i =0 ;i < KIND_OF_ITEMS ; i++){
			itemCount[i] = 50;
		}
	}
	
	public void hire(Cashier cashier){
		myCashier = cashier;
		cashier.takePosition(this);
	}
	
	public Cashier getCashier(){
		return myCashier;
	}
	
	public static void main(String[] args) {
		GroceryStore store = new GroceryStore();
		Cashier cashier = new Cashier();
		store.hire(cashier);
		Customer customer = new Customer();
		customer.shop(store);
	}
}
