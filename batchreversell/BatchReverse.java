package com.interview.ll;

public class BatchReverse {

	public static void main(String[] args) {
		BatchReverse driver = new BatchReverse();
		LLNode linkedList = driver.createLL();
		driver.printLL(linkedList);
		int k = 3;
		driver.reverseBatch(linkedList, k);
	}
	
	private void reverseBatch(LLNode node, int k){
		LLNode nextNode = node;
		LLNode lastTail = null;
		LLNode reverseBeginning = null;
		LLNode temp = null;
		while (nextNode != null) {
			ObjectPair pair = reverseLL(node, k);
			nextNode = pair.first;
			node = pair.second;
			if (lastTail != null) {
				lastTail.next = nextNode;
			} else {
				reverseBeginning = nextNode;
			}

			temp = nextNode;
			if (temp != null) {
				while (temp.next != null)
					temp = temp.next;
				lastTail = temp;
			}
		}
		printLL(reverseBeginning);
	}

	private ObjectPair reverseLL(LLNode node, int k) {
		LLNode hour = node;
		LLNode temp = null;
		LLNode hor = null;
		int i = 0;
		while (hour != null && i < k) {
			temp = hour.next;
			hour.next = hor;
			hor = hour;
			hour = temp;
			i++;
		}
		return new ObjectPair(hor, hour);
	}

	private void printLL(LLNode node) {
		System.out.println();
		while (node != null) {
			System.out.print(node.data + " ");
			node = node.next;
		}
	}

	private LLNode createLL() {
		LLNode nodeH = new LLNode("H", null);
		LLNode nodeG = new LLNode("G", nodeH);
		LLNode nodeF = new LLNode("F", nodeG);
		LLNode nodeE = new LLNode("E", nodeF);
		LLNode nodeD = new LLNode("D", nodeE);
		LLNode nodeC = new LLNode("C", nodeD);
		LLNode nodeB = new LLNode("B", nodeC);
		LLNode nodeA = new LLNode("A", nodeB);
		return nodeA;
	}
}

class ObjectPair {
	LLNode first;
	LLNode second;

	public ObjectPair(LLNode first, LLNode second) {
		super();
		this.first = first;
		this.second = second;
	}
}
