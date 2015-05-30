package com.tree.peer;

public class Node {

	String data;
	Node left;
	Node right;
	Node peer;

	public Node(String data, Node left, Node right) {
		super();
		this.left = left;
		this.right = right;
		this.data = data;
	}

	@Override
	public String toString() {
		return "Node [data=" + data + ", left=" + left + ", right=" + right + ", peer=" + peer + "]";
	}


}
