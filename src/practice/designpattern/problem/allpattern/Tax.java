package practice.designpattern.problem.allpattern;

public class Tax {
	public static final double SALES_TAX = 0.10;
	public static final double IMPORT_TAX = 0.05;
	
	private double salesTax = 0.0;
	private double importTax = 0.0;
	
	public void caclualte(boolean isTaxable,boolean isImported,double price){
		if(isTaxable){
			salesTax = price * SALES_TAX;
		}
		if(isImported){
			salesTax = price * IMPORT_TAX;
		}
	}
	
	public double getTotalUnitTax(){
		return this.salesTax + this.importTax;
	}
}
