package graphs.shortestpaths;

import edu.princeton.cs.algs4.DirectedEdge;
import edu.princeton.cs.algs4.Edge;
import edu.princeton.cs.algs4.EdgeWeightedDigraph;
import edu.princeton.cs.algs4.EdgeWeightedDirectedCycle;
import edu.princeton.cs.algs4.Queue;

public class BellmanFordSP {
	private double[] distTo;
	private DirectedEdge[] edgeTo;
	private boolean[] onQ;
	private Queue<Integer> queue;
	private int cost;
	private Iterable<DirectedEdge> cycle;
	
	public BellmanFordSP(EdgeWeightedDigraph G, int s) {
		distTo = new double[G.V()];
		edgeTo = new DirectedEdge[G.V()];
		onQ = new boolean[G.V()];
		queue = new Queue<Integer>();
		
		for (int v=0; v<G.V(); v++) {
			distTo[v] = Double.POSITIVE_INFINITY;
		}
		distTo[s] = 0.0;
		queue.enqueue(s);
		onQ[s] = true;
		while (!queue.isEmpty() && !this.hasNegativeCycle()) {
			int v = queue.dequeue();
			onQ[v] = false;
			relax(G, v);
		}
	}
	
	private void relax(EdgeWeightedDigraph G, int v) {
		
		for (DirectedEdge e : G.adj(v)) {
			int w = e.to();
			
			if (distTo[w] > distTo[v] + e.weight()) {
				distTo[w] = distTo[v] + e.weight();
				edgeTo[w] = e;
				
				if (!onQ[w]) {
					queue.enqueue(w);
					onQ[w] = true;
				}
			}
			
			if (cost++ % G.V() == 0) {
				findNegativeCycle();
			}
		}
	}
	
	private void findNegativeCycle() {
		int V = edgeTo.length;
		EdgeWeightedDigraph spt;
		spt = new EdgeWeightedDigraph(V);
		
		for (int v=0; v<V; v++) {
			if (edgeTo[v] != null) {
				spt.addEdge(edgeTo[v]);
			}
		}
		
/*		EdgeWeightCycleFinder cf;
		cf = new EdgeWeightCycleFinder(spt);
		cycle = cf.cycle();*/
	}
	
	public boolean hasNegativeCycle() {
		return cycle != null;
	}
	
/*	public Iterable<Edge> negativeCycle() {
		return cycle;
	}*/
}
