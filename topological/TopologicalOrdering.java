package com.ds.topological;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

public class TopologicalOrdering {

	public static void main(String[] args) {
		TopologicalOrdering ordering = new TopologicalOrdering();
		List<Vertex> graph = ordering.createGraph();
		ordering.topologicalOrdering(graph);

	}

	private void topologicalOrdering(List<Vertex> graph) {
		if (graph == null)
			return;

		Queue<Vertex> topologicOrder = new ArrayDeque<Vertex>();
		// identifying all the sink vertices
		for (Vertex v : graph) {
			if (v != null && v.adjacencyList == null || v.adjacencyList.size() == 0)
				topologicOrder.add(v);
		}

		while (!topologicOrder.isEmpty()) {
			Vertex currentSink = topologicOrder.remove();
			System.out.print(currentSink.identifier + " ");
			for (Vertex v : graph) {
				if (v != null && v.equals(currentSink))
					v = null;
				
				else if (v != null && v.adjacencyList != null && v.adjacencyList.contains(currentSink)) {
					v.adjacencyList.remove(currentSink);
					if (v.adjacencyList.size() == 0)
						topologicOrder.add(v);
				}
			}

		}
	}

	private List<Vertex> createGraph() {
		Vertex vA = new Vertex("A");
		Vertex vB = new Vertex("B");
		Vertex vC = new Vertex("C");
		Vertex vD = new Vertex("D");
		Vertex vE = new Vertex("E");
		Vertex vF = new Vertex("F");
		Vertex vG = new Vertex("G");
		Vertex vH = new Vertex("H");

		vA.getAdjacencyList().add(vB);
		vA.getAdjacencyList().add(vE);
		vB.getAdjacencyList().add(vC);
		vC.getAdjacencyList().add(vH);
		vD.getAdjacencyList().add(vB);
		vE.getAdjacencyList().add(vF);
		vE.getAdjacencyList().add(vG);
		vF.getAdjacencyList().add(vG);
		vG.getAdjacencyList().add(vC);

		List<Vertex> graph = new ArrayList<Vertex>();
		graph.add(vA);
		graph.add(vB);
		graph.add(vC);
		graph.add(vD);
		graph.add(vE);
		graph.add(vF);
		graph.add(vG);
		graph.add(vH);

		return graph;
	}

}
