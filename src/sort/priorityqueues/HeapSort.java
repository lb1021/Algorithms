package sort.priorityqueues;

public class HeapSort {
	
	public void sort(Comparable[] source) {
		
		int n = source.length;
		
		for (int k=n/2; k>=1; k--) {
			sink(source, k, n);
		}
		
		while (n > 1) {
			exchange(source, 1, n--);
			sink(source, 1, n);
		}
	}
	
	
	private void sink(Comparable[] source, int k, int n) {

		while (k*2 <= n) {
			int j = k*2;
			
			if (j<n && less(j, j+1))
				j++;
			
			if (!less(k, j))
				break;
			exchange(source, k, j);
			k = j;
		}
	}
	
	private void exchange(Comparable[] source, int i, int j) {
		Comparable temp = source[i];
		source[i] = source[j];
		source[j] = temp;
	}
	
	private boolean less(Comparable a, Comparable b) {
		return a.compareTo(b) < 0;
	}
}
