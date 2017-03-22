package practice.designpattern.pattern.creational.abstractfactory;

public class GM extends Car{

	@Override
	public Parts getWheels() {
		return new Parts("GM Wheels");
	}

	@Override
	public Parts getMirrors() {
		return new Parts("GM Mirror");
	}

	@Override
	public Parts getEngine() {
		return new Parts("GM Engine");
	}

	@Override
	public Parts getBody() {
		return new Parts("GM Body");
	}

}