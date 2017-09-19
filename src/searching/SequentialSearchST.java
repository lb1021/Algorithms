package searching;

import linklist.Queue;

public class SequentialSearchST<Key,Value> {
	
	private Node first;
	private int n;
	
	private class Node {
		
		private Key key;
		private Value value;
		private Node next;
		
		public Node(Key key, Value value, Node next) {
			this.key = key;
			this.value = value;
			this.next = next;
		}
	}
	
	public SequentialSearchST() {
		
	}
	
	public void put(Key key, Value value) {
		
		if (key == null) {
			throw new IllegalArgumentException("first argument to put() is null");
		}
		
		if (value == null) {
			delete(key);
		}
		
		for (Node node=first; node!=null; node = node.next) {
			if (key.equals(node.key)) {
				node.value = value;
				return;
			}
		}
		
		first = new Node(key, value, first);
		n++;
	}
	
	public Value get(Key key) {
		if (key == null) {
			throw new IllegalArgumentException("argument to get() is null");
		}
		for (Node node=first; node!=null; node=node.next) {
			if (key.equals(node.key)) {
				return node.value;
			}
		}
		return null;
	}
	
/*	public void delete(Key key) {
		
		Node previous = null;
		for (Node node=first; node!=null; node=node.next) {
			if (key.equals(node.key)) {
				if (previous == null) {
					first = null;
				} else {
					previous.next = node.next;
				}
				n--;
				return;
			}
			previous = node;
		}
	}*/
	
	public void delete(Key key) {
		if (key == null) {
			throw new IllegalArgumentException("argument to delete() is null"); 
		}
        first = delete(first, key);
	}
	
	// return the first node of the linkedlist, which doesn't contain the key.
	private Node delete(Node node, Key key) {
		if (node == null) {
			return null;
		}
		if (key.equals(node.key)) {
			n--;
			return node.next;
		}
		
		node.next = delete(node.next, key);
		return node;
	}
	
	public Iterable<Key> keys() {
		Queue<Key> queue = new Queue<Key>();
		for (Node node=first; node!=null; node=node.next) {
			queue.enqueue(node.key);
		}
		return queue;
	}
	
	public int size() {
		return n;
	}
	
	public boolean isEmpty() {
		return size()==0;
	}
	
	public boolean contains(Key key) {
		if (key == null) {
			throw new IllegalArgumentException("argument to contains() is null");
		}
		return get(key)!=null;
	}
	
	
}
