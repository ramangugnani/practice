package practice.designpattern.problem.problem15;

import java.util.ArrayList;
import java.util.List;

public class Building {

	public final int MAX_FLOOR;
	public final int MAX_ELEVATOR;
	private List<Elevator> elevators = null;
	public Building(Integer maxFloor, Integer maxElevator, Integer elevatorTimeBetweenFloor,
			Integer elevatorTimeAtFloor) {
		this.MAX_ELEVATOR = maxElevator;
		this.MAX_FLOOR = maxFloor;
		elevators = new ArrayList<>();
		for(int i = 0 ;  i < maxElevator ; ++i){
			elevators.add( new Elevator(maxFloor,maxElevator,elevatorTimeBetweenFloor,elevatorTimeAtFloor,"Elevator"+i,this));
		}
	}

	public void startLift() {
		for(Elevator elevator : elevators){
			elevator.run();
		}
	}

	public void stopLift() {
		for(Elevator elevator : elevators){
			elevator.stopElevator();
		}
	}
	
	public synchronized void tellAt(){
		notifyAll();
	}

	public synchronized Elevator callElevator(int personFloor,boolean goingUp){
		while(true){
			for(Elevator elevator : elevators){
				if(elevator.getCurrentFloor() == personFloor && elevator.isGoingUp() ==  goingUp)
					return elevator;
			}
			try {
				wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
	
	public synchronized void waitForElevatorToCome(){
		try {
			wait();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
