package sort.merge;


public class InPlaceMergeSort extends CommonSort {
	public void sort (Comparable[] a, int lo, int mid, int hi) {
		
		Comparable[] auxiliary = new Comparable[a.length];
		
		for (int k=lo; k<=hi; k++) {
			auxiliary[k] = a[k];
		}
		
		int i = lo;
		int j = mid+1;
		
		for (int k=lo; k<=hi; k++) {
			if (i > mid) {
				a[k] = auxiliary[j++];
			} else if (j > hi) {
				a[k] = auxiliary[i++];
			} else if (less(auxiliary[i], auxiliary[j])) {
				a[k] = auxiliary[i++];
			} else {
				a[k] = auxiliary[j++];
			}
		}
		
	}
}
