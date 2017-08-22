package sort.quick;

public class Quick extends CommonSort {

	
	public static void sort(Comparable[] a, int lo, int hi) {
		
		if (lo >= hi) {
			return;
		}
		
		int j= partition(a, lo, hi);
		
		sort(a, lo, j-1);
		sort(a, j+1, hi);
	}
	
	private static int partition(Comparable[] a, int lo, int hi) {
		
		int i = lo;
		int j = hi+1;
		
		Comparable v = a[lo];
		
		while (true) {
			
			while (less(a[++i], v)) {
				if (i == hi) {
					break;
				}
			}
			
			while (less(v, a[--j])) {
				if (i == lo) {
					break;
				}
			}
			
			if (i >= j) {
				break;
			}
			
			exchange(a, i, j);
		}
		
		exchange(a, lo, j);
		return j;
	}
}
