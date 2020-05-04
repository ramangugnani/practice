package practice.designpattern.problem.allpattern;

import java.util.Iterator;

public interface ItemBuilder {
	public void buildBasket(int itemType, String description, int qty, double unit_price) throws ItemException;
	public double calculateTotalTax() throws ItemException;
	public double calculateTotal() throws ItemException;
	public void printExtendedTaxedPrice() throws ItemException;
	public Iterator getIterator(); 
}
