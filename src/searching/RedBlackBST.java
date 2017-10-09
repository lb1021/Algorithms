package searching;

public class RedBlackBST<Key extends Comparable<Key>, Value> {
	
	private Node root;
	private static final boolean RED = true;
	private static final boolean BLACK = false;
	
	private int size() {
		return size(root);
	}
	
	private int size(Node x) {
		
		if (x == null) {
			return 0;
		}
		return x.N;
	}
	
	private Node rotateLeft(Node h) {
		Node x = h.right;
		h.right = x.left;
		x.left = h;
		x.color = h.color;
		h.color = RED;
		x.N = h.N;
		h.N = size(h.left) + size(h.right) + 1;
		return x;
	}
	
	private Node rotateRight(Node h) {
		Node x = h.left;
		h.left = x.right;
		x.right = h;
		x.color = h.color;
		h.color = RED;
		x.N = h.N;
		h.N = size(h.left) + size(h.right) + 1;
		return x;
	}
	
	private void flipColors(Node h) {
		h.color = RED;
		h.left.color = BLACK;
		h.right.color = BLACK;
	}
	
	
	
	private class Node {
		Node left;
		Node right;
		Key key;
		Value val;
		int N;
		boolean color;
		
		public Node(Key key, Value val, int N, boolean color) {
			this.key = key;
			this.val = val;
			this.N = N;
			this.color = color;
		}
	}

	private boolean isRed(Node x) {
		if (x == null) {
			return false;
		}
		return x.color == RED;
	}
}
