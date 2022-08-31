package com.dsa.recursion.maze;

public class FindPathWithDeadEnds {

	public static void main(String[] args) {
		boolean [][]maze = new boolean[][]{
				{true,true,true,true},
				{true,false,true,true}, // at pos 1,1 there is a dead end start from 0,0 and reach 2,2
				{true,true,true,true}
		};
		pathsWithDeadEnds(maze,0,0,"");
	}
	static void pathsWithDeadEnds(boolean[][] maze,int row,int col,String path) {
		if(row == maze.length-1 && col == maze[0].length-1 && maze[row][col]) {
			System.out.println(path);
			return;//this is not backtracking as we are ending the call here
		}
		if(!maze[row][col]) return;
		if(row < maze.length-1) pathsWithDeadEnds(maze,row+1,col,path+"D");
		if(col < maze[0].length-1) pathsWithDeadEnds(maze,row,col+1,path+"R");
		
	}
}
