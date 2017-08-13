package sort;

public class Selection extends CommonSort {

	@Override
	public void sort(Comparable[] source) {
		int length = source.length;
		
		for (int i=0; i<length; i++) {
			int min = i;
			for (int j=i+1; j<length; j++) {
				if (less(source[j], source[min]))
					min = j;
			}
			exchange(source, i, min);
		}
	}

}
