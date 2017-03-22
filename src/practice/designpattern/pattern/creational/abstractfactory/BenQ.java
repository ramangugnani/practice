package practice.designpattern.pattern.creational.abstractfactory;

public class BenQ extends Car{

	@Override
	public Parts getWheels() {
		return new Parts("BenQ Wheels");
	}

	@Override
	public Parts getMirrors() {
		return new Parts("BenQ Mirror");
	}

	@Override
	public Parts getEngine() {
		return new Parts("BenQ Engine");
	}

	@Override
	public Parts getBody() {
		return new Parts("BenQ Body");
	}

}
