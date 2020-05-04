package practice.designpattern.pattern.structural.bridge;

public abstract class TVRemoteControl {
	private TV implementor;
	public TVRemoteControl(TV tv) {
		implementor = tv;
	}
	public void powerOn(){
		implementor.powerOn();
	}
	public void powerOff(){
		implementor.powerOff();
	}
	public void setChannel(int channel){
		implementor.changeChannel(channel);
	}
}
