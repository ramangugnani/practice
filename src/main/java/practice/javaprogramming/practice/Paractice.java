package practice.javaprogramming.practice;

import java.util.Calendar;

public class Paractice {
	static final int x = 12;
	public static void go(final int x){
		System.out.println(x);
	}
	
	public static void main(String[] args) {
		Paractice p = new Paractice();
		p.go(20);
		String str = String.format("%,15.1f", 66666642.000);
		System.out.println(str);
		Calendar.getInstance();
	}
}
