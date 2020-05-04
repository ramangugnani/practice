package practice.javaprogramming.practice;

class MyThread extends Thread{
	public MyThread() {
	System.out.println("my");
	}
	
	public void run(){
		System.out.println("bar");
	}
	public void run(String s){
		System.out.println("baz");
	}
}
public class ABC {
	public static void main(String[] args) {
		Thread t = new MyThread(){
			public void run(){
				System.out.println("foo");
			}
		};
		t.start();
	}
}
