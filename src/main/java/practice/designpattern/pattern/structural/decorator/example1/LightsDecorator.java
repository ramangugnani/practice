package practice.designpattern.pattern.structural.decorator.example1;

public class LightsDecorator extends HouseDecorator{

	LightsDecorator(House house) {
		super(house);
	}

	public String makeHouse(){
		return house.makeHouse() + addLights();
	}

	private String addLights() {
		return " + Lights";
	}
}
