package practice.designpattern.pattern.structural.decorator.example2;

public abstract class CoffeeDecorator implements Coffee{
	protected Coffee coffee;
	CoffeeDecorator(Coffee coffee){
		this.coffee = coffee;
	}
	public double getCost() {
		return coffee.getCost();
	}

	public String getIngredients() {
		return coffee.getIngredients();
	}
}
