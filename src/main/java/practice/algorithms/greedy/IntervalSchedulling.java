package practice.algorithms.greedy;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class IntervalSchedulling {
	public static void main(String[] args) {
		List<Schedules> jobs = new ArrayList<>();
		jobs.add(new Schedules(1, 2));
		jobs.add(new Schedules(3, 4));
		jobs.add(new Schedules(5, 9));
		jobs.add(new Schedules(0, 6));
		jobs.add(new Schedules(5, 7));
		jobs.add(new Schedules(8, 9));
		Collections.sort(jobs);
		System.out.println(jobs);
		Integer output = maximumJobsByASinglePerson(jobs);
		System.out.println(output);
	}

	private static Integer maximumJobsByASinglePerson(List<Schedules> jobs) {
		int maximumJobs = 0;
		Iterator<Schedules> itr = jobs.iterator();
		Schedules lastSchedule = null;
		while(itr.hasNext()){
			if(maximumJobs == 0){
				lastSchedule = itr.next();
				System.out.println(lastSchedule);
				itr.remove();
				maximumJobs++;
			}else{
				Schedules schedule = itr.next();
				itr.remove();
				if(schedule.getEndTime() <= lastSchedule.getStartTime()){
					maximumJobs++;
					lastSchedule = schedule;
					System.out.println(lastSchedule);
				}
			}
			
		}
		return maximumJobs;
	}
}
