package com.graphs.dfs;

import java.util.ArrayList;
import java.util.Arrays;

public class isBiparteGraph {
	
	static int numNodes = 7;
	static boolean[] visited = new boolean[numNodes];
	public static void main(String[] args) {

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
	}
	

}
