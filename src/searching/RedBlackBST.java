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
	
	public void put(Key key, Value val) {
		root = put(root, key, val);
		root.color = BLACK;
	}
	
	private Node put(Node h, Key key, Value val) {
		if (h == null) {
			return new Node(key, val, 1, RED);
		}
		
		int cmp = key.compareTo(h.key);
		
		if (cmp < 0) {
			h.left = put(h.left, key, val);
		} else if (cmp > 0) {
			h.right = put(h.right, key, val);
		} else {
			h.val = val;
		}
		
		if (!isRed(h.left) && isRed(h.right)) {
			rotateLeft(h);
		}
		
		if (isRed(h.left) && isRed(h.left.left)) {
			rotateRight(h);
		}
		
		if (isRed(h.left) && isRed(h.right)) {
			flipColors(h);
		}
		
		h.N = 1+size(h.left)+size(h.right);
		return h;
	}
	
	public void delete(Key key) {
		root = delete(root, key);
		root.color = BLACK;
	}
	
	private Node delete(Node h, Key key) {
		
		if (h == null) {
			return null;
		}
		
		int cmp = key.compareTo(h.key);
		
		if (cmp < 0) {
			
		} else if (cmp > 0) {
			
		} else {
			
		}
		
		return null;
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
