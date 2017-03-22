package practice.javaprogramming.Threading;

public class NanoTimeMain {
	public static void main(String[] args) {
		Printer p = new Printer();
		Thread t1 = new Thread(p);
		t1.start();
		Thread t2 = new Thread(p);
		t2.start();
		Thread t3 = new Thread(p);
		t3.start();
		Thread t4 = new Thread(p);
		t4.start();
		Thread t5 = new Thread(p);
		t5.start();
		Thread t6 = new Thread(p);
		t6.start();
		Thread t7 = new Thread(p);
		t7.start();
		Thread t8 = new Thread(p);
		t8.start();
		Thread t9 = new Thread(p);
		t9.start();
		Thread t10 = new Thread(p);
		t10.start();
	}
}

