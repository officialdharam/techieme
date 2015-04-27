package com.test.dp;

import java.util.ArrayList;
import java.util.List;

public class Interleaving {

	public static void main(String[] args) {
		Interleaving driver = new Interleaving();
		driver.test("ABCD", "BACDX", "ABACDXBCD");
		driver.test("XXY", "XXZ", "XXZXXXY");
		driver.test("XY", "WZ", "WZXY");
		driver.test("XY", "X", "XXY");
		driver.test("YX", "X", "XXY");
		driver.test("XXY", "XXZ", "XXXXZY");
	}

	private void test(String AString, String BString, String CString) {
		char[] A = AString.toCharArray();
		char[] C = CString.toCharArray();
		int[][] matrixA = matrix(A, C);
		TreeNode treeA = createTree(matrixA);

		int[] paths = new int[A.length + 1];
		List<List<Integer>> pathList = new ArrayList<List<Integer>>();
		findPaths(treeA, paths, 0, pathList);
		System.out.println(isInterleaved(pathList, BString, convertToCharacterList(C)));
	}

	private List<Character> convertToCharacterList(char[] X) {
		List<Character> charList = new ArrayList<Character>();
		for (char c : X) {
			charList.add(c);
		}

		return charList;
	}

	private boolean isInterleaved(List<List<Integer>> pathList, String B, List<Character> C) {
		for (List<Integer> path : pathList) {
			List<Character> cCopy = new ArrayList<Character>();
			cCopy.addAll(C);
			for (int index : path) {
				if (index == -1)
					continue;
				cCopy.set(index, '_');
			}

			String bString = B;
			StringBuilder sb = new StringBuilder();
			for (Character c : cCopy) {
				if (c != '_')
					sb.append(c);
			}
			if (bString.equals(sb.toString())) {
				return true;
			}
		}

		return false;
	}

	private List<List<Integer>> findPaths(TreeNode node, int[] paths, int length, List<List<Integer>> pathList) {

		if (node == null)
			return null;

		List<Integer> path = new ArrayList<Integer>();
		paths[length++] = node.id;
		if (node.children == null || node.children.size() <= 0) {
			for (int i = 0; i < length; i++) {
				path.add(paths[i]);
			}
			pathList.add(path);
		} else {
			for (TreeNode n : node.children) {
				findPaths(n, paths, length, pathList);
			}
		}
		return pathList;
	}

	private TreeNode createTree(int[][] matrix) {
		TreeNode node = null;
		TreeNode root = new TreeNode(-1);
		List<TreeNode> nodesAtPreviousLevel = new ArrayList<TreeNode>();
		nodesAtPreviousLevel.add(root);
		List<TreeNode> tempPrevLevelNode = null;
		for (int i = 0; i < matrix.length; i++) {
			tempPrevLevelNode = new ArrayList<TreeNode>();
			for (int j = 0; j < matrix[i].length; j++) {
				if (matrix[i][j] == 1) {
					node = new TreeNode(j);
					tempPrevLevelNode.add(node);
					for (TreeNode prevNode : nodesAtPreviousLevel) {
						if (prevNode.id < j)
							prevNode.getChildren().add(node);
					}
				}
			}
			nodesAtPreviousLevel = new ArrayList<TreeNode>();
			nodesAtPreviousLevel.addAll(tempPrevLevelNode);
		}
		return root;
	}

	private int[][] matrix(char[] X, char[] C) {
		int[][] table = new int[X.length][C.length];
		for (int i = 0; i < X.length; i++) {
			for (int j = 0; j < C.length; j++) {
				if (X[i] == C[j]) {
					table[i][j] = 1;
				}
			}
		}
		return table;
	}
}

class TreeNode {
	List<TreeNode> children;

	@Override
	public String toString() {
		return "TreeNode [children=" + children + ", id=" + id + "]";
	}

	int id;

	public TreeNode(int id) {
		super();
		this.id = id;
	}

	public List<TreeNode> getChildren() {
		if (children == null)
			children = new ArrayList<TreeNode>();
		return children;
	}

	public void setChildren(List<TreeNode> children) {
		this.children = children;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

}
