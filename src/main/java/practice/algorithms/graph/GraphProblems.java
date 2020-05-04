package practice.algorithms.graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Stack;

public class GraphProblems {
	public static void main(String[] args) {
		
		for(GraphData graphData : GraphInput.getGrapghs()){
			ArrayList<ArrayList<Integer>>  adjanceyList = createAdjanceyList(graphData);
			breadthFirstTraversal(adjanceyList,2);
			System.out.println();
			boolean[] verticesVisited = new boolean[adjanceyList.size()];
			depthFirstTraversalRecursive(adjanceyList,verticesVisited,2);
			System.out.println();
			depthFirstTraversalNonRecursive(adjanceyList,2);
		}
	}

	private static void depthFirstTraversalNonRecursive(ArrayList<ArrayList<Integer>> adjanceyList, int startNode) {
		Stack<Integer> myStack = new Stack<>();
		boolean[] verticesVisited = new boolean[adjanceyList.size()];
		myStack.push(startNode);
		verticesVisited[startNode] = true;
		System.out.print(startNode+" ");
		while(!myStack.isEmpty()){
			boolean popFromStack = true;
			Integer currentNode = myStack.peek();
			for(Integer node : adjanceyList.get(currentNode)){
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

	private static void depthFirstTraversalRecursive(ArrayList<ArrayList<Integer>> adjanceyList, boolean[] verticesVisited,int startNode) {

		verticesVisited[startNode] = true;
		System.out.print(startNode+" ");
		for(Integer node : adjanceyList.get(startNode)){
			if(verticesVisited[node] == false){
				depthFirstTraversalRecursive(adjanceyList,verticesVisited,node);
			}
		}
	}

	private static  ArrayList<ArrayList<Integer>> createAdjanceyList(GraphData graphData) {
		ArrayList<ArrayList<Integer>> list = new ArrayList<ArrayList<Integer>>(graphData.numberOfVertices);
		for(int i = 0 ; i < graphData.numberOfVertices ; ++i){
			list.add(i, new ArrayList<>()) ;
		}
		for(int i = 0; i < graphData.edges.length ; ++i){
			list.get(graphData.edges[i][0]).add(graphData.edges[i][1]);
		}
		return list;
	}

	private static void breadthFirstTraversal(ArrayList<ArrayList<Integer>> adjanceyList, int startNode) {
		boolean[] verticesVisited = new boolean[adjanceyList.size()];
		LinkedList<Integer> queue = new LinkedList<>();

		queue.add(startNode);
		verticesVisited[startNode] = true;
		while(!queue.isEmpty()){
			Integer node = queue.get(0);
			System.out.print(node+" ");
			queue.removeFirst();
			for(Integer child : adjanceyList.get(node)){
				if(verticesVisited[child] == false){
					queue.addLast(child);
					verticesVisited[child] = true;
				}
			}
		}
	}
}
