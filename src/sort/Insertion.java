package sort;

public class Insertion extends CommonSort {

	@Override
	public void sort(Comparable[] source) {
		
		int length = source.length;
		
		for (int i=1; i<length; i++) {
			for (int j=i; j>0 && less(source[j], source[j-1]); j--) {
				exchange(source, j, j-1);
			}
		}
	}

}
