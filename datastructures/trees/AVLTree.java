public class AVLTree {

	static Node insert(Node root, int val) {
		if (root == null) {
			root = new Node();
			root.ht = 0;
			root.val = val;
		} else if (val < root.val) {
			root.left = insert(root.left, val);
			if (height(root.left) - height(root.right) == 2)
				if (val < root.left.val)
					root = leftLeft(root);
				else
					root = leftRight(root);
		} else if (val > root.val) {
			root.right = insert(root.right, val);
			if (height(root.right) - height(root.left) == 2)
				if (val > root.right.val)
					root = rightRight(root);
				else
					root = rightLeft(root);
		}

		root.ht = Math.max(height(root.left), height(root.right)) + 1;
		return root;
	}

	static Node leftLeft(Node n) {
		Node t = n.left;
		Node t2 = t.right;
		t.right = n;
		n.left = t2;
		n.ht = Math.max(height(n.left), height(n.right)) + 1;
		t.ht = Math.max(height(t.left), height(t.right)) + 1;
		return t;
	}

	static Node rightRight(Node n) {
		Node t = n.right;
		Node t2 = t.left;
		t.left = n;
		n.right = t2;
		n.ht = Math.max(height(n.left), height(n.right)) + 1;
		t.ht = Math.max(height(t.left), height(t.right)) + 1;
		return t;
	}

	static Node rightLeft(Node n) {
		Node t1 = n.right;
		Node t2 = t1.left;
		n.right = t2;
		t1.left = t2.right;
		t2.right = t1;
		n.ht = Math.max(height(n.left), height(n.right)) + 1;
		t1.ht = Math.max(height(t1.left), height(t1.right)) + 1;
		return rightRight(n);
	}

	static Node leftRight(Node n) {
		Node t1 = n.left;
		Node t2 = t1.right;
		n.left = t2;
		t1.right = t2.left;
		t2.left = t1;
		n.ht = Math.max(height(n.left), height(n.right)) + 1;
		t1.ht = Math.max(height(t1.left), height(t1.right)) + 1;
		return leftLeft(n);
	}

	static int height(Node n) {
		if (n == null)
			return -1;
		if (n.left == null && n.right == null)
			return 0;
		return Math.max(height(n.left), height(n.right)) + 1;
	}

	public static void main(String[] args) {
		Node root = insert(null, 14);
		root = insert(root, 25);
		root = insert(root, 21);
		root = insert(root, 10);
		root = insert(root, 23);
		root = insert(root, 7);
		root = insert(root, 26);
		root = insert(root, 12);
		root = insert(root, 30);
		root = insert(root, 16);
		root = insert(root, 19);
		System.out.println("done");

	}
}

class Node {
	int val;
	int ht;
	Node left;
	Node right;
}
