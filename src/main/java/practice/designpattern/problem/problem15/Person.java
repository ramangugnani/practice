package practice.designpattern.problem.problem15;

public class Person extends Thread{
	private static final int WAITING = 0;
	private static final int SHOPPING = 1;
	private static final int ON_ELEVATOR = 2;
	private static final int DONE = 3;
	private int status = WAITING;
	private final int[] itenary;
	private final String name;
	private final int busyTime;
	private final Building building;
	private int itemNumber;
	private int currentFloor;

	public Person(String name,int[] itenary,int busyTime,int startingFloor,Building building){
		super("Person "+name);
		this.name = name;
		this.itenary = itenary;
		this.busyTime = busyTime;
		this.itemNumber = 0;
		this.currentFloor = startingFloor;
		this.building = building;
	}

	public void run(){
		while(itemNumber < itenary.length){
			int dest = itenary[itemNumber];
			if(dest == currentFloor && status ==  ON_ELEVATOR){
				System.out.println(name+ " exiting elevator on floor "+ dest + " at time "+System.currentTimeMillis());
				shopOnFloor();
				System.out.println(name+ " done shopping on floor "+ dest + " at time "+System.currentTimeMillis());
				itemNumber++;
			}else{
				System.out.println(name+ " waiting on "+ currentFloor +" for floor"+ dest +" at time "+System.currentTimeMillis());
				Elevator elevator = building.callElevator(currentFloor, dest > currentFloor);
				System.out.println(name + " tries to get on "+elevator + " to floor "+dest + "at time "+System.currentTimeMillis());
				status = ON_ELEVATOR;
				currentFloor = elevator.takeElevator(dest, currentFloor, this);

				if(currentFloor != dest){
					status = WAITING;
					System.out.println("oops!"+ name + " didn't make it onto elevator to "+ dest);
					building.waitForElevatorToCome();
				}
			}
		}
		System.out.println(name + " is done shopping.");
	}

	private void shopOnFloor() {
		System.out.println(name + " arrived at floor "+ currentFloor + " at time "+ System.currentTimeMillis());
		status = SHOPPING;
		try {
			Thread.sleep(busyTime);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		status = WAITING;
	}
	
	public String toString(){
		return name;
	}
}
