package practice.interview.ixigo2;

public class PriortiyQueueNode implements Comparable<PriortiyQueueNode>{

	Integer priorty;

	String sendNotification;

	public PriortiyQueueNode(Integer priorty, String sendNotification) {
		super();
		this.priorty = priorty;
		this.sendNotification = sendNotification;
	}

	@Override
	public int compareTo(PriortiyQueueNode o) {
		return o.priorty.compareTo(this.priorty);

	}

	@Override
	public String toString() {
		return "PriortiyQueueNode [priorty=" + priorty + ", sendNotification=" + sendNotification + "]";
	}

}
