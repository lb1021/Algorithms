package sort;

public class Selection {
	
	private static boolean less(Comparable a, Comparable b) {
		return a.compareTo(b) < 0;
	}
	
	private static void exchange(Comparable[] a, int i, int j) {
		Comparable t = a[i];
		a[i] = a[j];
		a[j] = t;
	}
	
	public static void sort(Comparable[] a) {
		int length = a.length;
		
		for (int i=0; i<length; i++) {
			int min = i;
			for (int j=i+1; j<length; j++) {
				if (less(a[j], a[min]))
					min = j;
			}
			exchange(a, i, min);
		}
	}
}
