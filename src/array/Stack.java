package array;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class Stack<Item> implements Iterable<Item> {

    private Item[] a;
    private int N;

    public Stack(int capacity) {
        a = (Item[])new Object[capacity];
        N = 0;
    }

    public boolean isEmpty() {
        return N == 0;
    }

    public void push(Item item) {
        a[N++] = item;
    }

    public Item pop() {
        return a[--N];
    }

    @Override
    public Iterator<Item> iterator() {
        return new StackIterator();
    }

    private class StackIterator implements Iterator<Item> {

    	private int i = N-1;
    	
        @Override
        public boolean hasNext() {
            return i >= 0;
        }

        @Override
        public Item next() {
        	if (!hasNext()) throw new NoSuchElementException();
            return a[i--];
        }

        @Override
        public void remove() {
        	throw new NoSuchElementException();
        }
    }
    
    
}

