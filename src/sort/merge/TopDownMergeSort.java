package sort.merge;

public class TopDownMergeSort extends InPlaceMergeSort {

	public void sort(Comparable[] a) {
		Comparable[] auxiliary = new Comparable[a.length];
		sort(a, auxiliary, 0, a.length-1);
	}
	
	public void sort(Comparable[] a, Comparable[] auxiliary, int lo, int hi) {
		if (lo >= hi) {
			return ;
		}
		
		int mid = lo+(hi-lo)/2;
		
		sort(a, auxiliary, lo, mid);
		sort(a, auxiliary, mid+1, hi);
		merge(a, auxiliary, lo, mid, hi);
	}
	
}
