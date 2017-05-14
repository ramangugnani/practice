package practice.javaprogramming.java8;

import java.util.Arrays;

public class Test {
	public static void main(String[] args) {
		String separator = ",";
		Arrays.asList( "a", "b", "d" ).forEach(
		( String e ) -> System.out.print( e + separator ) );
		
		Arrays.asList( "a", "b", "d" ).sort((c1,c2) -> c1.compareTo(c2));
	}
}
