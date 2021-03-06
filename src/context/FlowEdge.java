package context;

public class FlowEdge {

	private final int v;
	private final int w;
	private final double capacity;
	private double flow;

	public FlowEdge(int v, int w, int capacity) {
		this.v = v;
		this.w = w;
		this.capacity = capacity;
		this.flow = 0.0;
	}

	public int from() {
		return v;
	}

	public int to() {
		return w;
	}

	public int other(int vertex) {
		if (vertex == v)
			return w;
		else if (vertex == w)
			return v;
		else
			throw new IllegalArgumentException("Illegal endpoint");
	}

	public double capacity() {
		return capacity;
	}

	public double flow() {
		return flow;
	}

	public double residualCapacityTo(int vertex) {
		if (vertex == v) {
			return flow;
		} else if (vertex == w) {
			return capacity - flow;
		} else {
			throw new RuntimeException("Inconsistent edge");
		}
	}

	public void addResidualFlowTo(int vertex, double delta) {
		if (vertex == v) {
			flow -= delta;
		} else if (vertex == w) {
			flow += delta;
		} else {
			throw new RuntimeException("Inconsistent edge");
		}
	}
	
    public String toString() {
        return v + "->" + w + " " + flow + "/" + capacity;
    }
}
