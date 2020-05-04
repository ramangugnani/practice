package practice.designpattern.pattern.structural.decorator.example1;

public class DecoratorMain {
	public static void main(String [] args){
		House house = new LightsDecorator(new ColorDecorator(new SimpleHouse()));
		System.out.println(house.makeHouse());
	}
}
