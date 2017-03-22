package practice.javaprogramming.Lfu;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LeastFrquentlyUsed {

	private final int maxSize;

	private Map<Integer, LfuObject> map = null;

	private LfuObject[]  minHeap = null;

	private int size ;

	LeastFrquentlyUsed(int maxSize){
		this.maxSize = maxSize;
		map  = new HashMap<>(maxSize);
		minHeap = new LfuObject[maxSize];
		size = 0;
	}

	public synchronized Integer get(Integer data){
		LfuObject object = map.get(data);
		if(null != object){
			object.increaseFrequency();
			heapifyUp(object.getIndex());
			return object.getData();
		}else{
			return null;			
		}
	}

	public synchronized boolean contains (Integer data){
		LfuObject object = map.get(data);
		if(null != object){
			object.increaseFrequency();
			heapifyUp(object.getIndex());
			return true;
		}else{
			return false;			
		}
	}

	public synchronized void put(Integer data){
		LfuObject object = map.get(data);
		if(null != object){
			object.increaseFrequency();
			heapifyUp(object.getIndex());
		}else{
			if(size == maxSize){
				deleteTop();
			}
			object = new LfuObject(data, 1,size);
			map.put(data, object);
			minHeap[size] = object;
			size++;
			heapifyUp(size-1);
		}
	}

	private void heapifyUp(int index) {
		int parent = getParent(index);
		if( -1 != parent){
			int leftChild = getLeftChild(parent);
			int rightChild = getRightChild(parent);
			if(leftChild < size && minHeap[leftChild].getFrequency() > minHeap[parent].getFrequency()){
				//swap
				LfuObject temp = minHeap[leftChild];
				minHeap[leftChild] = minHeap[parent];
				minHeap[leftChild].setIndex(leftChild);
				minHeap[parent]= temp;
				minHeap[parent].setIndex(parent);
			}
			if(rightChild < size && minHeap[rightChild].getFrequency() > minHeap[parent].getFrequency()){
				//swap
				LfuObject temp = minHeap[rightChild];
				minHeap[rightChild] = minHeap[parent];
				minHeap[rightChild].setIndex(rightChild);
				minHeap[parent] = temp;
				minHeap[parent].setIndex(parent);
			}
			heapifyUp(parent);
		}
	}

	private void deleteTop() {
		LfuObject toBeRemoved = minHeap[0];
		if(size > 1){
			minHeap[0] = minHeap[size-1];
			minHeap[0].setIndex(0);
			minHeap[size-1] = null;
		}else if (size ==1){
			minHeap[0] = null;	
		}
		map.remove(toBeRemoved.getData());
		size--;
	}

	private int getLeftChild(int parent){
		if(parent < 0 || parent > size-1)
			return -1;
		return 2*parent + 1;
	}

	private int getRightChild(int parent){
		if(parent < 0 || parent > size-1)
			return -1;
		return 2*parent + 2;
	}

	private int getParent(int child){
		if(child <= 0 || child > size-1)
			return -1;
		return (child - 1)/2;
	}

	@Override
	public String toString() {
		return "LeastFrquentlyUsed [maxSize=" + maxSize + ", map=" + map + ", minHeap=" + minHeap.toString() + "]";
	}
}
