package practice.designpattern.pattern.creational.factory;

public class FileLogger implements AppLogger{

	@Override
	public void log(String mssg) {
		System.out.println("[Logging in file] "+mssg);
		
	}

}
