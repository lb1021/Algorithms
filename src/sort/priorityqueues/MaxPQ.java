package sort.priorityqueues;


public abstract class MaxPQ<Key extends Comparable<Key>> {
	public MaxPQ() {
	}
	public MaxPQ(int max) {
	}
	public MaxPQ(Key[] a) {
	}
	
	public abstract void insert(Key v);
	public abstract Key max();
	public abstract Key delMax();
	public abstract boolean isEmpty();
	public abstract int size();
}
