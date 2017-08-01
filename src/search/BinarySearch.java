package search;

public class BinarySearch {
	
	public static int whileSearch(int[] source, int target) {
		
		int left = 0;
		int right = source.length-1;
		
		while (left <= right) {
			int middle = left + (right-left)/2;
			if (source[middle] < target) {
				left = middle+1;
			} else if (source[middle] > target) {
				right = middle-1;
			} else {
				return middle;
			}
		}
		
		return -1;
	}
	
	public int recursionSearch(int[] source, int target, int left, int right) {
	
		if (left > right)
			return -1;
		int middle = left + (right-left)/2;
		if (source[middle] > target) {
			return recursionSearch(source, target, left, middle-1);
		} else if (source[middle] < target) {
			return recursionSearch(source, target, middle+1, right);
		} else {
			return middle;
		}
		
	}
	
	
	public static void main(String[] args) {
		
		int[] source = {1,2,3,4,5,6,7,8,9};
		int location = new BinarySearch().recursionSearch(source, 6, 0, source.length-1);
		
		System.out.println(location);
	}
}
