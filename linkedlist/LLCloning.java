package com.interview.ll;

public class LLCloning {

	public static void main(String[] args) {
		LLCloning cloning = new LLCloning();
		SpecialNode inputList = cloning.prepareList();
		SpecialNode cloneList = cloning.cloneList(inputList);
	}

	private SpecialNode cloneList(SpecialNode inputList) {
		if (inputList == null)
			return null;

		// pass 1
		SpecialNode node = inputList;
		SpecialNode clonedNode = new SpecialNode(node.data, node.next);
		node.next = clonedNode;
		node = node.next.next;
		while (node != null) {
			clonedNode = new SpecialNode(node.data, node.next);
			node.next = clonedNode;
			node = node.next.next;
		}

		// pass 2
		node = inputList;
		while (node != null) {
			SpecialNode randomNode = node.random;
			if (randomNode != null)
				node.next.random = randomNode.next;
			node = node.next.next;
		}

		// pass 3
		node = inputList;
		SpecialNode clonedHead = node.next;
		SpecialNode clonedTemp = node.next;
		while (node != null) {
			node.next = clonedTemp.next;
			node = node.next;
			if (node != null) {
				clonedTemp.next = node.next;
				clonedTemp = clonedTemp.next;
			}
		}
		return clonedHead;
	}

	private SpecialNode prepareList() {
		SpecialNode SpecialNode07 = new SpecialNode("G", null);
		SpecialNode SpecialNode06 = new SpecialNode("F", SpecialNode07);
		SpecialNode SpecialNode05 = new SpecialNode("E", SpecialNode06);
		SpecialNode SpecialNode04 = new SpecialNode("D", SpecialNode05);
		SpecialNode SpecialNode03 = new SpecialNode("C", SpecialNode04);
		SpecialNode SpecialNode02 = new SpecialNode("B", SpecialNode03);
		SpecialNode SpecialNode01 = new SpecialNode("A", SpecialNode02);

		SpecialNode01.random = SpecialNode03;
		SpecialNode02.random = SpecialNode06;
		SpecialNode03.random = null;
		SpecialNode04.random = SpecialNode01;
		SpecialNode05.random = SpecialNode03;
		SpecialNode06.random = SpecialNode05;
		SpecialNode07.random = SpecialNode04;

		return SpecialNode01;
	}
}

class SpecialNode {
	String data;
	SpecialNode next;
	SpecialNode random;

	public SpecialNode(String data, SpecialNode next) {
		super();
		this.data = data;
		this.next = next;
	}

	@Override
	public String toString() {
		return "SpecialNode [data=" + data + "]";
	}
}
