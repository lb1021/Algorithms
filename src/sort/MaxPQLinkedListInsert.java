package sort;

public class MaxPQLinkedListInsert<Key extends Comparable> {
	
	private Node<Key> first;
	private int n;
	
	public MaxPQLinkedListInsert() {
		this(0);
	}
	public MaxPQLinkedListInsert(int max) {
		first = null;
		n = max;
	}
	public MaxPQLinkedListInsert(Key[] a) {
		first = null;
		for (Key item : a) {
			insert(item);
		}
		n = a.length;
	}
	
	
	public void insert(Key v) {
		Node<Key> previous = null;
		Node<Key> current = first;
		
		n++;
		
		if (current == null) {
			Node<Key> node = new Node<Key>();
			node.item = v;
			first = node;
			node.next = null;
			return ;
		}
		
		while (current != null) {
			if (current.item.compareTo(v) < 0) {
				Node<Key> node = new Node<Key>();
				node.item = v;
				node.next = current;
				
				if (previous == null) {
					first = node;
				} else {
					previous.next = node;
				}
				return ;
			}
			
			previous = current;
			current = current.next;
		}
	}
	
	public Key max() {
		
		if (isEmpty())
			return null;
		
		return first.item;
	}
	
	public Key delMax() {
		
		if (isEmpty())
			return null;
		
		n--;
		
		Key max = first.item;
		first = first.next;
		
		return max;
	}
	public boolean isEmpty() {
		return n == 0;
	}
	
	public int size() {
		return n;
	}
	private static class Node<Key> {
		Key item;
		Node<Key> next;
	}
	
}

