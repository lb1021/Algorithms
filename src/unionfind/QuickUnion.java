package unionfind;

public class QuickUnion {
	private int[] id;
	private int count;
	
	public QuickUnion(int N) {
		count = N;
		id = new int[N];
		for (int i=0; i<N; i++) {
			id[i] = i;
		}
	}

	public boolean connected(int p, int q) {
		return id[p] == id[q];
	}
	
	public int find(int p) {
		while (p != id[p]) {
			p = id[p];
		}
		return p;
	}
	
	public void union(int p, int q) {
		
		int rootP = find(p);
		int rootQ = find(q);
		
		if (rootP == rootQ)
			return;

		id[rootP] = rootQ;
		
		count--;
	}
}
