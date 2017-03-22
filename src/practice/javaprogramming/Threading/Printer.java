package practice.javaprogramming.Threading;

public class Printer implements Runnable{

	@Override
	public void run() {
		int i = 1;
		while(i ==1){
			System.out.println(System.nanoTime());
		}
	}
	
}
