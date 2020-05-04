package practice.designpattern.problem.allpattern;

public class Shopping {
	/**
	 * Class with main(String[] args) method which initially gets loaded by the
	 * class loader. Subsequent classes are loaded as they are referenced in the program.
	 */
	public static void main(String[] args) throws ItemException {
		process();
	}
	
	public static void process() throws ItemException {
		//------ creational patterns: singleton, factory method and builder design patterns------
		System.out.println("----create a shopping basket with items ---");
		//Shopping basket using the builder pattern
		ItemBuilder builder = new ShoppingBasketBuilder();
		//build basket of items using a builder pattern
		builder.buildBasket(Item.TYPE_BOOK, "Book - IT", 1, 12.00);
		builder.buildBasket(Item.TYPE_CD, "CD - JAZZ", 1, 15.00);
		builder.buildBasket(Item.TYPE_COSMETICS, "Cosmetics - Lipstick", 1, 1.0);

		//let’s print prices and taxes of this built basket
		double totalTax = builder.calculateTotalTax();
		builder.printExtendedTaxedPrice();
		System.out.println("Sales Taxes: " + totalTax); 
		System.out.println("Grand Total: " + builder.calculateTotal());
		System.out.println("----- After adding an imported CD to the basket ----");

		//Say now customer decides to buy an additional imported CD
		builder.buildBasket(Item.TYPE_CD_IMPORTED, "CD - JAZZ IMPORTED", 1, 15.00);

		//lets print prices and taxes of this built basket with imported CD added
		totalTax = builder.calculateTotalTax();
		builder.printExtendedTaxedPrice();
		System.out.println("Sales Taxes: " + totalTax);
		System.out.println("Grand Total: " + builder.calculateTotal());
	}
	
}