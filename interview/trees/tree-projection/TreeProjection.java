package com.trees;

import java.util.ArrayDeque;
import java.util.Queue;

public class TreeProjection {

	public static void main(String[] args) {
		TreeProjection treeProjection = new TreeProjection();
		TreeNode tree = treeProjection.createTree();
		System.out.println("Left Hand Projection");
		treeProjection.leftProjection(tree);
		System.out.println("\nRight Hand Projection");
		treeProjection.rightProjection(tree);
	}

	private void leftProjection(TreeNode tree) {
		if (tree == null)
			return;

		Queue<TreeNode> Q = new ArrayDeque<TreeNode>();
		Q.add(tree);
		while (!Q.isEmpty()) {
			int size = Q.size();
			for (int i = 0; i < size; i++) {
				TreeNode node = Q.remove();
				if(i == 0 )
					System.out.print(" " + node.getNodeId() + " ");
				Q.addAll(node.getChildren());
			}
		}
	}

	private void rightProjection(TreeNode tree) {
		if (tree == null)
			return;

		Queue<TreeNode> Q = new ArrayDeque<TreeNode>();
		Q.add(tree);
		while (!Q.isEmpty()) {
			int size = Q.size();
			for (int i = 0; i < size; i++) {
				TreeNode node = Q.remove();
				Q.addAll(node.getChildren());
				if(i == size - 1 )
					System.out.print(" " + node.getNodeId() + " ");
			}
		}
	}

	private TreeNode createTree() {
		TreeNode node01 = new TreeNode(1);
		TreeNode node02 = new TreeNode(2);
		TreeNode node03 = new TreeNode(3);
		TreeNode node04 = new TreeNode(4);
		TreeNode node05 = new TreeNode(5);
		TreeNode node06 = new TreeNode(6);
		TreeNode node07 = new TreeNode(7);
		TreeNode node08 = new TreeNode(8);
		TreeNode node09 = new TreeNode(9);
		TreeNode node10 = new TreeNode(10);
		TreeNode node11 = new TreeNode(11);
		TreeNode node12 = new TreeNode(12);
		TreeNode node13 = new TreeNode(13);
		TreeNode node14 = new TreeNode(14);
		TreeNode node15 = new TreeNode(15);
		TreeNode node16 = new TreeNode(16);
		TreeNode node17 = new TreeNode(17);
		TreeNode node18 = new TreeNode(18);
		TreeNode node19 = new TreeNode(19);

		node01.getChildren().add(node02);
		node01.getChildren().add(node03);
		node01.getChildren().add(node04);
		node01.getChildren().add(node05);

		node02.getChildren().add(node06);

		node03.getChildren().add(node07);
		node03.getChildren().add(node08);

		node04.getChildren().add(node09);
		node04.getChildren().add(node10);

		node05.getChildren().add(node11);
		node05.getChildren().add(node12);

		node08.getChildren().add(node13);

		node11.getChildren().add(node14);

		node13.getChildren().add(node15);
		node13.getChildren().add(node16);

		node14.getChildren().add(node17);

		node17.getChildren().add(node18);
		node17.getChildren().add(node19);

		return node01;
	}
}
