package practice.designpattern.problem.allpattern;

public abstract class Goods implements Item{

	private String description;
	private int qty;
	private double price;
	private Tax tax = new Tax();
	
	public Goods(String description, int qty, double price) {
		super();
		this.description = description;
		this.qty = qty;
		this.price = price;
	}
	
	protected abstract boolean isTaxed();
	
	protected abstract boolean isImported();
	
	public double getExtendedTax(){
		tax.caclualte(isTaxed(), isImported(), price);
		return this.tax.getTotalUnitTax()*qty;
	}
	
	public double getExtendedTaxPrice() throws ItemException{
		if(tax == null){
			throw new ItemException("Tax should be calculated first.");
		}
		return qty *(this.tax.getTotalUnitTax() + price);
	}
	
	public String getDescription(){
		return description; 
	}
	
	@Override
	public String toString() {
		return qty + " " + description + " : ";
	}
}
