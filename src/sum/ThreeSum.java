package sum;

import java.util.Arrays;

import search.BinarySearch;

public class ThreeSum {
	
	public int findAll(int[] source) {
		
		Arrays.sort(source);
		
		int count = 0;
		
		for (int i=0; i<source.length; i++) {
			for (int j=i+1; j<source.length; j++) {
				if (BinarySearch.whileSearch(source, -source[i]-source[j]) > j) {
					count++;
				}
			}
		}
		
		return count;
	}
}
