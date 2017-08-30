package sort.priorityqueues;

public class MaxPQHeapSort<Key extends Comparable> {

	private Key[] pq;
	
	private int n;
	
	public MaxPQHeapSort(int max) {
		pq = (Key[])new Comparable[max+1];
		n = 0;
	}
	
	public void insert(Key v) {
		pq[++n] = v;
		swim(n);
	}
	
	public Key max() {
		return pq[1];
	}
	
	public Key delMax() {
		Key max = pq[1];
		
		exchange(1, n--);
		sink(1);
		pq[n+1] = null;
		
		return max;
	}
	
	public boolean isEmpty() {
		return n == 0;
	}
	
	public int size() {
		return n;
	}
	
	private void swim(int k) {
		
		while (k>1 && less(k/2, k)) {
			exchange(k, k/2);
			k = k/2;
		}
	}
	
	private void sink(int k) {

		while (k*2 <= n) {
			int j = k*2;
			
			if (j<n && less(j, j+1))
				j++;
			
			if (!less(k, j))
				break;
			exchange(k, j);
			k = j;
		}
	}
	
	private boolean less(Comparable a, Comparable b) {
		return a.compareTo(b) < 0;
	}
	
	private void exchange(int i, int j) {
		Key temp = pq[i];
		pq[i] = pq[j];
		pq[j] = temp;
	}
}
