package practice.designpattern.pattern.structural.bridge;

public class ConcreteTVRemoteControl extends TVRemoteControl{
	private int currentChannel;
	public ConcreteTVRemoteControl(TV tv) {
		super(tv);
	}
	public void nextChannel(){
		currentChannel++;
		setChannel(currentChannel);
	}
	public void prevChannel(){
		currentChannel--;
		setChannel(currentChannel);
	}
}
