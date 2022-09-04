package com.graphs.bfs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

class Pair {
	int parent;
	int child;

	public Pair(int parent, int child) {
		super();
		this.parent = parent;
		this.child = child;
	}

}

public class isBiparteGraph {
	// this BFS is the easy approach to find the biparete graph as we traverse
	// adjacent nodes first

	// what is biparte graph

	// if we want to color a graph and we can color a graph with only two
	// colors,then the rule is no two adjacent nodes should have same color then it
	// is called bipate graph

	// out of observation we can say that the graph which DOESN'T have ODD LENGTH
	// cycle are biparte graph

	static int numNodes = 9;
	static int[] color = new int[numNodes];

	public static void main(String[] args) {

		ArrayList<ArrayList<Integer>> graph = new ArrayList<ArrayList<Integer>>();
		for (int i = 0; i < numNodes; i++) {
			graph.add(new ArrayList<Integer>());
		}
		// bipareted graph
//		graph.get(0).add(1);
//
//		graph.get(1).add(0);
//		graph.get(1).add(2);
//		graph.get(1).add(6);
//
//		graph.get(2).add(1);
//		graph.get(2).add(3);
//
//		graph.get(3).add(2);
//		graph.get(3).add(4);
//
//		graph.get(4).add(3);
//		graph.get(4).add(5);
//		graph.get(4).add(7);
//
//		graph.get(5).add(4);
//		graph.get(5).add(6);
//
//		graph.get(6).add(1);
//		graph.get(6).add(5);
//
//		graph.get(7).add(4);
//		graph.get(7).add(8);
//
//		graph.get(8).add(7);

		// non biparted graph
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
		Arrays.fill(color, -1);
		if (isBiparete(0, graph, color))
			System.out.println("is Bipated graph");
		else
			System.out.println("is not Bipated graph");

		if (isBipareteTUF(0, graph, color))
			System.out.println("is Bipated graph");
		else
			System.out.println("is not Bipated graph");
	}

	private static boolean isBiparete(int node, ArrayList<ArrayList<Integer>> graph, int[] color) {
		Queue<Pair> q = new LinkedList<Pair>();
		q.add(new Pair(-1, node));
		color[node] = 1;
		while (!q.isEmpty()) {
			Pair pair = q.poll();
			int parent = pair.parent;
			int n = pair.child;
			// looping on adjacency list
			for (Integer anode : graph.get(n)) {
				if (anode != parent) { //
					if (color[anode] == -1) {// not colored yet
						color[anode] = 1 - color[n]; // assign opposite color of adjacent node
						q.add(new Pair(n, anode));
					} else if (color[anode] == color[n]) {// already colored
						// not bipated
						System.out.println("edge "+anode + " -> "+n);
						return false;
					}
				}
			}
		}
		return true;
	}

	private static boolean isBipareteTUF(int node, ArrayList<ArrayList<Integer>> graph, int[] color) {
		Queue<Integer> q = new LinkedList<Integer>();
		q.add(node);
		color[node] = 1;
		while (!q.isEmpty()) {
			int n = q.poll();

			for (Integer anode : graph.get(n)) {

				if (color[anode] == -1) { // here only it checks it visited or not if -1 not visited i.e the parent node
											// will be visited so continues 
					//but here is the bug in line color[anode] == -1 as the color can be added by one vertex can be wrong wrt to other vertex i.e if we check 5 -> 4 -> 3 nodes 
					//5 adds zero to 4 and 2 adds zero to 3 in graph. but we have an edge b/w 3-> 4 which fails having zero color for both 3 and 4 which is missed checking as only isColor assigned is checked 
					color[anode] = 1 - color[n];
					q.add(anode);
				} else if (color[anode] == color[n]) {
					System.out.println("edge "+anode + " -> "+n);
					return false;
				}
			}
		}

		return true;
	}

}
