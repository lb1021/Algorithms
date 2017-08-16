package sort;

public class Shell extends CommonSort {

	@Override
	public void sort(Comparable[] source) {

		int length = source.length;
		int h = 1;
		
		while (h < length/3)
			h = h*3+1;
		
		while (h >= 1) {
			for (int i=h; i<length; i++) {
				for (int j=i; j>=h && less(j, j-h); j-=h) {
					exchange(source, j, j-h);
				}
			}
			
			h = h/3;
		}
	}

}
