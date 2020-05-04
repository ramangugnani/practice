package practice.designpattern.pattern.creational.builder;

public class HouseClientMain {

	public static void main(String[] args) {
		HouseDirector director = new HouseDirector();
		HouseBuilder woodBuilder = new WoodBuilder();
		HouseBuilder brickBuilder = new BrickBuilder();
		House  woodHouse = director.constructHouse(woodBuilder);
		System.out.println(woodHouse.getRepresentation());
		House brickHouse = director.constructHouse(brickBuilder);
		System.out.println(brickHouse.getRepresentation());
	}

}
