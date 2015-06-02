package com.interview.ll;

public class Reverse {

	public static void main(String[] args) {
		
		Node node06 = new Node(9, null);
		Node node05 = new Node(8, node06);
		Node node04 = new Node(7, node05);
		Node node03 = new Node(4, node04);
		Node node02 = new Node(3, node03);
		Node node01 = new Node(1, node02);
		
		Node node16 = new Node(9, null);
		Node node15 = new Node(8, node16);
		Node node14 = new Node(6, node15);
		Node node13 = new Node(5, node14);
		Node node12 = new Node(2, node13);
		Node node11 = new Node(1, node12);
		
		Reverse reverse = new Reverse();
		Node mergeLists = reverse.MergeLists(node01, node11);
		System.out.println(mergeLists);
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
