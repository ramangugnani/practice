package practice.designpattern.pattern.structural.decorator.example1;

public abstract class HouseDecorator implements House{

	protected House house;
	HouseDecorator(House house){
		this.house = house;
	}
	@Override
	public String makeHouse() {
		return house.makeHouse();
	}

}
