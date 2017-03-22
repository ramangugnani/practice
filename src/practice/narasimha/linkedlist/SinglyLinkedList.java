package practice.narasimha.linkedlist;


public class SinglyLinkedList {
	private int length = 0;
	private Node head ;

	public SinglyLinkedList(){
		length = 0;
	}

	public synchronized Node getHead(){
		return head;	
	}

	public synchronized void insertAtBegin(Node node){
		if(null == node)
			return;

		if(null == head){
			head = node;
			length++;
		}
	}

	public synchronized void insertAtEnd(Node node){
		if(null == node)
			return;

		Node temp = node;
		while(null != temp.getNext()){
			temp = temp.getNext();
		}
		temp.setNext(node);
		length++;

	}

	public synchronized void insert(int data , int position){
		if(position < 0)
			position = 0;
		if(position >= length)
			position = length;

		Node temp = head;
		if(null == temp){
			Node newNode = new Node(data);
			head = newNode;
		}
		for(int i =0 ; i < position ; ++i){
			temp = temp.getNext();
		}
		Node newNode = new Node(data);
		newNode.setNext(temp.getNext());
		temp.setNext(newNode);
		++length;


	}

	public synchronized Node removeFromBegin(){
		Node node = head;
		if(node != null){
			head = head.getNext();
			node.setNext(null);
			--length;
		}
		return node;
	}

	public synchronized Node removeFromEnd(){
		Node node = head;
		Node prev = null;
		if(node != null){
			while(null != node.getNext()){
				node = node.getNext();
				prev = node;
			}
			if(null != prev){
				prev.setNext(node.getNext());
			}
		}
		return node;
	}

	public synchronized void removeExact(Node node){

	}

	public synchronized void  remove(int position){

	}

	public String toString(){
		String result = "[";
		if(head == null){
			return result+"]";
		}
		Node temp = head;
		result = result  + ","+temp.getData();
		temp = temp.getNext();
		while(temp.getNext() != null){
			result = result  + ","+temp.getData();
			temp = temp.getNext();
		}
		result = result+"]";
		return result;
	}

	public int length(){
		return length;
	}

	public int getPosition(int data){
		Node temp = head;
		int position = 0;
		
		while(temp != null){
			if(temp.getData() == data)
				return position;
			temp = temp.getNext();
			position++;
		}
		return Integer.MIN_VALUE;
	}

	public void clearList(){
		head = null;
		length = 0;
	}

	public static void main (String [] args){

	}
}
