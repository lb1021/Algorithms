package sort.priorityqueues;

public class MaxPQUnorderArray<Key extends Comparable<Key>> extends MaxPQ<Key> {
	
	private Key[] base;
	private int n;
	
	public MaxPQUnorderArray() {
		this(16);
	}
	
	public MaxPQUnorderArray(int max) {
		base = (Key[])new Object[max];
		n = 0;
	}
	
	public MaxPQUnorderArray(Key[] a) {
		base = a;
		n = 0;
	}

	@Override
	public void insert(Key v) {
		if (n == base.length) {
			resize(2*base.length);
		}
		base[n++] = v;
	}

	@Override
	public Key max() {
		
		Key max = base[n-1];
		
		for (int i=0; i<n-1; i++) {
			if (base[i].compareTo(max) > 0) {
				Key temp = max;
				max = base[i];
				base[i] = temp;
			}
		}
		return max;
	}

	@Override
	public Key delMax() {
		Key max = max();
		n--;
		if (n>0 && n < base.length/4) {
			resize(base.length/2);
		}
		return max;
	}

	@Override
	public boolean isEmpty() {
		return size()==0;
	}

	@Override
	public int size() {
		return n;
	}

	private void resize(int max) {
		Key[] temp = (Key[])new Object[max];
		for (int i=0; i<n; i++) {
			temp[i] = base[i];
		}
		base = temp;
	}
	
}
