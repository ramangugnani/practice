package practice.interview.ixigo2;

import java.util.PriorityQueue;

public class PriortiyQueueMain {
	public static void main(String[] args) {
		PriorityQueue<PriortiyQueueNode> queue = new PriorityQueue<>(10);
		queue.add(new PriortiyQueueNode(1,"a"));
		queue.add(new PriortiyQueueNode(3,"c"));
		queue.add(new PriortiyQueueNode(2,"b"));
		queue.add(new PriortiyQueueNode(10,"f"));
		queue.add(new PriortiyQueueNode(8,"d"));
		queue.add(new PriortiyQueueNode(3,"e"));
	}
}
