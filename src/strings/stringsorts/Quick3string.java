package strings.stringsorts;

public class Quick3string {
	private static int charAt(String s, int d) {
		if (d < s.length()) {
			return s.charAt(d);
		} else {
			return -1;
		}
	}
	
	public void sort(String[] a) {
		sort(a, 0, a.length-1, 0);
	}
	
	public void sort(String[] a, int lo, int hi, int d) {
		
		if (hi <= lo) {
			return ;
		}
		
		int lt = lo;
		int gt = hi;
		int v = charAt(a[lo],d);
		int i = lo+1;
		
		while (i <= gt) {
			int t = charAt(a[i], d);
			if (t < v) {
				exchange(a, lt++, i++);
			} else if (t > v) {
				exchange(a, i, gt--);
			} else {
				i++;
			}
		}
		
		sort(a, lo, lt-1, d);
		if (v >= 0) {
			sort(a, lt, gt, d+1);
		}
		sort(a, gt+1, hi, d);
	}
	
	private void exchange(Comparable[] source, int i, int j) {
		Comparable temp = source[i];
		source[i] = source[j];
		source[j] = temp;
	}
}
