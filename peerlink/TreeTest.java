package com.tree.peer;

import java.util.ArrayDeque;
import java.util.Queue;

public class TreeTest {

	public static void main(String[] args) {

		TreeTest test = new TreeTest();
		Node tree = test.prepare();
		test.addPeerApproachTwo(tree);
		System.out.println(tree);
		tree = test.prepare();
		test.addPeerApproachOne(tree);
		System.out.println(tree);
	}

	private void addPeerApproachOne(Node root) {
		if (root == null)
			return;
		Queue<Node> Q = new ArrayDeque<Node>();
		Q.add(root);
		while (!Q.isEmpty()) {
			int size = Q.size();
			Node node = Q.remove();
			if (node.left != null)
				Q.add(node.left);
			if (node.right != null)
				Q.add(node.right);
			for (int i = 1; i < size; i++) {
				Node nextNode = Q.remove();
				node.peer = nextNode;
				node = nextNode;
				if (node.left != null)
					Q.add(node.left);
				if (node.right != null)
					Q.add(node.right);
			}

		}
	}

	private void addPeerApproachTwo(Node root) {
		if (root == null)
			return;

		if (root != null) {
			Node neighbor = null;
			if (root.left != null) {
				if (root.right != null)
					root.left.peer = root.right;
				else {
					neighbor = getNeighbor(root);
					root.left.peer = neighbor;
				}
			}

			if (root.right != null) {
				neighbor = getNeighbor(root);
				root.right.peer = neighbor;
			}
		}

		addPeerApproachTwo(root.left);
		addPeerApproachTwo(root.right);
	}

	private Node getNeighbor(Node node) {
		while (node.peer != null) {
			if (node.peer.left != null) {
				return node.peer.left;
			} else if (node.peer.right != null) {
				return node.peer.right;
			}
			node = node.peer;
		}
		return null;
	}

	private Node prepare() {
		Node node09 = new Node("I", null, null);
		Node node08 = new Node("H", null, null);
		Node node07 = new Node("G", null, null);
		Node node06 = new Node("F", node08, node09);
		Node node05 = new Node("E", null, null);
		Node node04 = new Node("D", node07, null);
		Node node03 = new Node("C", null, node06);
		Node node02 = new Node("B", node04, node05);
		Node node01 = new Node("A", node02, node03);
		return node01;
	}

}
