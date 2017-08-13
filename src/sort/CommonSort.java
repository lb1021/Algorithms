package sort;

abstract class CommonSort implements Sortable {
	static boolean less(Comparable a, Comparable b) {
		return a.compareTo(b) < 0;
	}
	
	static void exchange(Comparable[] source, int i, int j) {
		Comparable temp = source[i];
		source[i] = source[j];
		source[j] = temp;
	}
}
