public class AddNumbers {

	public static void main(String[] args) {
		AddNumbers driver = new AddNumbers();
		Node ll1 = LLHelper.prepareLinkedList(1, 9, 3, 5);
		Node ll2 = LLHelper.prepareLinkedList(3, 4, 8);
		System.out.println("Linked List 1");
		LLHelper.printLinkedList(ll1);
		System.out.println("Linked List 2");
		LLHelper.printLinkedList(ll2);
		System.out.println("Sum of numbers");
		LLHelper.printLinkedList(driver.sum(ll1,  ll2));
		return;
	}

	public Node sum(Node ll1, Node ll2) {
		ReverseLinkedList rll = new ReverseLinkedList();
		ll1 = rll.reverse(ll1);
		ll2 = rll.reverse(ll2);

		Node smallList = ll1;
		Node bigList = ll2;
		Node bigHead = ll2;

		while (smallList != null && bigList != null) {
			smallList = smallList.next;
			bigList = bigList.next;
		}

		if (bigList == null) {
			bigList = ll1;
			smallList = ll2;
			bigHead = ll1;
		}

		int carry = 0;
		while (smallList != null && bigList != null) {
			int data1 = smallList.data;
			int data2 = bigList.data;
			data1 += data2 + carry;
			
			if (data1 > 10) {
				data2 = data1 % 10;
				carry = 1;
			} else{
				carry = 0;
				data2 = data1;
			}

			bigList.data = data2;
			smallList = smallList.next;
			bigList = bigList.next;
		}

		while (bigList != null) {
			bigList.data = bigList.data + carry;
			bigList = bigList.next;					
			carry = 0;
		}
		
		bigHead = rll.reverse(bigHead);
		return bigHead;
	}

}
