package practice.interview.hotstart1;

import java.math.BigDecimal;
import java.util.regex.Pattern;


public class Test {

	public static void main(String[] args) {
		BigDecimal number1 = new BigDecimal(0);
		BigDecimal number2 = new BigDecimal(10);
		//System.out.println(number3);
		try{
			BigDecimal number3 = number1.divide(number2);	
			String[] split = number3.stripTrailingZeros().toString().split(Pattern.quote("."));
			if(split.length<2){
				System.out.println("0");
			}
			else{
				System.out.println(split[1].length());
			}
			//System.out.println(number3.toEngineeringString());
		}catch(Exception e){
			System.out.println("inf");
		}
	}
}
