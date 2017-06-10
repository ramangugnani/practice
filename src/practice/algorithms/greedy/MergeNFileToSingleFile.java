package practice.algorithms.greedy;

import java.util.PriorityQueue;

public class MergeNFileToSingleFile {
	public static void main(String[] args) {
		int[] pageSize = new int[]{10,5,100,50,20,15};
		int output = mergeNFileToSingleFile(pageSize);
		System.out.println(output);
	}

	private static int mergeNFileToSingleFile(int[] pageSize) {
		Integer cost = 0;
		PriorityQueue<Integer> pQueue = new PriorityQueue<>();
		for(int i = 0 ; i < pageSize.length ; ++i){
			pQueue.add(pageSize[i]);
		}
		
		while(!pQueue.isEmpty()){
			Integer firstElemenet = pQueue.poll();
			
			if(pQueue.isEmpty())
				return cost;
			
			Integer secondElement = pQueue.poll();
			
			cost = firstElemenet+secondElement;
			pQueue.add(firstElemenet+secondElement);

		}
		return cost;
	}
}
