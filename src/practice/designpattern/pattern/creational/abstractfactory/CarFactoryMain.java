package practice.designpattern.pattern.creational.abstractfactory;

public class CarFactoryMain {

	public static void main(String[] args) {
		CarFactory carFactory = new CarFactory();
		Car car = carFactory.getCar("BMW");
		System.out.println(car.getBody().getSpecification());
		System.out.println(car.getMirrors().getSpecification());
		System.out.println(car.getEngine().getSpecification());
		System.out.println(car.getWheels().getSpecification());
		
		car = carFactory.getCar("GM");
		System.out.println(car.getBody().getSpecification());
		System.out.println(car.getMirrors().getSpecification());
		System.out.println(car.getEngine().getSpecification());
		System.out.println(car.getWheels().getSpecification());

	}

}
