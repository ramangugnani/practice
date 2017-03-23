package practice.algorithms.greedy;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MaximumRailwayPlatform {
	public static void main(String[] args) {
		List<Schedules> jobs = new ArrayList<>();
		jobs.add(new Schedules(900, 930));
		jobs.add(new Schedules(915, 1300));
		jobs.add(new Schedules(1030, 1100));
		jobs.add(new Schedules(1045, 1145));
//		jobs.add(new Schedules(5, 7));
//		jobs.add(new Schedules(8, 9));
		Integer output = maximumRailwayPlatform(jobs);
		System.out.println(output);
	}

	private static Integer maximumRailwayPlatform(List<Schedules> trainSchedules) {
		List<ModifiedTrainSchedule> modifiedTrainSchedules = new ArrayList<>();
		for(Schedules schedule : trainSchedules){
			modifiedTrainSchedules.add(new ModifiedTrainSchedule(schedule.getStartTime(), 1));
			modifiedTrainSchedules.add(new ModifiedTrainSchedule(schedule.getEndTime(), -1));
		}
		Collections.sort(modifiedTrainSchedules);
		int maxPlatform = 0;
		int previousCumulativeValue = 0;
		for(ModifiedTrainSchedule modifiedTrainSchedule : modifiedTrainSchedules){
			Integer nextCumulativeValue;
			nextCumulativeValue = previousCumulativeValue+modifiedTrainSchedule.getTimeType();
			maxPlatform = Math.max(nextCumulativeValue, maxPlatform);
			previousCumulativeValue = nextCumulativeValue;
		}
		return maxPlatform;
	}
}
