package com.winegame;

import java.util.ArrayDeque;
import java.util.Queue;

public class WineDriver {

	public static void main(String[] args) {
		WineDriver driver = new WineDriver();
		WineTreeNode root = driver.prepare();
		driver.fillCups(root, 1, 19);
		System.out.println("done");
	}

	private void fillCups(WineTreeNode root, float u, float v) {
		if (root == null)
			return;

		Queue<WineTreeNode> Q = new ArrayDeque<WineTreeNode>();
		Q.add(root);
		float volumeLeft = v;
		int maxLevel = 0;
		root.volume = v;
		boolean isNegative = true;
		while (!Q.isEmpty()) {
			int levelSize = Q.size();
			for (int i = 0; i < levelSize; i++) {
				WineTreeNode pop = Q.remove();
				if(pop.volume >= 0){
					isNegative = false;
				}
				volumeLeft = pop.volume - u;
				System.out.println(volumeLeft);
				// System.out.println(volumeLeft);
				if (pop.left != null) {
					pop.left.volume += volumeLeft / 2;
					if (!Q.contains(pop.left))
						Q.add(pop.left);
				}
				if (pop.right != null) {
					pop.right.volume += volumeLeft / 2;
					if (!Q.contains(pop.right))
						Q.add(pop.right);
				}
			}

			if(isNegative)
				break;
			
			maxLevel++;
		}
		System.out.println(maxLevel);
	}

	private WineTreeNode prepare() {
		WineTreeNode node25 = new WineTreeNode(25, null, null);
		WineTreeNode node24 = new WineTreeNode(24, null, null);
		WineTreeNode node23 = new WineTreeNode(23, null, null);
		WineTreeNode node22 = new WineTreeNode(22, null, null);
		WineTreeNode node21 = new WineTreeNode(21, null, null);
		WineTreeNode node20 = new WineTreeNode(20, null, null);
		WineTreeNode node19 = new WineTreeNode(19, null, null);
		WineTreeNode node18 = new WineTreeNode(18, node24, node25);
		WineTreeNode node17 = new WineTreeNode(17, node23, node24);
		WineTreeNode node16 = new WineTreeNode(16, node22, node23);
		WineTreeNode node15 = new WineTreeNode(15, node20, node21);
		WineTreeNode node14 = new WineTreeNode(14, node19, node20);
		WineTreeNode node13 = new WineTreeNode(13, node18, node19);
		WineTreeNode node12 = new WineTreeNode(12, node17, node18);
		WineTreeNode node11 = new WineTreeNode(11, node16, node17);
		WineTreeNode node10 = new WineTreeNode(10, node14, node15);
		WineTreeNode node09 = new WineTreeNode(9, node13, node14);
		WineTreeNode node08 = new WineTreeNode(8, node12, node13);
		WineTreeNode node07 = new WineTreeNode(7, node11, node12);
		WineTreeNode node06 = new WineTreeNode(6, node09, node10);
		WineTreeNode node05 = new WineTreeNode(5, node08, node09);
		WineTreeNode node04 = new WineTreeNode(4, node07, node08);
		WineTreeNode node03 = new WineTreeNode(3, node05, node06);
		WineTreeNode node02 = new WineTreeNode(2, node04, node05);
		WineTreeNode node01 = new WineTreeNode(1, node02, node03);
		return node01;

	}

}
