package practice.designpattern.pattern.creational.factory;

public class DatabaseLogger implements AppLogger{

	@Override
	public void log(String mssg) {
		System.out.println("[Logging in database] "+mssg);		
	}

}
