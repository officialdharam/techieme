package com.test.mst;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class Prims {
	public static void main(String[] args) {
		Prims primsDriver = new Prims();
		List<Vertex> graph = primsDriver.prepareGraphAdjacencyList();
		primsDriver.primsMST(graph);
		for (Vertex v : graph) {
			if(v.previous != null)
				System.out.println(v.name + " "+v.previous.name);
		}
	}

	/**
	 * COde for breadth first traversal given an adjacency list.
	 * 
	 * @param graph
	 * @return
	 */
	private void primsMST(List<Vertex> graph) {

		PriorityQueue<Vertex> priorityQueue = new PriorityQueue<Vertex>();
		for (Vertex v : graph) {
			v.key = Integer.MAX_VALUE;
			priorityQueue.add(v);
		}

		Vertex peek = priorityQueue.peek();
		peek.key = 0;

		while (!priorityQueue.isEmpty()) {
			Vertex minVertex = priorityQueue.poll();
			if (minVertex.incidentEdges != null && minVertex.incidentEdges.size() > 0) {
				for (Edge edge : minVertex.incidentEdges) {
					if (priorityQueue.contains(edge.end) && edge.weight < edge.end.key) {
						priorityQueue.remove(edge.end);
						edge.end.key = edge.weight;
						edge.end.previous = minVertex;
						priorityQueue.add(edge.end);
					}
				}
			}
		}
	}

	/**
	 * Helper method to create a adjacency list for the demonstration graph.
	 */
	private List<Vertex> prepareGraphAdjacencyList() {

		List<Vertex> graph = new ArrayList<Vertex>();
		Vertex vertexA = new Vertex("A");
		Vertex vertexB = new Vertex("B");
		Vertex vertexC = new Vertex("C");
		Vertex vertexD = new Vertex("D");
		Vertex vertexE = new Vertex("E");
		Vertex vertexF = new Vertex("F");
		Vertex vertexG = new Vertex("G");

		List<Edge> edges = new ArrayList<Edge>();
		edges.add(new Edge(vertexB, 2));
		edges.add(new Edge(vertexD, 6));
		edges.add(new Edge(vertexF, 5));
		vertexA.incidentEdges = edges;

		edges = new ArrayList<Edge>();
		edges.add(new Edge(vertexA, 2));
		edges.add(new Edge(vertexC, 7));
		vertexB.incidentEdges = edges;

		edges = new ArrayList<Edge>();
		edges.add(new Edge(vertexB, 7));
		edges.add(new Edge(vertexD, 9));
		edges.add(new Edge(vertexF, 1));
		vertexC.incidentEdges = edges;

		edges = new ArrayList<Edge>();
		edges.add(new Edge(vertexA, 6));
		edges.add(new Edge(vertexC, 9));
		edges.add(new Edge(vertexE, 4));
		edges.add(new Edge(vertexG, 8));
		vertexD.incidentEdges = edges;

		edges = new ArrayList<Edge>();
		edges.add(new Edge(vertexD, 4));
		edges.add(new Edge(vertexF, 3));
		vertexE.incidentEdges = edges;

		edges = new ArrayList<Edge>();
		edges.add(new Edge(vertexA, 5));
		edges.add(new Edge(vertexC, 1));
		edges.add(new Edge(vertexE, 3));
		vertexF.incidentEdges = edges;

		edges = new ArrayList<Edge>();
		edges.add(new Edge(vertexD, 8));
		vertexG.incidentEdges = edges;

		graph.add(vertexA);
		graph.add(vertexB);
		graph.add(vertexC);
		graph.add(vertexD);
		graph.add(vertexE);
		graph.add(vertexF);
		graph.add(vertexG);

		return graph;
	}
}

class Vertex implements Comparable<Vertex> {
	String name;
	int key;
	public List<Edge> incidentEdges;
	public Vertex previous;

	public Vertex(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "Vertex [name=" + name + ", key=" + key + ", previous=" + previous + "]";
	}

	@Override
	public int compareTo(Vertex o) {
		return Integer.compare(key, o.key);
	}
}

class Edge {
	int weight;
	Vertex end;

	public Edge(Vertex end, int weight) {
		this.weight = weight;
		this.end = end;

	}

	@Override
	public String toString() {
		return "Edge [weight=" + weight + ", end=" + end + "]";
	}

}
