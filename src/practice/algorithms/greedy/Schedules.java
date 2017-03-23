package practice.algorithms.greedy;

public class Schedules implements Comparable<Schedules>{
	private int startTime;
	private int endTime;

	public Schedules(int startTime, int endTime) {
		super();
		this.startTime = startTime;
		this.endTime = endTime;
	}

	public int getStartTime() {
		return startTime;
	}

	public void setStartTime(int startTime) {
		this.startTime = startTime;
	}

	public int getEndTime() {
		return endTime;
	}

	public void setEndTime(int endTime) {
		this.endTime = endTime;
	}

	@Override
	public int compareTo(Schedules o) {
		if(o.endTime > this.endTime )
			return 1;
		else if (this.endTime < o.endTime)
			return -1;
		else{
			if(o.startTime > this.startTime)
				return 1;
			else
				return -1;
		}
	}

	@Override
	public String toString() {
		return "Schedules ["+"endTime=" + endTime + ", startTime=" + startTime +  "]";
	}

}
