package com.test;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class Dijkstra {
	
	List<Vertex> graph = new ArrayList<Vertex>();

	public static void main(String[] args) {
		Dijkstra dijkstra = new Dijkstra();
		List<Vertex> graph = dijkstra.createGraph();
		dijkstra.dijkstra(graph.get(0), graph);
		
		for(Vertex v : graph){
			System.out.println(v.vertexName+" : "+ v.min);
		}
	}


	private List<Vertex> createGraph() {
		Vertex v1 = new Vertex(1);
		Vertex v2 = new Vertex(2);
		Vertex v3 = new Vertex(3);
		Vertex v4 = new Vertex(4);
		Vertex v5 = new Vertex(5);
		Vertex v6 = new Vertex(6);

		List<Edge> edges = new ArrayList<Edge>();
		edges.add(new Edge(v2, 3));
		edges.add(new Edge(v3, 4));
		edges.add(new Edge(v4, 2));
		v1.incidentEdges = edges;

		edges = new ArrayList<Edge>();
		edges.add(new Edge(v1, 3));
		edges.add(new Edge(v3, 4));
		edges.add(new Edge(v5, 2));
		v2.incidentEdges = edges;

		edges = new ArrayList<Edge>();
		edges.add(new Edge(v1, 4));
		edges.add(new Edge(v2, 4));
		edges.add(new Edge(v5, 6));
		v3.incidentEdges = edges;

		edges = new ArrayList<Edge>();
		edges.add(new Edge(v1, 2));
		edges.add(new Edge(v5, 1));
		edges.add(new Edge(v6, 4));
		v4.incidentEdges = edges;

		edges = new ArrayList<Edge>();
		edges.add(new Edge(v2, 2));
		edges.add(new Edge(v3, 6));
		edges.add(new Edge(v4, 1));
		edges.add(new Edge(v6, 2));
		v5.incidentEdges = edges;

		edges = new ArrayList<Edge>();
		edges.add(new Edge(v4, 4));
		edges.add(new Edge(v5, 2));
		v6.incidentEdges = edges;
		
		graph.add(v1);
		graph.add(v2);
		graph.add(v3);
		graph.add(v4);
		graph.add(v5);
		graph.add(v6);
		
		return graph;

	}

	public void dijkstra(Vertex source, List<Vertex> vertices) {
		source.min = 0;
		PriorityQueue<Vertex> Q = new PriorityQueue<Vertex>();
		
		for(Vertex v : vertices){
			Q.add(v);
		}

		while (!Q.isEmpty()) {
			Vertex u = Q.poll();

			// Visit each edge exiting u
			for (Edge e : u.incidentEdges) {
				Vertex v = e.end;
				int weight = e.weight;
				int tempDistance = u.min + weight;
				if (tempDistance < v.min) {
					Q.remove(v); // remove to re-insert it in the queue with the new cost.
					v.min = tempDistance;
					v.previous = u;
					Q.add(v);
				}
			}
		}
		
		System.out.println("done");
	}
}

class Vertex implements Comparable<Vertex> {
	public int vertexName;
	public List<Edge> incidentEdges;
	public int min = Integer.MAX_VALUE;
	public Vertex previous;

	public Vertex(int vertexName) {
		this.vertexName = vertexName;
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
		return "Vertex [vertexName=" + vertexName + ", min=" + min + ", previous=" + previous + "]";
	}
}

class Edge {
	public Vertex end;
	public int weight;

	@Override
	public String toString() {
		return "Edge [end=" + end + ", weight=" + weight + "]";
	}

	public Edge(Vertex end, int weight) {
		this.end = end;
		this.weight = weight;
	}
}
