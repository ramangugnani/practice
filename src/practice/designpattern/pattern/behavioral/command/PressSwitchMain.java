package practice.designpattern.pattern.behavioral.command;

public class PressSwitchMain {

	public static void main(String[] args) {
		AirConditioner airConditioner = new AirConditioner();
		Command switchOn = new StartCommand(airConditioner);
		Command switchOff = new StopCommand(airConditioner);
		
		Switch sw = new Switch();
		sw.storeAndExecute(switchOn);
		sw.storeAndExecute(switchOff);
	}

}
