package practice.designpattern.problem.problem15;

import java.util.Date;
import java.util.Vector;

public class Elevator extends Thread{
	
	private String name;
	
	private int maxFloor;
	
	private int maxCapacity;
	
	private boolean isRunning = true;
	
	private boolean isGoingUp;
	
	private int timeBetweenFloor;
	
	private int timeAtFloor;
	
	private int currentFloor;
	
	private Vector[] Person;
	
	private int numOfPassengers;
	
	private Building building;
	
	
	public Elevator(int maxFloor, int maxCapacity, int timeBetweenFloor, int timeAtFloor, String elevatorName,Building building) {
		super(elevatorName);
		this.maxFloor = maxFloor;
		this.maxCapacity = maxCapacity;
		this.timeBetweenFloor = timeBetweenFloor;
		this.timeAtFloor = timeAtFloor;
		this.currentFloor = 0;
		this.name = elevatorName;
		this.numOfPassengers = 0;
		this.building = building;
	}
	
	public void run() {
		System.out.println(toString() + "Starting...!!");
		while(isRunning){
			System.out.println(toString() + " now on Floor " + currentFloor + " at time " + new Date());
			
			if(currentFloor == maxFloor -1){
				isGoingUp = false;
			}else if(currentFloor == 0){
				isGoingUp = true;
			}
			
			notifyPassengers();
			building.tellAt();
			
			try {
				sleep(timeAtFloor);
			} catch (InterruptedException e1) {
				e1.printStackTrace();
			}
			
			System.out.println(toString() + " now leaving Floor " + currentFloor + " at time " + new Date());
			
			if(isGoingUp){
				currentFloor++;
			}else{
				currentFloor--;
			}
			
			try {
				sleep(timeBetweenFloor);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
	
	public void stopElevator(){
		isRunning = false;
	}
	
	public synchronized int getCurrentFloor(){
		return currentFloor;
	}
	
	public synchronized int takeElevator(int currFloor,int destFloor,Person person){
		if(currentFloor == currFloor && numOfPassengers < maxCapacity){
			numOfPassengers++;
			System.out.println( person + " getting on " + toString() + " on floor "+currFloor + " at time "+new Date());
			while(currFloor != destFloor){
				try {
					wait();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
			numOfPassengers--;
			return destFloor;
		}else{
			return currFloor;
		}
	}
	
	private synchronized void notifyPassengers(){
		notifyAll();
	}
	
	public String toString(){
		return this.name;
	}
	
	public boolean isGoingUp(){
		return this.isRunning;
	}
}
