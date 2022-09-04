package com.graphs.recursion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class IfCycleInUndirectedGraph {
	static ArrayList<ArrayList<String>> adjList = new ArrayList<ArrayList<String>>();
	public static void main(String[] args) {
		// adjListNoCycles = [[1], [0, 2, 3], [1], [1, 4], [3]]
		//adjListCycles = [[1], [0, 2, 3], [1,4], [1, 4], [2,3]]
		int nodes = 5;
		Scanner s = new Scanner(System.in);
		for(int i=0;i<nodes;i++) {
			System.out.println("Enter adjacent nodes for node "+ i+ " press # to end");
			ArrayList arr = new ArrayList();
			String n = null;
			while((n=s.nextLine()).length() > 0) {
				arr.add(n);
			}
			adjList.add(i, arr);
		}
		System.out.println(adjList.toString());
		boolean visited[] = new boolean[nodes]; 
		Arrays.fill(visited, false);
		boolean isCycle = isCyclePresent(0,-1,
				adjList.get(0),visited);
		if(isCycle) System.out.println("has cycles in graph");
		else System.out.println("doesn't has cycles in graph");
	}

	private static boolean isCyclePresent(int n, int p,ArrayList<String> adjNodes, boolean[] visited) {
		
		visited[n] =  true;
		for(int i =0;i<adjNodes.size();i++) {
			int an = Integer.parseInt(adjNodes.get(i));
			if(an == p) continue;
			if(visited[an]) return true;
			if(isCyclePresent(an,n,adjList.get(an),visited)) return true;
			
		}
		return false;
	}

}
