package sort.merge;

public class ButtomUpMergeSort extends InPlaceMergeSort {
	
	public void sort(Comparable[] a) {
		
		int n = a.length;
		
		for (int size=1; size<n; size=size+size) {
			for (int lo=0; lo<n-size; lo=lo+size+size) {
				merge(a,lo,lo+size-1,Math.min(lo+size+size-1, n-1));
			}
		}
	}
}
