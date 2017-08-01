package linklist;

import java.util.Iterator;

public class Queue<Item> implements Iterable<Item> {

	private Node<Item> first;
	private Node<Item> last;
	private int n;
	
	public Queue() {
		first = null;
		last = null;
		n = 0;
	}
	
	
	public void enqueue(Item item) {
		Node<Item> oldLast = last;
		last = new Node<Item>();
		last.item = item;
		last.next = null;
		
		if (isEmpty()) {
			first = last;
		} else {
			oldLast.next = last;
		}
		n++;
	}
	
	public Item dequeue() {
		Item item = first.item;
		first = first.next;
		if (isEmpty()) {
			last = null;
		}
		n--;
		return item;
	}
	
	public boolean isEmpty() {
		return first == null;
	}
	
	private static class Node<Item> {
		private Item item;
		private Node<Item> next;
	}


	@Override
	public Iterator<Item> iterator() {
		return new QueueIterator<Item>(first);
	}
	
	private class QueueIterator<Item> implements Iterator<Item>{

		private Node<Item> current;
		
		public QueueIterator(Node<Item> first) {
			current = first;
		}
		
		@Override
		public boolean hasNext() {
			return current != null;
		}

		@Override
		public Item next() {
			Item item = current.item;
			current = current.next;
			return item;
		}

		@Override
		public void remove() {
			throw new UnsupportedOperationException();
		}
		
	}
}
