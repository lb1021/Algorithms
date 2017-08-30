package sort.priorityqueues;

public class MaxPQLinkedListDelete<Key extends Comparable> {
	
	private Node<Key> first;
	private int n;
	
	public MaxPQLinkedListDelete() {
		this(0);
	}
	public MaxPQLinkedListDelete(int max) {
		first = null;
		n = max;
	}
	public MaxPQLinkedListDelete(Key[] a) {
		first = null;
		for (Key item : a) {
			insert(item);
		}
		n = a.length;
	}
	
	
	public void insert(Key v) {
		Node<Key> oldFirst = first;
		first = new Node<Key>();
		first.item = v;
		first.next = oldFirst;
		n++;
	}
	
	public Key max() {
		
		if (isEmpty())
			return null;
		
		Key max = first.item;
		
		Node<Key> current = first.next;
		
		Key currentKey = null;
		
		while (current != null) {
			currentKey = current.item;
			if (currentKey.compareTo(max) > 0) {
				max = currentKey;
			}
			current = current.next;
		}
		
		return max;
	}
	
	public Key delMax() {
		
		if (isEmpty())
			return null;
		
		Key max = max();

		Node<Key> previous = null;
		Node<Key> current = first;

		n--;
		
		while (current != null) {
			if (current.item.compareTo(max) == 0) {
				if (previous != null) {
					previous.next = current.next;
				} else {
					first = current.next;
				}
				return max;
			}
			previous = current;
			current = current.next;
		}
		
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

