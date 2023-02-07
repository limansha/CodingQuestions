package com.dsa.dynamicprogmming;

import java.util.Arrays;

//GFG Distinct Coloring : 
/*
 * There is a row of N houses, each house can be painted with one of the three colors:
 *  red, blue or green. The cost of painting each house with a certain color is different.
 *   You have to paint all the houses such that no two adjacent houses have the same color. 
 *   Find the minimum cost to paint all houses.

The cost of painting each house in red, blue or green colour is given in the array r[], g[] and b[] respectively.
 * */

/*
 * case 1: 
 * N = 3
r[] = {2, 1, 3}
g[] = {3, 2, 1}
b[] = {1, 3, 2} 
 * case 2: 
7
95 9 37 15 64 86 41
87 5 31 10 28 4 92
90 49 68 50 76 67 70
 * */
public class ColorHouses {

	public static void main(String[] args) {
		int []r = new int[]{2,1,3};
		int []g = new int[]{3,2,1};
		int []b = new int[] {1,3,2};
		int N =3;
		System.out.println(distinctColoring(N,r,g,b)); //using recursion
	//	System.out.println(distinctColoring(N,r,g,b)); //using dp
		
	}
//	public static long distinctColoring(int n, int[] r, int[] g, int[] b) {
//		int ans = Integer.MAX_VALUE;
//		int dp[][] = new int[n][n];
//		for(int i=0;i<n;i++) {
//			Arrays.fill(dp[i],0);
//		}
//		dp[0][0] = r[0];
//		dp[0][1] = g[0];
//		dp[0][2] = b[0];
//	for(int i=1;i<n;i++) {
//			 	dp[i][0] = r[i] + Math.min(dp[i-1][1],dp[i-1][2]);
//				dp[i][1] = g[i] + Math.min(dp[i-1][0],dp[i-1][2]);
//				dp[i][2] = b[i] + Math.min(dp[i-1][1],dp[i-1][0]); 
//	}
//		for(int i : dp[n-1]) {
//			if(ans > i) {
//				ans = i;
//			}
//		}
//		return ans;
//	}
	
	public static long distinctColoring(int N, int[]r, int[]g, int[]b){
		int ans = Integer.MAX_VALUE;
		int []last = new int[] {color(N,r,g,b,0),color(N,r,g,b,1),color(N,r,g,b,2)};
		//System.out.println(Arrays.toString(last));
		for(int i : last) {
			if(ans > i) {
				ans = i;
			}
		}
		return ans;
	}
	private static int color(int n, int[] r, int[] g, int[] b,int p) {
		if(p == 0) {
			if(n == 1) return r[0];
			return r[n-1]+ Math.min(color(n-1,r,g,b,1), color(n-1,r,g,b,2));
		}
		if(p == 1) {
			if(n == 1) return g[0];
			return g[n-1]+ Math.min(color(n-1,r,g,b,0), color(n-1,r,g,b,2));
		}
		if(p == 2) {
			if(n == 1) return b[0];
			return b[n-1]+ Math.min(color(n-1,r,g,b,1), color(n-1,r,g,b,0));
		}
		return 0;
	}
}
