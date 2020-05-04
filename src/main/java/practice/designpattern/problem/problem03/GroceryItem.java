package practice.designpattern.problem.problem03;

public class GroceryItem {
	private String name;
	private Double price;
	public GroceryItem(String name,Double price) {
		this.name = name;
		this.price = price;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Double getPrice() {
		return price;
	}
	public void setPrice(Double price) {
		this.price = price;
	}
}
