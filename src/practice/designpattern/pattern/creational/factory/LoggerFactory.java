package practice.designpattern.pattern.creational.factory;

public class LoggerFactory {
	public AppLogger getLogger(Integer type){
		AppLogger appLogger = null;
		if (null == type )
			return null;

		if(type == 0){
			appLogger = new FileLogger();
		}else if(type == 1){
			appLogger = new DatabaseLogger();
		}
		return appLogger;
	}
}
