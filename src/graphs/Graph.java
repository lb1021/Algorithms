package graphs;

import edu.princeton.cs.algs4.In;
import sun.net.www.content.image.gif;

public abstract class Graph {

	public Graph(int v) {
		// TODO Auto-generated constructor stub
	}

	public Graph(In in) {

	}

	abstract int v();

	abstract int e();

	abstract void addEdge(int v, int w);

	abstract Iterable<Integer> adj(int v);

	public static int degree(Graph G, int v) {
		int degree = 0;

		for (int w : G.adj(v)) {
			degree++;
		}

		return degree;
	}

	public static int maxDegree(Graph G) {

		int max = 0;

		for (int v = 0; v < G.v(); v++) {
			if (degree(G, v) > max) {
				max = degree(G, v);
			}
		}

		return max;
	}

	public static int avgDegree(Graph G) {
		return 2 * G.e() / G.v();
	}

	public static int numberOfSelfLoops(Graph G) {
		int count = 0;

		for (int v = 0; v < G.v(); v++) {
			for (int w : G.adj(v)) {
				if (w == v) {
					count++;
				}
			}
		}

		return count / 2;
	}

	public String toString() {

		int V = v();
		int E = e();

		String s = V + " vertices," + E + " edges\n";
		for (int v = 0; v < V; v++) {
			s += v + ": ";
			for (int w : this.adj(v)) {
				s += w + " ";
			}
			s += "\n";
		}

		return s;
	}
}
