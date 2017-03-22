package practice.designpattern.problem.problem07;

import java.util.HashMap;
import java.util.Map;

public class LRUAdvanced {
	private Map<String,CacheEntry> map;
	private CacheEntry head , tail;
	private int maxSize ;

	public LRUAdvanced(int maxSize) {
		this.maxSize = maxSize;
		if(maxSize < 0){
			throw new IllegalArgumentException("Cache size has to be atleast 1");
		}
		map = new HashMap<>();
		head = new CacheEntry();
		tail = new CacheEntry();
		head.setNext(tail);
		tail.setPrev(head);
	}

	public void add(String key,String value){
		CacheEntry entry = map.get(key);
		/* If not present add it */
		if(entry == null){
			// key is not stored
			entry = new CacheEntry(key,value);
			if(map.size() == maxSize){
				//remove last access element
				CacheEntry deleteEntry = tail.getPrev();
				//remove from map
				map.remove(deleteEntry.getKey());
				remove(deleteEntry);
			}
			//add entry to front
			addFront(entry);
			//add entry to the map
			map.put(key, entry);
		}else{
			// update the value
			entry.setValue(value);
			//access the entry
			accessed(entry);
		}
	}

	public String search(String key){
		CacheEntry entry = map.get(key);
		if(null == entry){
			return null;
		}
		accessed(entry);
		return entry.getValue();
	}
	
	public void print(){
		CacheEntry entry = head.getNext();
		while(entry != tail){
			System.out.println("{"+entry.getKey()+","+entry.getValue()+"}");
			entry = entry.getNext();
		}
	}

	private void accessed(CacheEntry entry) {
		//move the element to head if it is not at head position
		if(entry.getPrev()  != head){
			remove(entry);
			addFront(entry);
		}

	}

	private void addFront(CacheEntry entry) {
		CacheEntry nextPoniter = head.getNext();
		head.setNext(entry);
		entry.setPrev(head);
		entry.setNext(nextPoniter);
		// TODO Auto-generated method stub
		nextPoniter.setPrev(entry);
	}

	private void remove(CacheEntry deleteEntry) {
		// TODO Auto-generated method stub

	}
}
