package com.dsa.dynamicprogmming;

import java.util.Arrays;

/*
 * 7
95 9 37 15 64 86 41
87 5 31 10 28 4 92
90 49 68 50 76 67 70
 * */

public class ColorHouseDP {

	public static void main(String[] args) {
		int[] r = new int[] { 95, 9, 37, 15, 64, 86, 41 };
		int[] g = new int[] { 87, 5, 31, 10, 28, 4, 92 };
		int[] b = new int[] { 90, 49, 68, 50, 76, 67, 70 };
		int N = 7;
		System.out.println(distinctColoring(N, r, g, b)); // using recursion
	}

	public static long distinctColoring(int n, int[]r, int[]g, int[]b){
    	long dp[][] = new long[n][3];
// 		for (int i = 0; i < n; i++) {
// 			Arrays.fill(dp[i], Long.MAX_VALUE);
// 		}
		dp[0][0] = r[0];
		dp[0][1] = g[0];
		dp[0][2] = b[0];
		for (int i = 1; i < n; i++) {
		    dp[i][0] = (r[i] + Math.min(dp[i - 1][1], dp[i - 1][2]));
			dp[i][1] = (g[i] + Math.min(dp[i - 1][0], dp[i - 1][2]));
			dp[i][2] = (b[i] + Math.min(dp[i - 1][1], dp[i - 1][0]));
		
		}

		return Math.min(Math.min(dp[n-1][0],dp[n-1][1]),dp[n-1][2]);
}
	}
