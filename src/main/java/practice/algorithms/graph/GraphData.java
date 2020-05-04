package practice.algorithms.graph;

import java.util.Arrays;

public class GraphData {

	Integer numberOfEdges;
	
	Integer numberOfVertices;
	
	Integer[][] edges = null;
	
	public GraphData(Integer numberOfEdges,Integer numberOfVertices) {
		this.numberOfEdges = numberOfEdges;
		this.numberOfVertices = numberOfVertices;
		edges = new Integer[numberOfEdges][2];
	}

	@Override
	public String toString() {
		return "GraphData [numberOfEdges=" + numberOfEdges + ", numberOfVertices=" + numberOfVertices + ", edges="
				+ Arrays.toString(edges) + "]";
	}
	
}
