package practice.algorithms.greedy;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class MergeNFileToSingleFile {
	public static void main(String[] args) {
		int[] pageSize = new int[]{10,5,100,50,20,15};
		int output = mergeNFileToSingleFile(pageSize);
		System.out.println(output);
	}

	private static int mergeNFileToSingleFile(int[] pageSize) {
		List<Integer> sortedPageSize = new ArrayList<>();
		Integer cost = 0;
		for(int i = 0 ; i < pageSize.length ; ++i){
			sortedPageSize.add(pageSize[i]);
		}
		Collections.sort(sortedPageSize);
		Iterator<Integer> itr = sortedPageSize.iterator();
		while(itr.hasNext()){
			Integer firstElemenet = itr.next();
			itr.remove();
			if(itr.hasNext()){
				Integer secondElement = itr.next();
				itr.remove();
				cost = firstElemenet + secondElement;
				sortedPageSize.add(firstElemenet + secondElement);
				Collections.sort(sortedPageSize);
				itr = sortedPageSize.iterator();
			}else{
				break;
			}
		}
		return cost;
	}
}
