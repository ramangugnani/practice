package practice.designpattern.pattern.behavioral.command;

import java.util.ArrayList;
import java.util.List;

public class Switch {
	private List< Command> commandHistory = new ArrayList<>();
	
	public Switch(){
		
	}
	public void storeAndExecute(Command cmd){
		this.commandHistory.add(cmd);
		cmd.execute();
	}
}
