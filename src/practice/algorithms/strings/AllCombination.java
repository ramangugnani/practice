package practice.algorithms.strings;

import java.util.Map;
import java.util.TreeMap;

public class AllCombination {
	public static void main(String[] args) {
		char input[] = {'a','b','c','d','e'};
		combination(input);
	}

	private static void combination(char[] input) {
		Map<Character,Integer> countMap = new TreeMap<>();
		for(char ch  : input){
			if(null == countMap.get(ch)){
				countMap.put(ch, 1);
			}else{
				countMap.put(ch,countMap.get(ch)+1 );
			}
		}

		char str[] = new char[countMap.size()];
		int count[] = new int[countMap.size()];
		int index = 0;
		for(Map.Entry<Character, Integer> entry : countMap.entrySet()){
			str[index] = entry.getKey();
			count[index] = entry.getValue();
			index++;
		}

		char[] output = new char[input.length];
		allCombination(str,count,0,output,0);
	}

	private static void allCombination(char input[],int count[],int pos,char output[],int len) {
		print(output,len);
		for(int i = pos; i < input.length; i++){
			if(count[i] == 0){
				continue;
			}
			output[len] = input[i];
			count[i]--;
			allCombination(input, count, i, output, len+1);
			count[i]++;
		}
	}

	private static void print(char[] output, int len) {
		for(int i = 0 ; i < len; i++){
			System.out.print(output[i]+" ");
		}
		System.out.println();
	}
}
