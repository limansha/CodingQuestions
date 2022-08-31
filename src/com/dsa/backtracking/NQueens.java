package com.dsa.backtracking;

import java.util.Arrays;

public class NQueens {
//#Q find the number of ways we can place n queens on nXn board such that no queen is getting killed by other n-1 queens 

	// place the queen in one column and check for remaining queens to be placed in
	// other rows.
//	i.e after placing Q1 in row 1 we check to place Q2 in safe cell in row 2 if Queen 3 and Q4 are not able to be placed we backtrack and remove the Q2 and place it in next possible cell and check and it goes on.

	public static void main(String[] args) {
		int n = 4;
		boolean[][] board = new boolean[n][n];
		for (boolean[] b : board)
			Arrays.fill(b, false);
		System.out.println(nQueens(board, 0));
	}

	private static int nQueens(boolean[][] board, int row) {
		if (row == board.length) {
			display(board);
			System.out.println();
			return 1;
		}
		int count = 0;
		for (int col = 0; col < board.length; col++) {
			if (isSafe(board, row, col)) { // if its safe only then put Queen
				// place the queen in one column for given row
				board[row][col] = true;
				count += nQueens(board, row + 1);
				board[row][col] = false; // backtracking i.e removing the queen from the cell
			}

		}
		return count;
	}

	private static boolean isSafe(boolean[][] board, int row, int col) {
		// check in column
		for (int i = 0; i < row; i++) {
			if (board[i][col])
				return false;
		}
		// check diagonal left
		int maxLeft = Math.min(row, col);
		for (int i = 1; i <= maxLeft; i++) {
			if (board[row - i][col - i])
				return false;
		}
		// check diagonal right
		int maxRight = Math.min(row, board.length - col - 1);
		for (int i = 1; i <= maxRight; i++) {
			if (board[row - i][col + i])
				return false;
		}

		return true;
	}

	private static void display(boolean[][] board) {
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[0].length; j++) {
				if (board[i][j]) {
					System.out.print(" Q ");
				} else {
					System.out.print(" X ");
				}
			}
			System.out.println();
		}
	}

}
