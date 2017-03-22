package practice.designpattern.problem.problem15;

public class Simulator {

	private static Integer MAX_FLOOR = 2;
	private static Integer MAX_ELEVATOR = 2;
	private static Integer ELEVATOR_TIME_BETWEEN_FLOOR = 5000; // in ms
	private static Integer ELEVATOR_TIME_AT_FLOOR = 5000; // in ms
	private static Integer PERSON_TIME_FOR_SHOPPING = 5000; // in ms

	public static void main(String[] args) {
		Building building = new Building(MAX_FLOOR,MAX_ELEVATOR,ELEVATOR_TIME_BETWEEN_FLOOR,ELEVATOR_TIME_AT_FLOOR);

		int[] p1Itenary = {1,2,0};
		int[] p2Itenary = {2,1,0};

		Person Steve = new Person("Steve",p1Itenary, PERSON_TIME_FOR_SHOPPING, 0 ,building);
		Person Bill = new Person("Bill",p2Itenary, PERSON_TIME_FOR_SHOPPING, 0 ,building);
		Person Jeff = new Person("Jeff",p1Itenary, PERSON_TIME_FOR_SHOPPING, 0 ,building);
		Person Raman = new Person("Raman",p2Itenary, PERSON_TIME_FOR_SHOPPING, 0 ,building);

		building.startLift();
		Steve.start();
		Bill.start();
		Jeff.start();
		Raman.start();
		long start = System.currentTimeMillis();
		try {
			Steve.join();
			Jeff.join();
			Bill.join();
			Raman.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		building.stopLift();
		long elapsedTime = System.currentTimeMillis() - start;
		System.out.println("Total simulation time: "+ elapsedTime + " ms.");
	}
}
