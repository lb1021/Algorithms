package unionfind;

public class WeightedQuickFindPathCompression {
	private int[] id;
	private int[] sz;
	private int count;
	
	public WeightedQuickFindPathCompression(int N) {
		count = N;
		id = new int[N];
		sz = new int[N];
		for (int i=0; i<N; i++) {
			id[i] = i;
			sz[i] = 1;
		}
	}

	public boolean connected(int p, int q) {
		return id[p] == id[q];
	}
	
	public int find(int p) {
		
		int root = p;
		while (root != id[root])
			root = id[root];
		
		while (p != root) {
			int newp = id[p];
			id[p] = root;
			p = newp;
		}
		
		return root;
	}
	
	public void union(int p, int q) {
		int rootP = find(p);
		int rootQ = find(q);
		
		if (rootP == rootQ)
			return;
		
		if (sz[rootP] < sz[rootQ]) {
			id[rootP] = rootQ;
			sz[rootQ] += sz[rootP];
		} else {
			id[rootQ] = rootP;
			sz[rootP] += sz[rootQ];
		}
		
		count--;
		
	}
}

