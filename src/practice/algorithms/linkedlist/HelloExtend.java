package practice.algorithms.linkedlist;

public class HelloExtend extends Hello{
	private int age = 10;
	
	public HelloExtend(int age) {
		super(age);
	}
	public int getAge() {
		return age;
	}
	
	public void setAge(int age){
		this.age = age;
	}
	
	public static void main(String[] args) {
		
		HelloExtend abc = new HelloExtend(20);
		Hello a = abc;
		checkAge(a);
		abc.setAge(202131);
		checkAge(a);
		
//		checkAge(abc);
//		System.out.println(abc.getAge());
//		
//		
//		Hello abc1 = abc;
//		System.out.println(abc1.getAge());
	}
	
	public static void checkAge(Hello abc){
		System.out.println(abc.getAge());
	}
}
