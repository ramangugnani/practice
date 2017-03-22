package practice.designpattern.pattern.structural.decorator.example2;

public class CoffeeMain {
	public static void main(String [] args){
		Coffee coffee = new SimpleCoffee();
		System.out.println("Cost        : "+coffee.getCost());
		System.out.println("Ingredients : "+coffee.getIngredients());
		CoffeeDecorator coffeeDecorator1 = new Milk(coffee);
		System.out.println("Cost        : "+coffeeDecorator1.getCost());
		System.out.println("Ingredients : "+coffeeDecorator1.getIngredients());
		CoffeeDecorator coffeeDecorator2 = new Milk(new WhipCream(coffee));
		System.out.println("Cost        : "+coffeeDecorator2.getCost());
		System.out.println("Ingredients : "+coffeeDecorator2.getIngredients());
	}
}
