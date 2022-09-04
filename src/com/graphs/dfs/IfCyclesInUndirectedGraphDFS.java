package com.graphs.dfs;

import java.util.ArrayList;
import java.util.Arrays;


public class IfCyclesInUndirectedGraphDFS {
	
	static int numNodes = 7;

	static boolean[] visited = new boolean[numNodes];
		//DFS is Easy to follow for finding Cycles
	public static void main(String[] args) {

		// nodes starts from 1 to n but we use o based indexing the list at position 0 is for node 1
		// i/p graph
		ArrayList<ArrayList<Integer>> graph = new ArrayList<ArrayList<Integer>>();
		for (int i = 0; i < numNodes; i++) {
			graph.add(new ArrayList<Integer>());
		}
		graph.get(0).add(1);

		graph.get(1).add(0);
		graph.get(1).add(2);
		graph.get(1).add(6);

		graph.get(2).add(1);
		graph.get(2).add(4);

		graph.get(3).add(5);

		graph.get(4).add(2);
		graph.get(4).add(6);

		graph.get(5).add(3);

		graph.get(6).add(1);
		graph.get(6).add(4);

//		for(ArrayList<Integer> i: graph) {
//			System.out.println(i.toString());
//		}
		Arrays.fill(visited, false);
		if(isCyclic(0,graph,visited)) System.out.println("Has Cycles");
		else System.out.println("doesn't have cycles");
		
	}
	public static  boolean isCyclic(int node, ArrayList<ArrayList<Integer>> adj, boolean[] visited) {
		for (int i = 0; i < numNodes; i++) {
			if (!visited[i]) {
				if(dfsCheck(i,-1,adj, visited)) return true; //for any individual component parent will be one for start node may it be 0 or 3
			}
		}
		return false;
	
	}
	
	public static boolean dfsCheck(int node,int parent, ArrayList<ArrayList<Integer>> adj, boolean[] visited) {
		
		visited[node] = true;
		for(Integer anode:adj.get(node)) {
			if(!visited[anode]) {
				if(dfsCheck(anode,node,adj,visited)) return true;
			}
			else if(anode != parent) return true; 
		}
		return false;
	
	}
}
