package practice.designpattern.pattern.structural.decorator.example1;

public class ColorDecorator extends HouseDecorator{

	ColorDecorator(House house) {
		super(house);
	}

	public String makeHouse(){
		return house.makeHouse() + addColors();
	}

	private String addColors() {
		return " + Colors";
	}
}
