package practice.designpattern.pattern.structural.decorator.example2;

public class Choclate extends CoffeeDecorator{

	Choclate(Coffee coffee) {
		super(coffee);
	}
	public double getCost() {
		return coffee.getCost()+ 1.0;
	}

	public String getIngredients() {
		return coffee.getIngredients() + " Choclate ";
	}
}
