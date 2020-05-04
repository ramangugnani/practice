package practice.designpattern.problem.problem07;

import java.util.LinkedHashMap;
import java.util.Map;

public class LRUSimple<K,V> extends LinkedHashMap<K, V>{

	private static final long serialVersionUID = 8718229915261296409L;

	private final int  capacity ;
	private long accessCount = 0;
	private long hitCount = 0;


	public LRUSimple(int capacity){
		super(capacity+1, 1.1f, true);
		this.capacity = capacity;
	}

	@Override
	public V get (Object key){
		accessCount++;
		if(super.containsKey(key)){
			hitCount++;
		}
		V value = super.get(key);
		return value;
	}

	@Override
	public boolean containsKey(Object key) {
		accessCount++;
		if(super.containsKey(key)){
			hitCount++;
			return true;
		}else{
			return false;
		}
	}

	@Override
	protected boolean removeEldestEntry(Map.Entry<K, V> eldest) {
		return size() > capacity; 
	}

	public long getAccessCount(){
		return accessCount;
	}

	public long getHitCount(){
		return hitCount;
	}

	public static void main(String[] args) {
		LRUSimple<String,String> lruSimpleCache = new LRUSimple<>(2);
		lruSimpleCache.put("a", "a");
		lruSimpleCache.put("b", "b");
		System.out.println(lruSimpleCache.get("a") + "\t getAccessCount "+ lruSimpleCache.getAccessCount() + " getHitCount " + lruSimpleCache.getHitCount());
		lruSimpleCache.put("c","c");
		System.out.println(lruSimpleCache.get("b") + "\t getAccessCount "+ lruSimpleCache.getAccessCount() + " getHitCount " + lruSimpleCache.getHitCount());
		System.out.println(lruSimpleCache.get("c") + "\t getAccessCount "+ lruSimpleCache.getAccessCount() + " getHitCount " + lruSimpleCache.getHitCount());
		lruSimpleCache.put("d","d");
		System.out.println("Equal Hits");
		System.out.println(lruSimpleCache.get("a") + "\t getAccessCount "+ lruSimpleCache.getAccessCount() + " getHitCount " + lruSimpleCache.getHitCount());
		System.out.println(lruSimpleCache.get("c") + "\t getAccessCount "+ lruSimpleCache.getAccessCount() + " getHitCount " + lruSimpleCache.getHitCount());
		System.out.println(lruSimpleCache.get("d") + "\t getAccessCount "+ lruSimpleCache.getAccessCount() + " getHitCount " + lruSimpleCache.getHitCount());

	}
}
