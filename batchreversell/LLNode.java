package com.interview.ll;

public class LLNode {

	String data;
	LLNode next;

	public LLNode(String data, LLNode next) {
		super();
		this.data = data;
		this.next = next;
	}

	@Override
	public String toString() {
		return "LLNode [data=" + data + "]";
	}

}
