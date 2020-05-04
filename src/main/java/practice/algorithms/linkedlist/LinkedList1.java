package practice.algorithms.linkedlist;

public class LinkedList1 {
	Node head;
	public static class  Node{
		Node(int data){
			this.data = data;
			this.next = null;
		}
		int data;
		Node next;
	}
	public void printList(){
		Node n = head;
		while ( null != n){
			System.out.println(n.data);
			n = n.next;
		}
	}

	public void push(int data){
		Node n = new Node(data);
		n.next = head;
		head = n;
	}
	public void insertAfter(Node prev_node,int data){
		if(null == prev_node)
			return;
		Node newNode = new Node(data);
		Node n = head;
		while(n != prev_node){
			n = n.next;
		}
		newNode.next = n.next ;
		n.next = newNode;
	}
	public void append(int data){
		Node newNode = new Node(data);
		Node n = head;
		while(n.next != null){
			n = n.next;
		}
		n.next = newNode;
	}
	public int size(){
		Node n = head;
		int size = 0;
		if(null == n)
			return size;
		while(n != null){
			n = n.next;
			size++;
		}
		return size;
	}
	public void deleteNode(int data){
		Node temp = head;
		Node prev = null;
		if(null == temp)
			return;
		if(temp.data == data){
			head = temp.next;
			return;
		}
		while(null != temp && temp.data != data){
			prev = temp;
			temp = temp.next;
		}

		if(null == temp )
			return;

		prev.next = temp.next;

	}
	public static void main(String [] args){
		LinkedList1 linkedlist1 = new LinkedList1();
		Node n1 = new Node(1);
		Node n2 = new Node(2);
		Node n3 = new Node(3);
		linkedlist1.head = n1;
		n1.next = n2;
		n2.next = n3;
		linkedlist1.push(0);
		linkedlist1.insertAfter(n1, 4);
		linkedlist1.append(5);
		linkedlist1.printList();
		linkedlist1.deleteNode(3);
		System.out.println("size"+linkedlist1.size());
		linkedlist1.printList();
	}
}
