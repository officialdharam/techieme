package com.ds.topological;

import java.util.ArrayList;
import java.util.List;

public class Vertex {
	
	String identifier;
	List<Vertex> adjacencyList;
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((identifier == null) ? 0 : identifier.hashCode());
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
		if (identifier == null) {
			if (other.identifier != null)
				return false;
		} else if (!identifier.equals(other.identifier))
			return false;
		return true;
	}

	

	public List<Vertex> getAdjacencyList() {
		if (adjacencyList == null)
			adjacencyList = new ArrayList<Vertex>();
		return adjacencyList;
	}

	@Override
	public String toString() {
		return "Vertex [identifier=" + identifier + "]";
	}

	public Vertex(String identifier) {
		super();
		this.identifier = identifier;
	}

	public void setAdjacencyList(List<Vertex> adjacencyList) {
		this.adjacencyList = adjacencyList;
	}

	public String getIdentifier() {
		return identifier;
	}

	public void setIdentifier(String identifier) {
		this.identifier = identifier;
	}
}
