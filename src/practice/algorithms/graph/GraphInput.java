package practice.algorithms.graph;

import java.util.ArrayList;
import java.util.List;

public class GraphInput {
	
	public static List<GraphData> getGrapghs(){
		List<GraphData> graphs = new ArrayList<>();
		graphs.add(createGraph1());
		return graphs;
	}

	private static GraphData createGraph1(){
		int edges = 6;
		GraphData data = new GraphData(edges,4);
		
		data.edges[0][0] =  0;	data.edges[0][1] =  1;
		data.edges[1][0] =  1;	data.edges[1][1] =  2;
		data.edges[2][0] =  0;	data.edges[2][1] =  2;
		data.edges[3][0] =  2;	data.edges[3][1] =  0;
		data.edges[4][0] =  2;	data.edges[4][1] =  3;
		data.edges[5][0] =  3;	data.edges[5][1] =  3;
		
		return data;
	}
}
