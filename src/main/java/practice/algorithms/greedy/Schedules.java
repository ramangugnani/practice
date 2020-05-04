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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + endTime;
		result = prime * result + startTime;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Schedules other = (Schedules) obj;
		if (endTime != other.endTime)
			return false;
		if (startTime != other.startTime)
			return false;
		return true;
	}

}
