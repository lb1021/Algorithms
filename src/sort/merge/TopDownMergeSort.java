package sort.merge;

public class TopDownMergeSort extends InPlaceMergeSort {

	public void sort(Comparable[] a) {
		sort(a, 0, a.length-1);
	}
	
	public void sort(Comparable[] a, int lo, int hi) {
		if (lo >= hi) {
			return ;
		}
		
		int mid = lo+(hi-lo)/2;
		
		sort(a, lo, mid);
		sort(a, mid+1, hi);
		merge(a, lo, mid, hi);
	}
	
}
