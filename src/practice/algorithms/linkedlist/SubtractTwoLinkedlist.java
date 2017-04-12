package practice.algorithms.linkedlist;

import java.util.Iterator;
import java.util.LinkedList;

public class SubtractTwoLinkedlist {
	public static void main(String[] args) {
		LinkedList<Integer> list1 = new LinkedList<Integer>();
		list1.addFirst(0);list1.addFirst(0);list1.addFirst(1);   
		LinkedList<Integer> list2 = new LinkedList<Integer>();
		list2.addFirst(1);//list2.addFirst(6);
		LinkedList<Integer> list3 = subtractTwoLinkedlist(list1,list2);
		System.out.println("INPUT1  : "+list1.toString());
		System.out.println("INPUT2  : "+list2.toString());
		System.out.println("OutPut  : "+list3.toString());
	}

	private static LinkedList<Integer> subtractTwoLinkedlist(LinkedList<Integer> list1, LinkedList<Integer> list2) {
		LinkedList<Integer> list3 = new LinkedList<Integer>();
		//append zeros in shorter list
		appendZerosInShorterList(list1, list2);
		Integer shortest = calculateLongestList(list1, list2);
		Iterator<Integer> itr1 = list1.iterator();
		Iterator<Integer> itr2 = list2.iterator();
		if(shortest == 1)
			subtractList(itr1,itr2,list3);
		else
			subtractList(itr2,itr1,list3);
		return list3;
	}

	private static Boolean subtractList(Iterator<Integer> itr1, Iterator<Integer> itr2, LinkedList<Integer> list3) {
		Boolean isBorrowCalculated = false;
		if(itr1.hasNext()){
			Integer int1 = itr1.next();
			Integer int2 = itr2.next();
			Boolean isBorrow = subtractList(itr1,itr2,list3);
			if(isBorrow){
				int1--;
			}
			if(int1 < int2){
				isBorrowCalculated = true;
				int1 = int1 + 10;
			}
			list3.addFirst(int1-int2);
		}
		return isBorrowCalculated;
	}

	private static Integer calculateLongestList(LinkedList<Integer> list1, LinkedList<Integer> list2) {
		Iterator<Integer> itr1 = list1.iterator();
		Iterator<Integer> itr2 = list2.iterator();
		while(itr1.hasNext()){
			Integer int1 = itr1.next();
			Integer int2 = itr2.next();
			if(int1 > int2)
				return 1;
			else if(int1 < int2)
				return -1;
		}
		return 1;
	}

	/**
	 * @param list1
	 * @param list2
	 */
	private static void appendZerosInShorterList(LinkedList<Integer> list1, LinkedList<Integer> list2) {
		Integer list1Size = list1.size();
		Integer list2Size = list2.size();
		if(list1Size > list2Size){
			//append in list two
			for(int i = 0 ; i < list1Size - list2Size ; i++){
				list2.addFirst(0);
			}
		}else if(list1Size < list2Size){
			//append in list one
			for(int i = 0 ; i < list2Size - list1Size ; i++){
				list1.addFirst(0);
			}
		}
	}
}
