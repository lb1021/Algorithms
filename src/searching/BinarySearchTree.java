package searching;

import java.util.Iterator;

import linklist.Queue;


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
		
		if (node.left == null) {
			return node;
		} 
		
		return min(node.left);
	}
	
	public Key max() {
		return max(root).key;
	}
	
	private Node max(Node node) {
		
		if (node.right == null) {
			return node;
		} 
		
		return min(node.right);
	}
	
	public Key floor(Key key) {
		
		Node x = floor(root, key);
		
		if (x == null) {
			return null;
		} 

		return x.key;
		
	}
	
	private Node floor(Node node, Key key) {
		if (node == null) {
			return null;
		}
		
		int cmp = key.compareTo(node.key);
		
		if (cmp == 0) {
			return node;
		}
		
		if (cmp < 0) {
			return floor(node.left, key);
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
		return select(root, k).key;
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
	
	public void deleteMin() {
		root = deleteMin(root);
	}
	
	private Node deleteMin(Node node) {
		
		if (node.left == null) {
			return node.right;
		}
		
		node.left = deleteMin(node.left);
		node.N = size(node.left)+size(node.right)+1;
		return node;
	}
	
	public void delete(Key key) {
		root = delete(root, key);
	}
	
	private Node delete(Node node, Key key) {
		if (node == null) {
			return null;
		}
		
		int cmp = key.compareTo(node.key);
		
		if (cmp < 0) {
			node.left = delete(node.left, key);
		} else if (cmp > 0) {
			node.right = delete(node.right, key);
		} else {
			if (node.left == null) {
				return node.right;
			} 
			if (node.right == null) {
				return node.left;
			} 

			Node deleteNode = node;
			node = min(deleteNode.right);
			node.right = deleteMin(deleteNode.right);
			node.left = deleteNode.left;
			
		}
		
		node.N = size(node.left)+size(node.right)+1;
		
		return node;
	}
	
	public Iterable<Key> keys() {
		return keys(min(), max());
	}
	
	public Iterable<Key> keys(Key lo, Key hi) {
		
		Queue<Key> queue = new Queue<Key>();
		keys(root, queue, lo, hi);
		return queue;
	}
	
	private void keys(Node node, Queue<Key> queue, Key lo, Key hi) {
		if (node == null) {
			return;
		}
		
		int cmplo = lo.compareTo(node.key);
		int cmphi = hi.compareTo(node.key);
		
		if (cmplo < 0) {
			keys(node.left, queue, lo, hi);
		}
		
		if (cmplo<=0 && cmphi>=0) {
			queue.enqueue(node.key);
		}
		
		if (cmphi > 0) {
			keys(node.right, queue, lo, hi);
		}
	}
}
