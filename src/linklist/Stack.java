package linklist;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class Stack<Item> implements Iterable<Item> {

	private Node<Item> first;
	private int n;
	
	public Stack() {
		first = null;
		n = 0;
	}
	
	public void push(Item item) {
		Node<Item> oldFirst = first;
		Node<Item> first = new Node<Item>();
		first.item = item;
		first.next = oldFirst;
		n++;
	}
	
	public Item pop() {
		if (isEmpty()) throw new NoSuchElementException();
		Item item = first.item;
		first = first.next;
		n--;
		return item;
	}
	
	public boolean isEmpty() {
		return first == null;
	}
	
	@Override
	public Iterator<Item> iterator() {
		return new StackIterator<Item>(first);
	}
	
	private class StackIterator<Item> implements Iterator<Item> {

		private Node<Item> current;
		
		public StackIterator(Node<Item> first) {
			current = first;
		}
		
		@Override
		public boolean hasNext() {
			return current != null;
		}

		@Override
		public Item next() {
			if (!hasNext()) throw new NoSuchElementException();
			Item item = current.item;
			current = current.next;
			return item;
		}

		@Override
		public void remove() {
			throw new UnsupportedOperationException();
		}
		
	}
	
	private static class Node<Item> {
		private Item item;
		private Node<Item> next;
	}
}

