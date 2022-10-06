package com.graphs.dfs;

import java.util.ArrayList;
import java.util.Arrays;

public class DfsInDP {
	static int numNodes = 7;
	static int maxPath = 0;
	static boolean visited[] =new boolean[7];
	static int dp[] =new int[8];
	public static void main(String[] args) {
		Arrays.fill(visited, false);
		ArrayList<ArrayList<Integer>> graph = new ArrayList<ArrayList<Integer>>();
		for (int i = 0; i < numNodes; i++) {
			graph.add(new ArrayList<Integer>());
		}
		Arrays.fill(dp, 0);
		graph.get(0).add(1);
		graph.get(1).add(2);
		graph.get(1).add(6);
		graph.get(2).add(4);
		graph.get(2).add(3);
		graph.get(3).add(5);
	
		dfs(graph,0,dp);
		System.out.println(maxPath);
		System.out.println(Arrays.toString(dp));
		
	}
	private static int dfs(ArrayList<ArrayList<Integer>> graph,Integer node,int[] dp) {
		if(visited[node] == true) {
			return 0;
		}
		visited[node] = true;
		for(Integer adj : graph.get(node)) {
			if(!visited[adj]) {
				dp[adj] = Math.max(1, dp[node]+dfs(graph,adj,dp));
			}
		}
		return dp[numNodes];
	}

	
}
