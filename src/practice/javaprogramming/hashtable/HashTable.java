package practice.javaprogramming.hashtable;


public class HashTable<K,V>{

	static class Node<K,V>{
		K key;
		V value;
		Node next;
		Node(K key,V val){
			this.key = key;
			this.value = val;
			this.next = null;
		}
	}
	private int capacity;
	private Node[] arr;
	private final int defaultCapacity = 10;
	HashTable(){
		arr = new Node[defaultCapacity];
		capacity = defaultCapacity;
	}
	HashTable(int c){
		this.capacity = c;
		arr = new Node[c];
	}

	public void put (K key,V val){
		int hash = key.hashCode();
		int index = hash%capacity;
		if(arr[index]==null){
			arr[index] = new Node(key,val);
		}
		else{
			Node temp = arr[index];
			while(temp.next!=null && !temp.key.equals(key)){
				temp = temp.next;
			}
			if(temp.key.equals(key)){
				temp.value = val;
			}
			else{
				temp.next = new Node(key,val);
			}
		}
	}

	public V get(K key){
		int hash = key.hashCode();
		int index = hash%capacity;
		if(arr[index]==null){
			return null;
		}
		else{
			Node temp = arr[index];
			while(temp!=null && !temp.key.equals(key)){
				temp = temp.next;
			}
			if(temp == null){
				return null;
			}
			else{
				return (V)temp.value;
			}
		}
	}

	public static void main(String[] args){
		HashTable<String, String> table = new HashTable<>();
		table.put("junk", "value");
		System.out.println(table.get("junk"));
		System.out.println(table.get("checkNull"));
	} 
}