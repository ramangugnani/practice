package practice.algorithms.linkedlist;



public class Test {
	static Integer i;
	int j;

	static{
		System.out.println("static");
		print();
	}
	public static void main(String [] args){
		int a = 2;
		int b= 2;
		int c = 3;
		String d = "abc";
		String e = "abc";
		Test t1 = new Test();
		Test t2 = new Test();
	}
	{
		j = 20;
		System.out.println("Intialize");
	}
	private static void print(){
		System.out.println("hello");
	}
}

