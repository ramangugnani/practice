package practice.designpattern.problem.allpattern;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Builder pattern: To simplify complex object creation by defining a class whose purpose is to
 * build instances of another class.
 * There is a subtle difference between a builder pattern and the factory pattern is that in builder
 * pattern, the user is given the choice to create the type of object he/she wants but the
 * construction process is the same. But with the factory method pattern the factory decides how to
 * create one of several possible classes based on data provided to it.
 */ 
public class ShoppingBasketBuilder implements ItemBuilder{

	private List listItems = null;
	private void addItem(Item item) {
		if (listItems == null) {
			listItems = new ArrayList(20);
		}
		listItems.add(item);
	}
	/**
	 * builds a shopping basket
	 */
	public void buildBasket(int itemType, String description, int qty, double unit_price) throws ItemException {
		//get the single instance of GoodsFactory using the singleton pattern
		//no matter how many times you call getInstance() you get access to the same instance.
		ItemFactory factory = ItemFactorySelector.getItemFactory();

		//use factory method pattern to create item objects, based on itemType supplied to it.
		Item item = factory.getItem(itemType, description, qty, unit_price);
		this.addItem(item); //adds the item to the basket
	}
	/**
	 * calculates total tax on the items in the built basket
	 */
	public double calculateTotalTax()
			throws ItemException {
		if (listItems == null) {
			throw new ItemException("No items in the basket"); 
		}
		double totalTax = 0.0;
		Iterator it = listItems.iterator();
		while (it.hasNext()) {
			Item item = (Item) it.next();
			totalTax += item.getExtendedTax();
		}
		return totalTax;
	}
	/**
	 * calculates total price on the items in the built basket
	 */
	public double calculateTotal() throws ItemException {
		if (listItems == null) {
			throw new ItemException("No items in the basket");
		}
		double total = 0.0;
		Iterator it = listItems.iterator();
		while (it.hasNext()) {
			Item item = (Item) it.next();
			total += item.getExtendedTaxPrice();
		}
		return total;
	}
	/**
	 * prints individual prices of the items in the built basket
	 */
	public void printExtendedTaxedPrice() throws ItemException {
		if (listItems == null) {
			throw new ItemException("No items in the basket");
		}
		double totalTax = 0.0;
		Iterator it = listItems.iterator();
		while (it.hasNext()) {
			Item item = (Item) it.next();
			System.out.println(item + "" + item.getExtendedTaxPrice());
		}
	}
	public Iterator getIterator() {
		return listItems.iterator();
	}
} 
