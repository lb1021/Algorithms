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
}
