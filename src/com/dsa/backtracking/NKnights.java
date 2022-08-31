package com.dsa.backtracking;

import java.util.Arrays;

public class NKnights {
	static int count =0;
	public static void main(String[] args) {
		int n = 4;
		boolean[][] board = new boolean[n][n];
		for (boolean[] b : board)
			Arrays.fill(b, false);
		nKnights(board, 0,0,n);
		System.out.println(count);

	}

	private static void nKnights(boolean[][] board, int row,int col,int knights) {
		
		if(knights == 0) {
			count++;
			display(board);
			System.out.println();
			return;
		}
		if(row == board.length-1 && col == board.length-1) return;
		
		if(col == board.length-1) {
			 nKnights(board, row+1, 0, knights);
			return;
		}
	
		if(isSafe(board,row,col)) {
			board[row][col] = true;
			nKnights(board, row, col+1, knights-1); //if safe placing and checking for next
			board[row][col] = false;
		}
		nKnights(board,row,col+1,knights); //not placing but checking if safe
		
		return;
	}
	private static boolean isSafe(boolean[][] board, int row, int col) {
		if(isValid(board.length,row-2,col-1)) {
			if(board[row-2][col-1]) return false;
		}
		if(isValid(board.length,row-2,col+1)) {
			if(board[row-2][col+1]) return false;
		}
		if(isValid(board.length,row-1,col-2)) {
			if(board[row-1][col-2]) return false;
		}
		if(isValid(board.length,row-1,col+2)) {
			if(board[row-1][col+2]) return false;
		}
		return true;
	}

	private static boolean isValid(int board, int row, int col) {
		if(row >= 0 && row < board && col >= 0 && col < board) return true;
		return false;
	}

	private static void display(boolean[][] board) {
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[0].length; j++) {
				if (board[i][j]) {
					System.out.print(" K ");
				} else {
					System.out.print(" * ");
				}
			}
			System.out.println();
		}
	}

}
