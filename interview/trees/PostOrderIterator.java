package com.trees;

import java.util.Stack;

public class PostOrderIterator {

	public PostOrderIterator(BNode rootNode) {
		this.root = rootNode;
	}

	Stack<BNode> S = new Stack<BNode>();
	BNode previousNode;
	BNode root;

	public boolean hasNext() {
		return previousNode != root;
	}

	public BNode next() {
		BNode tempNode = null;
		if (previousNode == null && root != null) {
			tempNode = root;
			S.push(tempNode);
		}

		tempNode = S.peek();
		boolean breakLoop = false;
		do {

			// if right child is previous node , no need to do anything.
			if (tempNode.right == previousNode && previousNode != null) {
				breakLoop = true;
			}

			else {

				if (tempNode.left == previousNode && tempNode.right == null) {
					breakLoop = true;
				} else {
					while (tempNode.left != null && previousNode != tempNode.left) {
						tempNode = tempNode.left;
						S.push(tempNode);
					}

					if (tempNode.right != null) {
						tempNode = tempNode.right;
						S.push(tempNode);
					}
				}

				if (tempNode.left == null && tempNode.right == null)
					breakLoop = true;
			}

		} while (!breakLoop);

		previousNode = S.pop();

		// keep going left
		// when no left then check if right then keep going left of right
		// if no right then print the left.

		return previousNode;
	}

	private static BNode prepareBT1() {
		BNode node07 = new BNode(7, null, null);
		BNode node06 = new BNode(6, null, null);
		BNode node05 = new BNode(5, null, null);
		BNode node04 = new BNode(4, null, null);
		BNode node03 = new BNode(3, node06, node07);
		BNode node02 = new BNode(2, node04, node05);
		BNode node01 = new BNode(1, node02, node03);
		return node01;
	}

	private static BNode prepareBT2() {
		BNode node01 = new BNode(1, null, null);
		return node01;
	}

	private static BNode prepareBT3() {
		BNode node13 = new BNode(13, null, null);
		BNode node12 = new BNode(12, null, null);
		BNode node11 = new BNode(11, node13, null);
		BNode node10 = new BNode(10, null, node12);
		BNode node09 = new BNode(9, null, null);
		BNode node08 = new BNode(8, node09, null);
		BNode node07 = new BNode(7, null, null);
		BNode node06 = new BNode(6, null, null);
		BNode node05 = new BNode(5, node06, node07);
		BNode node04 = new BNode(4, null, node05);
		BNode node03 = new BNode(3, node10, node11);
		BNode node02 = new BNode(2, node04, node08);
		BNode node01 = new BNode(1, node02, node03);

		return node01;
	}

	private static BNode prepareBT4() {
		BNode node06 = new BNode(6, null, null);
		BNode node05 = new BNode(5, node06, null);
		BNode node04 = new BNode(4, node05, null);
		BNode node03 = new BNode(3, node04, null);
		BNode node02 = new BNode(2, node03, null);
		BNode node01 = new BNode(1, node02, null);

		return node01;
	}

	private static BNode prepareBT5() {
		BNode node06 = new BNode(6, null, null);
		BNode node05 = new BNode(5, null, node06);
		BNode node04 = new BNode(4, null, node05);
		BNode node03 = new BNode(3, null, node04);
		BNode node02 = new BNode(2, null, node03);
		BNode node01 = new BNode(1, null, node02);

		return node01;
	}
	
	private static BNode prepareBT6() {
		BNode node06 = new BNode(6, null, null);
		BNode node05 = new BNode(5, node06, null);
		BNode node04 = new BNode(4, null, node05);
		BNode node03 = new BNode(3, node04, null);
		BNode node02 = new BNode(2, null, node03);
		BNode node01 = new BNode(1, node02, null);

		return node01;
	}

	public static void main(String[] args) {
		BNode prepareBT = prepareBT1();
		PostOrderIterator iterator = new PostOrderIterator(prepareBT);
		while (iterator.hasNext()) {
			System.out.print(iterator.next() + " ");
		}
		System.out.println();

		prepareBT = prepareBT2();
		iterator = new PostOrderIterator(prepareBT);
		while (iterator.hasNext()) {
			System.out.print(iterator.next() + " ");
		}
		System.out.println();

		prepareBT = prepareBT3();
		iterator = new PostOrderIterator(prepareBT);
		while (iterator.hasNext()) {
			System.out.print(iterator.next() + " ");
		}
		System.out.println();

		prepareBT = prepareBT4();
		iterator = new PostOrderIterator(prepareBT);
		while (iterator.hasNext()) {
			System.out.print(iterator.next() + " ");
		}
		System.out.println();

		prepareBT = prepareBT5();
		iterator = new PostOrderIterator(prepareBT);
		while (iterator.hasNext()) {
			System.out.print(iterator.next() + " ");
		}
		System.out.println();
		
		prepareBT = prepareBT6();
		iterator = new PostOrderIterator(prepareBT);
		while (iterator.hasNext()) {
			System.out.print(iterator.next() + " ");
		}
		System.out.println();
	}
}

class BNode {
	int data;
	BNode left;
	BNode right;

	public BNode(int data, BNode left, BNode right) {
		super();
		this.data = data;
		this.left = left;
		this.right = right;
	}

	@Override
	public String toString() {
		return "BNode [data=" + data + "]";
	}

}
