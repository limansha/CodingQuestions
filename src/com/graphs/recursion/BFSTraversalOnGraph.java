package com.graphs.recursion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class BFSTraversalOnGraph {
	
	static int numNodes = 7;

	static boolean[] visited = new boolean[numNodes];

	public static void main(String[] args) {

		// nodes starts from 1 to n the list at position 0 is for node 1
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
		ArrayList<Integer> seq = new ArrayList<Integer>();
		for (int i = 0; i < numNodes; i++) {
			if (!visited[i]) {
				bfs(i, graph, visited, seq);
			}
		}
		System.out.println("Sequence of BFS traversl");
		for (Integer s : seq) {
			System.out.print(s + " ");
		}
	}

	static void bfs(int node, ArrayList<ArrayList<Integer>> adj, boolean[] visited, ArrayList<Integer> seq) {
		//Sequencial Approach
		Queue<Integer> q = new LinkedList<Integer>();
		q.add(node);
		while(!q.isEmpty()) {
			Integer n= q.poll(); //removing the first element as it is FIFO
			seq.add(n);
			visited[n] = true;
			for(Integer anode : adj.get(n)) {
				if(!visited[anode]) {
					q.add(anode);
					visited[anode] = true; //once pushed consider to be visited
				}
			}
		}
	}
	}

