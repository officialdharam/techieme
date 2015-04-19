public class MergeLinkedList {

	public static void main(String[] args) {
		MergeLinkedList driver = new MergeLinkedList();
		Node ll1 = LLHelper.prepareLinkedList(1, 2, 3);
		Node ll2 = LLHelper.prepareLinkedList(3, 4);
		System.out.println("Linked List 1");
		LLHelper.printLinkedList(ll1);
		System.out.println("Linked List 2");
		LLHelper.printLinkedList(ll2);
		System.out.println("Merged Linked List");
		LLHelper.printLinkedList(driver.mergeLinkedList(ll1, ll2));
	}

	private Node mergeLinkedList(Node h1, Node h2) {
		Node newHead = null;
		Node temp;

		if (h1.data > h2.data) {
			temp = h1;
			h1 = h2;
			h2 = temp;
		}

		newHead = h1;
		h1 = h1.next;
		temp = newHead;

		while (h1 != null && h2 != null) {
			if (h1.data > h2.data) {
				temp = h1;
				h1 = h2;
				h2 = temp;
			}

			temp.next = h1;
			temp = h1;
			h1 = h1.next;
		}

		if (h1 == null)
			temp.next = h2;
		else
			temp.next = h1;

		return newHead;
	}
}
  
