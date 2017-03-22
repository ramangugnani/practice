package practice.designpattern.pattern.creational.abstractfactory;

public abstract class Car {
	public  Parts getWheels(){
		return null;
	}
	public abstract Parts getMirrors();
	public abstract Parts getEngine();
	public abstract Parts getBody();
}
