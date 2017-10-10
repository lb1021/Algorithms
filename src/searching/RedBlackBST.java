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
		return x.size;
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
		
		h.size = 1+size(h.left)+size(h.right);
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
	
	public void deleteMin() {
		
		if (!isRed(root.left) && !isRed(root.right)) {
			root.color = RED;
		}
		
		root = deleteMin(root);
		if (!isEmpty()) {
			root.color = BLACK;
		}
	}
	
	private Node deleteMin(Node h) {
		if (h.left == null) {
			return null;
		}
		
		if (!isRed(h.left) && !isRed(h.left.left)) {
			h = moveRedLeft(h);
		}
		
		h.left = deleteMin(h.left);
		
		return balance(h);
	}
	
	private Node moveRedLeft(Node h) {
		flipColors(h);
		
		if (isRed(h.right.left)) {
			h.right = rotateRight(h.right);
			h = rotateLeft(h);
			
			flipColors(h);
		}
		
		return h;
	}
	
	private Node rotateLeft(Node h) {
		Node x = h.right;
		h.right = x.left;
		x.left = h;
		x.color = h.color;
		h.color = RED;
		x.size = h.size;
		h.size = size(h.left) + size(h.right) + 1;
		return x;
	}
	
	private Node rotateRight(Node h) {
		Node x = h.left;
		h.left = x.right;
		x.right = h;
		x.color = h.color;
		h.color = RED;
		x.size = h.size;
		h.size = size(h.left) + size(h.right) + 1;
		return x;
	}
	
	private void flipColors(Node h) {
		h.color = !h.color;
		h.left.color = !h.left.color;
		h.right.color = !h.left.color;
	}
	
	private Node balance(Node h) {
		
		if (isRed(h.right)) {
			h = rotateLeft(h);
		}
		
		if (isRed(h.left) && isRed(h.left.left)) {
			h = rotateRight(h);
		}
		
		if (isRed(h.left) && isRed(h.right)) {
			flipColors(h);
		}
		
		h.size = size(h.left) + size(h.right) + 1;
		
		return h;
	}
	
	private boolean isRed(Node x) {
		if (x == null) {
			return false;
		}
		return x.color == RED;
	}
	
	public boolean isEmpty() {
		return root == null;
	}
	
	private class Node {
		Node left;
		Node right;
		Key key;
		Value val;
		int size;
		boolean color;
		
		public Node(Key key, Value val, int size, boolean color) {
			this.key = key;
			this.val = val;
			this.size = size;
			this.color = color;
		}
	}

}
