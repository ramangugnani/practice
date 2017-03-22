package practice.javaprogramming;

import java.util.ArrayList;
import java.util.List;

public class GC {

	public static void main(String [] args){
		int i = 0;
		 
		List<String> str = new ArrayList(1);
		while(i == 0){
			List<String> str1 = new ArrayList<String>(100);
			for(int j = 0 ; j < 100 ; j++){
				str1.add(new  String("hello"));
			}
			str.addAll(str1);
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
