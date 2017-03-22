package practice.designpattern.pattern.structural.bridge;

public class Apple implements TV{

	@Override
	public void powerOn() {
		System.out.println("Aplle TV ON");
	}

	@Override
	public void powerOff() {
		System.out.println("Aplle TV OFF");
	}

	@Override
	public void changeChannel(int channel) {
		System.out.println("Channel changed");
	}

}
