package practice.algorithms.greedy;

public class ModifiedTrainSchedule implements Comparable<ModifiedTrainSchedule>{

	private final int time;
	private final int timeType; // 1 for arrival and -1 for departure
	public ModifiedTrainSchedule(int time, int timeType) {
		super();
		this.time = time;
		this.timeType = timeType;
	}
	public int getTime() {
		return time;
	}
	public int getTimeType() {
		return timeType;
	}
	@Override
	public int compareTo(ModifiedTrainSchedule o) {
		if(o.time < this.time){
			return 1;
		}else if(o.time > this.time){
			return -1;
		}else{
			if(o.timeType < this.timeType)
				return 1;
			else
				return -1;
		}
	}
	@Override
	public String toString() {
		return "ModifiedTrainSchedule [time=" + time + ", timeType=" + timeType + "]";
	}	
	
}
