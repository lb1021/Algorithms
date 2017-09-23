package sort.priorityqueues;

public class MaxPQOrderArray<Key extends Comparable<Key>> extends MaxPQ<Key> {
	
	private Key[] base;
	private int n;
	
	public MaxPQOrderArray() {
		this(16);
	}
	
	public MaxPQOrderArray(int max) {
		base = (Key[])new Object[max];
		n = 0;
	}
	
	public MaxPQOrderArray(Key[] a) {
		base = a;
		n = 0;
	}

	@Override
	public void insert(Key v) {
		if (n == base.length) {
			resize(2*base.length);
		}
		
/*		for (int i=0; i<n; i++) {
			if (v.compareTo(base[i]) < 0) {
				for (int j=n-1; j>=i; j--) {
					base[j+1] = base[j];
				}
				base[i] = v;
				return ;
			}
		}
		base[n++] = v;*/
		
		
		/* Insert Solution */
		base[n++] = v;
		for (int i=n-1; i>0; i--) {
			if (base[i].compareTo(base[i-1]) < 0) {
				Key temp = base[i];
				base[i] = base[i-1];
				base[i-1] = temp;
				continue;
			}
			return;
		}
	}

	@Override
	public Key max() {
		
		return base[n-1];
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
