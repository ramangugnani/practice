package practice.algorithms.linkedlist;

class LinkedListNode{
	int val;
	LinkedListNode next;

	public LinkedListNode(int val) {
		this.val = val;
		next = null;
	}

}
public class List {

	public static void main(String[] args) {


	}

	public static LinkedListNode removeNodes(LinkedListNode list , int x){
		if(null == list)
			return list;

		LinkedListNode head = list;
		LinkedListNode iterator = list;
		LinkedListNode prev = null;

		while(iterator != null){
			if(iterator.val <= x){
					prev = iterator;
					iterator = iterator.next;
			}else{
				//delete a node
				//if root node prev = null
				if(prev == null){
					// head will be changed
					iterator = iterator.next;
					head  = iterator;
				}else{
					LinkedListNode temp = iterator;
					iterator = iterator.next;
					prev.next = iterator;

				}
			}
		}
		return head;
	}
}
