package unionfind;

public class QuickFind {
	
	private int[] id;
	private int count;
	
	public QuickFind(int N) {
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
		return id[p];
	}
	
	public void union(int p, int q) {
		int pID = find(p);
		int qID = find(q);
		
		if (pID == qID) 
			return;
		
		for (int i=0; i<id.length; i++) {
			if (id[i] == qID) {
				id[i] = pID;
			}
		}
		
		count--;
	}
	

}
