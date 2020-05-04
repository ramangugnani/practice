package practice.javaprogramming.Threading;

public class ThreadMain {
	public static void main(String[] args) {
		System.out.println("jkl");
		Task task = new Task();	
		//Task task1 = new Task();	
		Thread t = new Thread(task);
		t.setName("raman");
		t.start();
		Thread t1 = new Thread(task);
		t1.start();
		t1.setName("karan");
		t1.notify();
		
		System.out.println("abc");
		try {
			Thread.sleep(60000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("def");
	}
}
