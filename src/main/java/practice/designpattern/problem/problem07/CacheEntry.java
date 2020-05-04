package practice.designpattern.problem.problem07;

public class CacheEntry {
	private CacheEntry prev,next;
	private String key,value;
	
	public CacheEntry() {
	}
	public CacheEntry(String key,String value) {
		this.key = key;
		this.value = value;
	}
	public CacheEntry getPrev() {
		return prev;
	}
	public void setPrev(CacheEntry prev) {
		this.prev = prev;
	}
	public CacheEntry getNext() {
		return next;
	}
	public void setNext(CacheEntry next) {
		this.next = next;
	}
	public String getKey() {
		return key;
	}
	public void setKey(String key) {
		this.key = key;
	}
	public String getValue() {
		return value;
	}
	public void setValue(String value) {
		this.value = value;
	}

}
