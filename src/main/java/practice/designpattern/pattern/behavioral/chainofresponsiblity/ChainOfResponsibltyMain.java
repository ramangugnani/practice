package practice.designpattern.pattern.behavioral.chainofresponsiblity;

public class ChainOfResponsibltyMain {
	public static void main(String [] args){
		Logger logger,logger1,logger2;
		logger = new StdoutLogger(Logger.DEBUG);
		logger1 =  logger.setNext(new EmailLogger(Logger.NOTICE));
		logger2 = logger1.setNext(new StderrLogger(Logger.ERROR));
		
		logger.message("Entering function y.", Logger.DEBUG);
		System.out.println("====================================");
		logger.message("Step 1 completed.", Logger.NOTICE);
		System.out.println("====================================");
		logger.message("An error has occured.", Logger.ERROR);
	}
}
