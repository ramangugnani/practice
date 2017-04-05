package practice.algorithms.graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class GraphProblems {
	public static void main(String[] args) {
		
		for(GraphData graphData : GraphInput.getGrapghs()){
			List<Integer>[]  adjanceyList = createAdjanceyList(graphData);
			breadthFirstTraversal(adjanceyList,2);
			System.out.println();
			boolean[] verticesVisited = new boolean[adjanceyList.length];
			depthFirstTraversalRecursive(adjanceyList,verticesVisited,2);
			System.out.println();
			depthFirstTraversalNonRecursive(adjanceyList,2);
		}
	}

	private static void depthFirstTraversalNonRecursive(List<Integer>[] adjanceyList, int startNode) {
		Stack<Integer> myStack = new Stack<>();
		boolean[] verticesVisited = new boolean[adjanceyList.length];
		myStack.push(startNode);
		verticesVisited[startNode] = true;
		System.out.print(startNode+" ");
		while(!myStack.isEmpty()){
			boolean popFromStack = true;
			Integer currentNode = myStack.peek();
			for(Integer node : adjanceyList[currentNode]){
				if(verticesVisited[node] == false){
					myStack.push(node);
					verticesVisited[node] = true;
					System.out.print(node+" ");
					popFromStack = false;
					break;
				}
			}
			if(popFromStack)
				myStack.pop();
		}


	}

	private static void depthFirstTraversalRecursive(List<Integer>[] adjanceyList, boolean[] verticesVisited,int startNode) {

		verticesVisited[startNode] = true;
		System.out.print(startNode+" ");
		for(Integer node : adjanceyList[startNode]){
			if(verticesVisited[node] == false){
				depthFirstTraversalRecursive(adjanceyList,verticesVisited,node);
			}
		}
	}

	private static  List<Integer>[] createAdjanceyList(GraphData graphData) {
		List<Integer>[] list = new ArrayList[graphData.numberOfVertices];
		for(int i = 0 ; i < graphData.numberOfVertices ; ++i){
			list[i] = new ArrayList<>();
		}
		for(int i = 0; i < graphData.edges.length ; ++i){
			list[graphData.edges[i][0]].add(graphData.edges[i][1]);
		}
		return list;
	}

	private static void breadthFirstTraversal(List<Integer>[] adjanceyList, int startNode) {
		boolean[] verticesVisited = new boolean[adjanceyList.length];
		LinkedList<Integer> queue = new LinkedList<>();

		queue.add(startNode);
		verticesVisited[startNode] = true;
		while(!queue.isEmpty()){
			Integer node = queue.get(0);
			System.out.print(node+" ");
			queue.removeFirst();
			for(Integer child : adjanceyList[node]){
				if(verticesVisited[child] == false){
					queue.addLast(child);
					verticesVisited[child] = true;
				}
			}
		}
	}
}
