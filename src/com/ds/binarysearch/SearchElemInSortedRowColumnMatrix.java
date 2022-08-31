package com.ds.binarysearch;

public class SearchElemInSortedRowColumnMatrix {

	public static void main(String[] args) {
		int [][] matrix = {
				{3,4,9},
				{5,7,15},
				{23,23,21}
		};
		int []res = search(matrix,0,2,27);
		for(int i : res) System.out.print(i+" ");
	}

	private static int[] search(int[][] matrix, int row, int col, int tgt) {
		while(row <= matrix.length-1  && col >= 0) {
			int check = matrix[row][col];
			if(check == tgt) {
				return new int[] {row,col};
			}
			else if(check > tgt) {
				col-=1;
			}
			else if(check <= tgt) {
				row+=1;
			}
		}
		return new int[] {-1,-1};
		
	}

}
