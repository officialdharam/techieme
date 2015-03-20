package com.test;

import java.util.Stack;


/**
 * The below code can be independently used for iterative Inorder Traversal of a binary tree. 
 *  
 * @author dprasad
 *
 */
public class InorderIterative {

	public static void main(String[] args) {
		InorderIterative driver = new InorderIterative();
		BinaryNode node = driver.createTree();

		Stack<BinaryNode> S = new Stack<BinaryNode>();

		/*
		 * Travel through the left hand of the tree and push all the left nodes in the stack.
		 */
		while (node != null) {
			S.push(node);
			node = node.left;
		}

		/*
		 * pop a node at a time and print it, if a right node exists for the current node, push the right node and all its left in the stack.
		 */
		while (!S.isEmpty()) {
			node = S.pop();
			System.out.print(node.data + " , ");
			if (node.right != null) {
				node = node.right;
				while (node != null) {
					S.push(node);
					node = node.left;
				}
			}
		}
	}

	/**
	 * Helper method to create the tree with 32 nodes.
	 * @return
	 */
	private BinaryNode createTree() {

		BinaryNode n31 = new BinaryNode(null, null, 31);
		BinaryNode n30 = new BinaryNode(null, null, 30);
		BinaryNode n29 = new BinaryNode(null, null, 29);
		BinaryNode n28 = new BinaryNode(null, null, 28);
		BinaryNode n27 = new BinaryNode(null, null, 27);
		BinaryNode n26 = new BinaryNode(null, null, 26);
		BinaryNode n25 = new BinaryNode(null, null, 25);
		BinaryNode n24 = new BinaryNode(null, null, 24);
		BinaryNode n23 = new BinaryNode(null, null, 23);
		BinaryNode n22 = new BinaryNode(null, null, 22);
		BinaryNode n21 = new BinaryNode(null, null, 21);
		BinaryNode n20 = new BinaryNode(null, null, 20);
		BinaryNode n19 = new BinaryNode(null, null, 19);
		BinaryNode n18 = new BinaryNode(null, null, 18);
		BinaryNode n17 = new BinaryNode(null, null, 17);
		BinaryNode n16 = new BinaryNode(null, null, 16);

		BinaryNode n15 = new BinaryNode(n30, n31, 15);
		BinaryNode n14 = new BinaryNode(n28, n29, 14);
		BinaryNode n13 = new BinaryNode(n26, n27, 13);
		BinaryNode n12 = new BinaryNode(n24, n25, 12);
		BinaryNode n11 = new BinaryNode(n22, n23, 11);
		BinaryNode n10 = new BinaryNode(n20, n21, 10);
		BinaryNode n09 = new BinaryNode(n18, n19, 9);
		BinaryNode n08 = new BinaryNode(n16, n17, 8);

		BinaryNode n07 = new BinaryNode(n14, n15, 7);
		BinaryNode n06 = new BinaryNode(n12, n13, 6);
		BinaryNode n05 = new BinaryNode(n10, n11, 5);
		BinaryNode n04 = new BinaryNode(n08, n09, 4);

		BinaryNode n03 = new BinaryNode(n06, n07, 3);
		BinaryNode n02 = new BinaryNode(n04, n05, 2);

		BinaryNode n01 = new BinaryNode(n02, n03, 1);

		return n01;
	}
}
