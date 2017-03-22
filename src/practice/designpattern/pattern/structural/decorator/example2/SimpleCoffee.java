package practice.designpattern.pattern.structural.decorator.example2;

public class SimpleCoffee implements Coffee{

	@Override
	public double getCost() {
		return 1.0;
	}

	@Override
	public String getIngredients() {
		return "Coffee";
	}

}
