package com.tree.subtree;

public class CheckSubtree {

	public static void main(String[] args) {
		CheckSubtree subtree = new CheckSubtree();
		BNode T1 = subtree.prepareBT1();
		BNode T2 = subtree.prepareBT2();
		BNode T3 = subtree.prepareBT3();
		boolean result = subtree.findSubtree(T1, T2) || subtree.findSubtree(T2, T1);
		System.out.println("Testing T1 and T2 evaluated to "+ result);
		result = subtree.findSubtree(T1, T3) || subtree.findSubtree(T3, T1);
		System.out.println("Testing T1 and T3 evaluated to "+ result);
	}

	private boolean compareTrees(BNode T1, BNode T2) {
		if (T1 == null && T2 == null)
			return true;

		if (T1 == null || T2 == null)
			return false;

		if (T1.data == T2.data)
			return compareTrees(T1.left, T2.left) && compareTrees(T1.right, T2.right);

		return false;
	}

	private boolean findSubtree(BNode T1, BNode T2) {
		if (T1 == null && T2 != null)
			return false;

		if(T2 == null)
			return true;
		
		boolean comparisonResult = compareTrees(T1, T2);

		if (comparisonResult)
			return true;

		return (findSubtree(T1.right, T2) || findSubtree( T1.left, T2));

	}

	private BNode prepareBT1() {
		BNode node08 = new BNode(8, null, null);
		BNode node07 = new BNode(7, null, null);
		BNode node06 = new BNode(6, null, null);
		BNode node05 = new BNode(5, node06, node07);
		BNode node04 = new BNode(4, null, null);
		BNode node03 = new BNode(3, null, node08);
		BNode node02 = new BNode(2, node04, node05);
		BNode node01 = new BNode(1, node02, node03);

		return node01;
	}

	private BNode prepareBT2() {
		BNode node05 = new BNode(7, null, null);
		BNode node04 = new BNode(6, null, null);
		BNode node03 = new BNode(5, node04, node05);

		return node03;
	}
	
	private BNode prepareBT3() {
		BNode node04 = new BNode(6, null, null);
		BNode node03 = new BNode(5, node04, null);
		BNode node02 = new BNode(4, null, null);
		BNode node01 = new BNode(2, node02, node03);

		return node01;
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
}
