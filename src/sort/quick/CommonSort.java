package sort.quick;

class CommonSort {
	static boolean less(Comparable a, Comparable b) {
		return a.compareTo(b) < 0;
	}
	
	static void exchange(Comparable[] source, int i, int j) {
		Comparable temp = source[i];
		source[i] = source[j];
		source[j] = temp;
	}
	
	static boolean isSorted(Comparable[] a) {
		for (int i=1; i<a.length; i++) {
			if (less(i, i-1)) {
				return false;
			}
		}
		return true;
	}
}
