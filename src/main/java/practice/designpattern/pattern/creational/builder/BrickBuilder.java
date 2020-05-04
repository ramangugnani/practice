package practice.designpattern.pattern.creational.builder;

public class BrickBuilder extends HouseBuilder{

	@Override
	public House createHouse() {
		house = new BrickHouse();
		return house;
	}

	@Override
	public Floor createFloor() {
		floor = new BrickFloor();
		return floor;
	}

	@Override
	public Walls createWalls() {
		walls = new BrickWalls();
		return walls;
	}

	@Override
	public Roof createRoof() {
		roof = new BrickRoof();
		return roof;
	}

}
