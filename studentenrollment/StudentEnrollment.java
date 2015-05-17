package com.interview;

public class StudentEnrollment {
	ArrayNode[] array = new ArrayNode[500];
	LinkedNode head;
	LinkedNode tail;

	public static void main(String[] args) {
		StudentEnrollment program = new StudentEnrollment();
		program.enroll(40);
		program.enroll(50);
		program.enroll(60);
		program.enroll(70);
		program.enroll(80);
		program.enroll(90);
		program.enroll(100);

		program.optOut(70);
		program.optOut(40);
		program.optOut(100);
		program.optOut(90);

		System.out.println(program.lookup());
	}

	private void enroll(int rollNumber) {
		if (rollNumber > 0 && rollNumber < 500) {
			LinkedNode newNode = new LinkedNode(null, tail, rollNumber);
			if (tail == null) {
				tail = newNode;
			} else {
				tail.next = newNode;
			}
			if (head == null) {
				head = newNode;
			}
			tail = newNode;
			array[rollNumber] = new ArrayNode(newNode);
		}
	}

	private void optOut(int rollNumber) {
		if (rollNumber > 0 && rollNumber < 500) {
			if (array[rollNumber] != null) {
				LinkedNode nodeToDelete = array[rollNumber].next;

				if (nodeToDelete.next != null) {
					nodeToDelete.next.previous = nodeToDelete.previous;
				} else {
					tail = nodeToDelete.previous;
				}

				if (nodeToDelete.previous != null) {
					nodeToDelete.previous.next = nodeToDelete.next;
				} else {
					head = nodeToDelete.next;
				}
				nodeToDelete = null;
				array[rollNumber] = null;
			}
		}
	}

	private int lookup() {
		if (head != null) {
			return head.data;
		}
		return -1;
	}
}
