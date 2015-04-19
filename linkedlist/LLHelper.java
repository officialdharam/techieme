public class LLHelper {
	public static Node prepareLinkedList(int... data) {

		Node headNode = new Node(data[0]);
		Node previous = headNode;
		for (int i = 1; i < data.length; i++) {
			Node node = new Node(data[i]);
			previous.next = node;
			previous = node;
		}
		return headNode;
	}

	public static void printLinkedList(Node head) {
		Node temp = head;
		while (temp != null) {
			System.out.print(temp.data + " -> ");
			temp = temp.next;
		}
		System.out.println("NULL");
	}
}
