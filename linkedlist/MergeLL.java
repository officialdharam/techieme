package com.interview.ll;

public class MergeLL {

	public static void main(String[] args) {
		MergeLL llDriver = new MergeLL();
		Node ll1 = llDriver.prepareLinkedList(new int[]{1,3,4,7,8,9});
		Node ll2 = llDriver.prepareLinkedList(new int[]{1,2,5,6,8,9});
		Node mergeLists = llDriver.MergeLists(ll1, ll2);
		llDriver.printLinkedList(mergeLists);
	}

	Node MergeLists(Node list1, Node list2) {
		if (list1 == null)
			return list2;
		if (list2 == null)
			return list1;

		Node head;
		if (list1.data < list2.data) {
			head = list1;
		} else {
			head = list2;
			list2 = list1;
			list1 = head;
		}
		while (list1.next != null && list2 != null) {
			if (list1.next.data <= list2.data) {
				list1 = list1.next;
			} else {
				Node tmp = list1.next;
				list1.next = list2;
				list2 = tmp;
			}
		}
		if (list1.next == null)
			list1.next = list2;
		return head;
	}
	public void printLinkedList(Node head) {
		Node temp = head;
		while (temp != null) {
			System.out.print(temp.data + " -> ");
			temp = temp.next;
		}
		System.out.println("NULL");
	}
	
	public Node prepareLinkedList(int... data) {

		Node headNode = new Node(data[0]);
		Node previous = headNode;
		for (int i = 1; i < data.length; i++) {
			Node node = new Node(data[i]);
			previous.next = node;
			previous = node;
		}
		return headNode;
	}
}


class Node{
    int data;
    Node next;
    public Node(){
    }

    public Node(int d){
    	this.data = d;
    }
    
    public Node(int data, Node next){
        this();
        this.data = data;
        this.next = next;
    }
    public int getData(){
        return this.data;
    }
    public Node getNext(){
        return this.next;
    }
    public void setData(int data){
        this.data = data;
    }
    public void setNext(Node next){
        this.next = next;
    }

	@Override
	public String toString() {
		return "Node [data=" + data + ", next=" + next + "]";
	}
}


class Node{
    int data;
    Node next;
    public Node(){
    }

    public Node(int data, Node next){
        this();
        this.data = data;
        this.next = next;
    }
    public int getData(){
        return this.data;
    }
    public Node getNext(){
        return this.next;
    }
    public void setData(int data){
        this.data = data;
    }
    public void setNext(Node next){
        this.next = next;
    }

	@Override
	public String toString() {
		return "Node [data=" + data + ", next=" + next + "]";
	}
    
    
}
