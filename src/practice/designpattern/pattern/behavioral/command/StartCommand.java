package practice.designpattern.pattern.behavioral.command;

public class StartCommand implements Command{

	private AirConditioner airConditioner;
	public  StartCommand(AirConditioner airConditioner) {
		this.airConditioner = airConditioner;
	}
	@Override
	public void execute() {
		airConditioner.start();		
	}

}
