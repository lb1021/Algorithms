package sort.quick;

public class Quick3Way extends CommonSort {

	public void sort(Comparable[] a, int lo, int hi) {
		if (lo >= hi) {
			return;
		}
		
		int lt = lo;
		int gt = hi;
		int i = lo+1;
		
		Comparable v = a[lo];
		
		while (i <= gt) {
			
			int cmp = a[i].compareTo(v);
			
			if (cmp < 0) {
				exchange(a, lt++, i++);
			} else if (cmp > 0) {
				exchange(a, i, gt--);
			} else {
				i++;
			}
		}
		
		sort(a, lo, lt-1);
		sort(a, gt+1, hi);
	}
}
