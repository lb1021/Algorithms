package graphs.shortestpaths;

import edu.princeton.cs.algs4.EdgeWeightedDigraph;
import edu.princeton.cs.algs4.DijkstraSP;
import edu.princeton.cs.algs4.DirectedEdge;

public class DijkstraAllPairsSP {
	private DijkstraSP[] all;

	public DijkstraAllPairsSP(EdgeWeightedDigraph G) {
		all = new DijkstraSP[G.V()];

		for (int v = 0; v < G.V(); v++) {
			all[v] = new DijkstraSP(G, v);
		}
	}

	public Iterable<DirectedEdge> path(int s, int t) {
		return all[s].pathTo(t);
	}

	public double dist(int s, int t) {
		return all[s].distTo(t);
	}
}
