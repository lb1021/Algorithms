package searching;

public class BinarySearchTree<Key extends Comparable<Key>, Value> {
	
	private Node root;
	
	private class Node {
		private Key key;
		private Value value;
		private Node left;
		private Node right;
		private int N;
		
		public Node(Key key, Value value, int N) {
			this.key = key;
			this.value = value;
			this.N = N;
		}
	}
	
	public int size() {
		return size(root);
	}
	
	public int size(Node node) {
		if (node == null) {
			return 0;
		}
		
		return node.N;
	}
	
	public void put(Key key, Value value) {
		root = put(root, key, value);
	}
	
	private Node put(Node node, Key key, Value value) {
		
		if (node == null) {
			return new Node(key, value, 1);
		}
		
		int cmp = key.compareTo(node.key);
		
		if (cmp < 0) {
			node.left = put(node.left, key, value);
		} else if (cmp > 0) {
			node.right = put(node.right, key, value);
		} else {
			node.value = value;
		}
		
		node.N = size(node.left) + size(node.right) + 1;
		
		return node;
	}
	
	public Value get(Key key) {
		return get(root, key);
	}
	
	private Value get(Node node, Key key) {

		if (node == null) {
			return null;
		}
		
		int cmp = key.compareTo(node.key);
		
		if (cmp < 0) {
			return get(node.left, key);
		} else if (cmp > 0) {
			return get(node.right, key);
		} else {
			return node.value;
		}
	}
	
	public Key min() {
		return min(root).key;
	}
	
	private Node min(Node node) {
		
		if (node == null) {
			return null;
		}
		
		if (node.left == null) {
			return node;
		} else {
			return min(node.left);
		}
	}
	
	public Key floor(Key key) {
		
		Node x = floor(root, key);
		
		if (x == null) {
			return null;
		} else {
			return x.key;
		}
		
	}
	
	private Node floor(Node node, Key key) {
		if (node == null) {
			return null;
		}
		
		int cmp = key.compareTo(node.key);
		
		if (cmp < 0) {
			return floor(node.left, key);
		} else if (cmp == 0) {
			return node;
		}
		
		Node t = floor(node.right, key);
		
		if (t != null) {
			return t;
		} else {
			return node;
		}
		
	}
	
	
	public int rank(Key key) {
		return rank(root, key);
	}
	
	private int rank(Node node, Key key) {
		if (node == null) {
			return 0;
		}
		
		int cmp = key.compareTo(node.key);
		
		if (cmp < 0) {
			return rank(node.left, key);
		} else if (cmp > 0) {
			return size(node.left)+1+rank(node.right, key);
		} else {
			return size(node.left);
		}
	}
	
	public Key select(int k) {
		
		Node x = select(root, k);
		
		if (x == null) {
			return null;
		} else {
			return x.key;
		}
		
	}
	
	private Node select(Node node, int k) {
		if (node == null) {
			return null;
		}
		
		int t = size(node.left);
		
		if (k < t) {
			return select(node.left, k);
		} else if (k > t) {
			return select(node.right, k-t-1);
		} else {
			return node;
		}
	}
}
