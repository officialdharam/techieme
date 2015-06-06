package com.trees;

public class ShortestPathInBST {

	int sum = 0;

	public static void main(String[] args) {
		ShortestPathInBST bstPath = new ShortestPathInBST();
		BSTNode bst = bstPath.prepareBST();
		int heightOfTree = bstPath.heightOfTree(bst);
		int[] paths = new int[heightOfTree];
		int K = 100;
		int sumLocal = 0;
		bstPath.findPath(0, paths, bst, K, sumLocal);
	}


	/**
	 * Recursive method to find the path in a tree.
	 */
	private void findPath(int length, int[] paths, BSTNode BSTNode, int K, int sumLocal) {
		// breaking condition, if we achiheved the required sum, no need to wor further.
		if (BSTNode == null || sum == K)
			return;

		// add the current node to the path
		paths[length++] = BSTNode.data;
		sumLocal += BSTNode.data;
		// test if the sum is achieve, if yes break out.
		if (sumLocal > K) {
			return;
		}

		// if we reached a leaf, and the sum is achieved, print the path and break.
		if (BSTNode.left == null && BSTNode.right == null) {
			if (sumLocal == K) {
				sum = sumLocal;
				printPath(paths, length, K);
				return;
			}
		} // else recurse the right subtree first and then the left. 
		else {
			
			findPath(length, paths, BSTNode.right, K, sumLocal);
			findPath(length, paths, BSTNode.left, K, sumLocal);
		}
	}

	private void printPath(int[] path, int length, int K) {
		for (int i = 0; i < length; i++) {
			System.out.print(path[i] + " ");
		}
		System.out.println();
	}

	private BSTNode prepareBST() {
		BSTNode node19 = new BSTNode(1, null, null);
		BSTNode node18 = new BSTNode(7, null, null);
		BSTNode node17 = new BSTNode(14, null, null);
		BSTNode node16 = new BSTNode(16, null, null);
		BSTNode node15 = new BSTNode(24, null, null);
		BSTNode node14 = new BSTNode(26, null, null);
		BSTNode node13 = new BSTNode(5, null, null);
		BSTNode node12 = new BSTNode(21, null, null);
		BSTNode node11 = new BSTNode(3, node19, null);
		BSTNode node10 = new BSTNode(8, node18, null);
		BSTNode node09 = new BSTNode(15, node17, node16);
		BSTNode node08 = new BSTNode(25, node15, node14);
		BSTNode node07 = new BSTNode(4, node11, node13);
		BSTNode node06 = new BSTNode(10, node10, null);
		BSTNode node05 = new BSTNode(13, null, node09);
		BSTNode node04 = new BSTNode(23, node12, node08);
		BSTNode node03 = new BSTNode(6, node07, node06);
		BSTNode node02 = new BSTNode(17, node05, node04);
		BSTNode node01 = new BSTNode(11, node03, node02);

		return node01;
	}
	
	private int heightOfTree(BSTNode root){
		if(root == null)
			return 0;
		return 1 + Math.max(heightOfTree(root.left), heightOfTree(root.right));
	}
}

class BSTNode {
	BSTNode left;
	BSTNode right;
	int data;

	public BSTNode(int data, BSTNode left, BSTNode right) {
		super();
		this.left = left;
		this.right = right;
		this.data = data;
	}

}
