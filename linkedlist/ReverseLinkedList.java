public class ReverseLinkedList {
	public static void main(String[] args) {
		ReverseLinkedList driver = new ReverseLinkedList();
		Node ll1 = LLHelper.prepareLinkedList(1, 2, 3);
		System.out.println("Linked List 1");
		LLHelper.printLinkedList(ll1);
		System.out.println("Reversed Linked List");
		LLHelper.printLinkedList(driver.reverse(ll1));
	}

	private Node reverse(Node h0) {
		Node headOfUnReversedLL = h0;
		Node headOfReversedLL = null;
		Node nodeToReverse = null;
		while (headOfUnReversedLL != null) {
			headOfReversedLL = nodeToReverse;
			nodeToReverse = headOfUnReversedLL;
			headOfUnReversedLL = headOfUnReversedLL.next;
			nodeToReverse.next = headOfReversedLL;
		}
		headOfReversedLL = nodeToReverse;
		return headOfReversedLL;
	}
}
