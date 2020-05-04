package practice.designpattern.pattern.behavioral.command;

public class StopCommand implements Command{

	private AirConditioner airConditioner;
	public  StopCommand(AirConditioner airConditioner) {
		this.airConditioner = airConditioner;
	}
	@Override
	public void execute() {
		airConditioner.stop();		
	}

}
