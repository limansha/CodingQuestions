package com.dsa.backtracking;

public class IntoOfProblem {

	public static void main(String[] args) {

		// #Q find the paths from 0,0 to n-1,n-1 using L-left R-right U-up D-down

		boolean[][] maze = { { true, true, true }, { true, true, true }, { true, true, true } };
		boolean[][] maze1 = { { true, true, true }, { true, true, true }, { true, true, true } };
		// findPathsStackOverFlow(maze,0,0,"");
		findPaths(maze, 0, 0, "");

		for (int i = 0; i < maze.length; i++) {
			for (int j = 0; j < maze[0].length; j++) {
				System.out.print(maze[i][j] + " ");
			}
			System.out.println();
		}// so using the new maze as i/p to findAllPaths
		System.out.println();
		System.out.println("All valid paths");

		findAllPaths(maze1, 0, 0, "");

	}

//this type of approach lead to stack overflow as it goes to repeated paths and goes into endless loop
	// how to solve this problem ? by putting a visited matrix so the call will not
	// go to the visted block/cell again
	private static void findPathsStackOverFlow(boolean[][] maze, int row, int col, String path) {
		int max_row = maze.length - 1;
		int max_col = maze[0].length - 1;
		if (row == max_row && col == max_col) {
			System.out.println(path);
			return;
		}
		if (!maze[row][col])
			return;
		if (row < max_row)
			findPathsStackOverFlow(maze, row + 1, col, path + "D");
		if (col < max_col)
			findPathsStackOverFlow(maze, row, col + 1, path + "R");
		if (row > 0)
			findPathsStackOverFlow(maze, row - 1, col, path + "U");
		if (col > 0)
			findPathsStackOverFlow(maze, row, col - 1, path + "L");
	}

	// some valid paths gets missed as the maze changes its initial state for
	// remaining calls
	private static void findPaths(boolean[][] maze, int row, int col, String path) {
		int max_row = maze.length - 1;
		int max_col = maze[0].length - 1;
		if (row == max_row && col == max_col) {
			System.out.println(path);
			return;
		}

		if (!maze[row][col])
			return;
		if (row < max_row) {
			// as its visited making this cell to false so whenever next call made by its
			// subfunction to the same cell they will be returned/exited
			// this cell it will stop
			maze[row][col] = false;
			findPaths(maze, row + 1, col, path + "D");
		}
		if (col < max_col) {
			maze[row][col] = false;
			findPaths(maze, row, col + 1, path + "R");
		}
		if (row > 0) {
			maze[row][col] = false;
			findPaths(maze, row - 1, col, path + "U");

		}
		if (col > 0) {
			maze[row][col] = false;
			findAllPaths(maze, row, col - 1, path + "L");
		}

	}

	private static void findAllPaths(boolean[][] maze, int row, int col, String path) {
		int max_row = maze.length - 1;
		int max_col = maze[0].length - 1;
		if (row == max_row && col == max_col) {
			System.out.println(path);
			return;
		}

		if (!maze[row][col])
			return;

		maze[row][col] = false; // marking to be visited

		if (row < max_row) {
			// as its visited making this cell to false so whenever next call made by its
			// subfunction to the same cell they will be returned/exited
			// this cell it will stop

			findAllPaths(maze, row + 1, col, path + "D");
		}
		if (col < max_col) {

			findAllPaths(maze, row, col + 1, path + "R");
		}
		if (row > 0) {

			findAllPaths(maze, row - 1, col, path + "U");

		}
		if (col > 0) {

			findAllPaths(maze, row, col - 1, path + "L");
		}
		// this is marked as visited while going towards destination(it will reach the
		// dest) but next calls from other directions gets blocked by this calls updated
		// value to false in maze as its refered globally by all the function calls.
		// next calls will not see any path to reach destination thus ends there
		// its something like think matrix cells to be bricks and you are removing the
		// bricks once you move to next brick which leads to destination. as the maze of
		// bricks is commonly refered by all funtn calls the other functn calls sees no
		// bricks to reach destination as its removed by the previous call
		// so to find the number of different paths to reach from source to destination.
		// we need to do some additional task i.e we after reaching to destination via a
		// function call we again need to PLACE the bricks that we removed while
		// traversing from source to destination while exiting so that other calls can
		// use the bricks to find other paths.
		// this is called backtracking

		maze[row][col] = true; // removing our markers on maze after each function call / marking back to unvisited
		
		
		// after each method reaching destination and returned the previous calls will
		// traverse backs to its parent by placing the bricks again IN PLACE(true) which
		// they moved(false).
		// this is called backtracking
		// where we are again modifying the maze to its initial state by removing all
		// our(each function call) markers so that other calls can work on the maze with
		// its initial state.
		
		//in recursion tree siblings call will get the correct maze that is only modified by its parent but not childerens  
	}

}
