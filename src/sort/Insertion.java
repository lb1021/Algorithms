package sort;

public class Insertion extends CommonSort {

	@Override
	public void sort(Comparable[] source) {

		int length = source.length;

		for (int i = 1; i < length; i++) {
			for (int j = i; j > 0 && less(source[j], source[j - 1]); j--) {
				exchange(source, j, j - 1);
			}
		}
	}

	public static void sort(String[] a, int lo, int hi, int d) {

		for (int i = lo; i <= hi; i++) {
			for (int j = i; j > lo && less(a[j], a[j - 1], d); j--) {
				exchange(a, j, j - 1);
			}
		}
	}

	public static boolean less(String v, String w, int d) {
		return v.substring(d).compareTo(w.substring(d)) < 0;
	}

}
