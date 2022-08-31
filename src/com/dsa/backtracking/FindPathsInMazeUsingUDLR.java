package com.dsa.backtracking;

public class FindPathsInMazeUsingUDLR {
	static boolean[][] maze = { { true, true, true }, { true, true, true }, { true, true, true } };
	static int rows = maze.length;
	static int cols = maze[0].length;
	
	public static void main(String[] args) {
		findPaths(maze, 0, 0, "", new int[rows][cols],1);
	}

//print path along with the sequence of traversal on matrix
	private static void findPaths(boolean[][] maze, int row, int col, String path, int[][] result,int step) {
		if(row == rows-1 && col == cols-1) {
			result[row][col] = step; //step is nothing but level of call
			System.out.println(path);
			for(int i=0;i<rows;i++) {
				for(int j=0;j<cols;j++) {
					System.out.print( result[i][j] +" | ");
				}
				System.out.println();
				System.out.println("----------");
			}
			return;
		}
		
		if(!maze[row][col]) return;
		maze[row][col] = false;//marking visited 
		result[row][col] = step; //noting down step number
		
		if(row < rows-1) {
			findPaths(maze,row+1,col,path+"D",result,step+1);
		}
		if(col < cols-1) {
			findPaths(maze,row,col+1,path+"R",result,step+1);
		}
		if(row > 0) {
			findPaths(maze,row-1,col,path+"U",result,step+1);
		}
		if(col > 0) {
			findPaths(maze,row,col-1,path+"L",result,step+1);
		}
		
		//backtracking
		maze[row][col] = true;
		result[row][col] = 0;
		
	}
	//recursion is Depth first algo and goes from Left to Right
}
