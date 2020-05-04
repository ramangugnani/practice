package practice.designpattern.pattern.structural.bridge;

public class TVRemoteControlMain {
	public static void main(String [] args){
		ConcreteTVRemoteControl remote = new ConcreteTVRemoteControl(new Apple());
		remote.powerOn();
		remote.setChannel(1);
		remote.nextChannel();
		remote.powerOff();
	}
}
