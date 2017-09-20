package searching;

import java.util.NoSuchElementException;

import linklist.Queue;
import search.BinarySearch;

public class BinarySearchST<Key extends Comparable<Key>, Value> {

	private static final int INIT_CAPACITY = 2;
	private Key[] keys;
	private Value[] values;
	private int n = 0;

	public BinarySearchST() {
		this(INIT_CAPACITY);
	}

	public BinarySearchST(int max) {
		keys = (Key[]) new Comparable[max];
		values = (Value[]) new Object[max];
	}

	private void resize(int capacity) {
		assert capacity >= n;
		Key[] tempk = (Key[]) new Comparable[capacity];
		Value[] tempv = (Value[]) new Object[capacity];
		for (int i = 0; i < n; i++) {
			tempk[i] = keys[i];
			tempv[i] = values[i];
		}
		values = tempv;
		keys = tempk;
	}

	public int size() {
		return n;
	}

	public boolean isEmpty() {
		return size() == 0;
	}

	public boolean contains(Key key) {

		if (key == null) {
			throw new IllegalArgumentException("argument to contains() is null");
		}

		return get(key) != null;
	}

	public void put(Key key, Value value) {

		if (key == null) {
			throw new IllegalArgumentException("first argument to put() is null");
		}

		if (value == null) {
			delete(key);
			return;
		}

		int i = rank(key);

		if (i < n && keys[i].compareTo(key) == 0) {
			values[i] = value;
			return;
		}

		if (n == keys.length) {
			resize(2 * keys.length);
		}

		for (int j = n; j > i; j--) {
			keys[j] = keys[j - 1];
			values[j] = values[j - 1];
		}
		keys[i] = key;
		values[i] = value;
		n++;
		
		assert check();
	}

	public Value get(Key key) {
		if (key == null) {
			throw new IllegalArgumentException("argument to get() is null");
		}
		if (isEmpty())
			return null;
		int i = rank(key);

		if (i < n && keys[i].compareTo(key) == 0) {
			return values[i];
		}

		return null;
	}

	public int rank(Key key) {
		if (key == null) {
			throw new IllegalArgumentException("argument to rank() is null");
		}

		return rank(key, 0, n - 1);
	}

	private int rank(Key key, int lo, int hi) {
		if (hi < lo) {
			return lo;
		}

		int mid = lo + (hi - lo) / 2;
		int cmp = key.compareTo(keys[mid]);

		if (cmp > 0) {
			return rank(key, mid + 1, hi);
		} else if (cmp < 0) {
			return rank(key, lo, mid - 1);
		} else {
			return mid;
		}
	}

	public void delete(Key key) {

		if (key == null) {
			throw new IllegalArgumentException("argument to delete() is null");
		}

		if (isEmpty()) {
			return;
		}

		int i = rank(key);

		if (i == n || keys[i].compareTo(key) != 0) {
			return;
		}

		for (int j = i; j < n - 1; j++) {
			keys[j] = keys[j + 1];
			values[j] = values[j + 1];
		}
		n--;
		keys[n] = null;
		values[n] = null;

		if (n > 0 && n == keys.length / 4) {
			resize(keys.length / 2);
		}

		assert check();
	}

	public Key min() {

		if (isEmpty()) {
			throw new NoSuchElementException("called min() with empty symbol table");
		}

		return keys[0];
	}

	public void deleteMin() {
		if (isEmpty()) {
			throw new NoSuchElementException("Symbol table underflow error");
		}
		delete(min());
	}

	public Key max() {

		if (isEmpty()) {
			throw new NoSuchElementException("called max() with empty symbol table");
		}

		return keys[n - 1];
	}

	public void deleteMax() {
		if (isEmpty()) {
			throw new NoSuchElementException("Symbol table underflow error");
		}
		delete(max());
	}

	public Key select(int k) {
		if (k < 0 || k >= size()) {
			throw new IllegalArgumentException("called select() with invalid argument: " + k);
		}
		return keys[k];
	}

	public Key floor(Key key) {
		if (key == null) {
			throw new IllegalArgumentException("argument to floor() is null");
		}

		int i = rank(key);

		if (i < n && keys[i].compareTo(key) == 0) {
			return keys[i];
		}

		if (i == 0) {
			return null;
		} else {
			return keys[i - 1];
		}
	}

	public Key ceiling(Key key) {
		if (key == null) {
			throw new IllegalArgumentException("argument to ceiling() is null");
		}
		
		int i = rank(key);
	
		if (i==n) {
			return null;
		} else {
			return keys[i];
		}
	}
	
	public int size(Key lo, Key hi) {
		
		if (lo == null) {
			throw new IllegalArgumentException("first argument to size() is null"); 
		}
        if (hi == null) {
        	throw new IllegalArgumentException("second argument to size() is null"); 
        }

		if (lo.compareTo(hi) > 0) {
			return 0;
		}
		
		if (contains(hi)) {
			return rank(hi)-rank(lo)+1;
		} else {
			return rank(hi)-rank(lo);
		}
	}
	
	public Iterable<Key> keys() {
		return keys(min(), max());
	}
	
	public Iterable<Key> keys(Key lo, Key hi) {
		
		if (lo == null) {
			throw new IllegalArgumentException("first argument to keys() is null"); 
		}
        if (hi == null) {
        	throw new IllegalArgumentException("second argument to keys() is null"); 
        }
		
		Queue<Key> queue = new Queue<Key>();
		if (lo.compareTo(hi) > 0) {
			return queue;
		}
		for (int i=rank(lo); i<rank(hi); i++) {
			queue.enqueue(keys[i]);
		}
		
		if (contains(hi)) {
			queue.enqueue(hi);
		}
		
		return queue;
	}
	
	private boolean check() {
		return isSort() && rankCheck();
	}
	
	private boolean isSort() {
		for (int i=1; i<size(); i++) {
			if (keys[i].compareTo(keys[i-1])<0) {
				return false;
			}
		}
		
		return true;
	}
	
	private boolean rankCheck() {
		for (int i=0; i<size(); i++) {
			if (i != rank(select(i))) {
				return false;
			}
		}
		
		for (int i=0; i<size(); i++) {
			if (keys[i].compareTo(select(rank(keys[i]))) != 0) {
				return false;
			}
		}
		
		return true;
	}
}
