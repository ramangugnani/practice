package practice.javaprogramming.Threading.SerializingThread;

public class Main {
	public static void main(String[] args) {
		Lock lock = new Lock();
		lock.variable = 1;
		PrinterClass p1  = new PrinterClass("Thread1",lock,1);
		PrinterClass p2  = new PrinterClass("Thread2",lock,2);
		PrinterClass p3  = new PrinterClass("Thread3",lock,3);
		Thread t1 = new Thread(p1,"Thread1");
		Thread t2 = new Thread(p2,"Thread2");
		Thread t3 = new Thread(p3,"Thread3");
		t1.start();
		t2.start();
		t3.start();
	}
}
