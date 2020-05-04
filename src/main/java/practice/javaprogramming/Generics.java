package practice.javaprogramming;

import java.util.List;

/**
 * @author raman.gugnani
 * @version 1.1
 */
public class Generics {

	/**
	 * @param input : list which is input by the user whose kth index to be returned
	 * @param index : index which needs to be returned
	 * @return element which is a kth index
	 */
	public static <T> T sortedElemet(List<T> input,Integer index) throws Exception{
		if(null == input || null == index ){
			return null;
		}
		if(index > input.size()){
			throw new Exception("Index out of bound array", null);
		}
		T number = null;
		number = input.get(0);
		return number;
	}

}
