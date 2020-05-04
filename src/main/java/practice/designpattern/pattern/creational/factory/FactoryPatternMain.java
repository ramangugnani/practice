package practice.designpattern.pattern.creational.factory;

public class FactoryPatternMain {
	public static void main(String args[]){
		LoggerFactory loggerFactory = new LoggerFactory();
		AppLogger logging = loggerFactory.getLogger(0);
		logging.log("Hello World");
		logging = loggerFactory.getLogger(1);
		logging.log("Hello World");
	}
}
