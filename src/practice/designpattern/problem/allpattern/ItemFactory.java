package practice.designpattern.problem.allpattern;

public abstract class ItemFactory {
	public abstract Item getItem(int itemType,String description,int qty,double price) throws ItemException;
}
