package com.graphs.bfs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class ShortestPathFromSourceInUnitWeightGraph {
	static int numNodes = 8;
	static int[] mindistance = new int[numNodes];

	public static void main(String[] args) {
		ArrayList<ArrayList<Integer>> graph = new ArrayList<ArrayList<Integer>>();
		for (int i = 0; i < numNodes; i++) {
			graph.add(new ArrayList<Integer>());
		}
		graph.get(0).add(1);

		graph.get(1).add(0);
		graph.get(1).add(2);
		graph.get(1).add(5);

		graph.get(2).add(1);
		graph.get(2).add(3);

		graph.get(3).add(2);
		graph.get(3).add(4);
		graph.get(3).add(6);

		graph.get(4).add(3);
		graph.get(4).add(5);

		graph.get(5).add(4);
		graph.get(5).add(1);

		graph.get(6).add(3);
		graph.get(6).add(7);

		graph.get(7).add(6);

//		for(ArrayList<Integer> i: graph) {
//			System.out.println(i.toString());
//		}
		Arrays.fill(mindistance, Integer.MAX_VALUE);
		findMinimumDistance(0, graph, mindistance);
		System.out.println("Minimum distance from node zero as source other nodes is ");
		for (int i = 0; i < mindistance.length; i++) {
			System.out.println("0 -> " + i + " = " + mindistance[i]);
		}
	}
//bfs is going level order so this traversal will surly gives minimum
	private static void findMinimumDistance(int src, ArrayList<ArrayList<Integer>> graph, int[] mindistance) {
		Queue<Integer> q = new LinkedList<Integer>();
		mindistance[src] = 0;
		q.add(src);
		while (!q.isEmpty()) {
			int n = q.poll();
			for (Integer adj : graph.get(n)) {
				if (mindistance[n] + 1 < mindistance[adj]) {
					mindistance[adj] = mindistance[n] + 1;
					q.add(adj);
				}
			}
		}
	}

}
