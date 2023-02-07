package com.thinklikecoder.tasks;

import java.util.Arrays;

public class Eposide5 {

	public static void main(String[] args) {
		//print X on the odd square matrix
		int n=5;
		int [][] painting = new int[n][n];
		for(int i=0;i<n;i++) {
			Arrays.fill(painting[i], 0);
		}
		//start painting
		//mtd 1 is row by row painting
		//mtd 2 is observing the painting as a square inside a square and color all 4 the edges 
		for(int i=0;i<=Math.ceil(n/2);i++) {
			painting[i][i] = 1;
			painting[i][n-i-1] = 1;
			painting[n-i-1][i] = 1;
			painting[n-i-1][n-i-1] = 1;
		}
		for(int i=0;i<n;i++) {
			for(int j=0;j<n;j++) {
				System.out.print(painting[i][j]+" ");
			}
			System.out.println();
		}
	}

}
