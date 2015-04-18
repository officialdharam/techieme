package com.test.bellman;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class BellmanFord {
	List<Vertex> graph = new ArrayList<Vertex>();

	public static void main(String[] args) {
		BellmanFord bellmanFord = new BellmanFord();
		List<Vertex> graph = bellmanFord.createGraph();

		List<Edge> edges = new ArrayList<Edge>();

		for (Vertex v : graph) {
			edges.addAll(v.getIncidentEdges());
		}

		boolean negativeCycle = bellmanFord.shortestPath(graph.get(0), edges, graph.size());
		Set<Vertex> tempGraph = new HashSet<Vertex>();
		if (!negativeCycle) {
			for (Edge e : edges) {
				tempGraph.add(e.end);
			}

			for (Vertex v : tempGraph) {
				System.out.println(v.previous.vertexName +  ":" + v.vertexName +" = " + v.min);
			}
		} else {
			System.out.println("The graph contains negative cycles.");
		}
	}

	public boolean shortestPath(Vertex source, List<Edge> edges, int vertexCount) {
		source.min = 0;

		for (int i = 0; i < vertexCount; i++) {
			for (Edge e : edges) {
				int edgeWeight = e.weight;
				int sourceMin = e.start.min;
				int currentMin = e.end.min;
				int tempDistance = edgeWeight + sourceMin;
				if (tempDistance < currentMin) {
					e.end.min = tempDistance;
					e.end.previous = e.start;
				}
			}
		}

		boolean negativeCycle = false;
		for (Edge e : edges) {
			int edgeWeight = e.weight;
			int sourceMin = e.start.min;
			int currentMin = e.end.min;
			int tempDistance = edgeWeight + sourceMin;
			if (tempDistance < currentMin) {
				negativeCycle = true;
				break;
			}
		}

		return negativeCycle;
	}

	private List<Vertex> createGraph() {
		Vertex v1 = new Vertex(1);
		Vertex v2 = new Vertex(2);
		Vertex v3 = new Vertex(3);
		Vertex v4 = new Vertex(4);
		Vertex v5 = new Vertex(5);
		Vertex v6 = new Vertex(6);
		Vertex v7 = new Vertex(7);
		Vertex v8 = new Vertex(8);

		List<Edge> edges = new ArrayList<Edge>();
		edges.add(new Edge(v1, v2, 8));
		edges.add(new Edge(v1, v5, 6));
		v1.incidentEdges = edges;

		edges = new ArrayList<Edge>();
		edges.add(new Edge(v2, v3, 6));
		v2.incidentEdges = edges;

		edges = new ArrayList<Edge>();
		edges.add(new Edge(v3, v8, 4));
		v3.incidentEdges = edges;

		edges = new ArrayList<Edge>();
		edges.add(new Edge(v4, v2, 2));
		v4.incidentEdges = edges;

		edges = new ArrayList<Edge>();
		edges.add(new Edge(v5, v6, 3));
		edges.add(new Edge(v5, v7, 2));
		v5.incidentEdges = edges;

		edges = new ArrayList<Edge>();
		edges.add(new Edge(v6, v7, 6));
		v6.incidentEdges = edges;

		edges = new ArrayList<Edge>();
		edges.add(new Edge(v7, v3, -1));
		edges.add(new Edge(v7, v4, 1));
		v7.incidentEdges = edges;

		edges = new ArrayList<Edge>();
		edges.add(new Edge(v8, v7, -2));
		v8.incidentEdges = edges;

		graph.add(v1);
		graph.add(v2);
		graph.add(v3);
		graph.add(v4);
		graph.add(v5);
		graph.add(v6);
		graph.add(v7);
		graph.add(v8);

		return graph;

	}
}

class Vertex implements Comparable<Vertex> {
	public int vertexName;
	public List<Edge> incidentEdges;
	public int min = Integer.MAX_VALUE - 10000;
	public Vertex previous;

	public Vertex(int vertexName) {
		this.vertexName = vertexName;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + vertexName;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Vertex other = (Vertex) obj;
		if (vertexName != other.vertexName)
			return false;
		return true;
	}

	public int getVertexName() {
		return vertexName;
	}

	public void setVertexName(int vertexName) {
		this.vertexName = vertexName;
	}

	public List<Edge> getIncidentEdges() {
		return incidentEdges;
	}

	public void setIncidentEdges(List<Edge> incidentEdges) {
		this.incidentEdges = incidentEdges;
	}

	public int getMin() {
		return min;
	}

	public void setMin(int min) {
		this.min = min;
	}

	public Vertex getPrevious() {
		return previous;
	}

	public void setPrevious(Vertex previous) {
		this.previous = previous;
	}

	public int compareTo(Vertex o) {
		return Integer.compare(min, o.min);
	}

	@Override
	public String toString() {
		return "Vertex [vertexName=" + vertexName + ", min=" + min +"]";
	}
}

class Edge {
	public Vertex end;
	public int weight;
	public Vertex start;

	@Override
	public String toString() {
		return "Edge [start=" + start + ", end=" + end + ", weight=" + weight + "]";
	}

	public Edge(Vertex start, Vertex end, int weight) {
		this.start = start;
		this.end = end;
		this.weight = weight;
	}
}
