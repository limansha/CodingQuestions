package com.dsa.recursion.maze;

import java.util.ArrayList;

public class FindPathUsingDownRight {

	public static void main(String[] args) {
		//find the count of path that are possible for reaching from position {1,1} to {n,n} in a 2D maze
		int sizeOfMaze = 3;
		System.out.println(countPaths(sizeOfMaze,sizeOfMaze));
		findPath(sizeOfMaze,0,0,"");
		System.out.println(findPaths(sizeOfMaze,0,0,"").toString());
	}
	//approach is finding the count of path that are possible for reaching from position {n,n} to {1,1} in a 2D maze is same as {1,1} to {n,n}
	private static int countPaths(int row, int col) {
		if(row == 1 && col == 1) {
			return 1;
		}
		int r =0;
		int c=0;
		if(row > 0)
		r=countPaths(row-1, col);
		if(col > 0) c=countPaths(row, col-1);
		return r+c;
	}
	private static void findPath(int n,int row, int col,String path) {
		//as idx position starts from zero,zero
		if(row == n-1 && col == n-1) {
			System.out.println(path);
			return;
		}
		if(row < n) findPath(n,row+1,col,path+"D");
		if(col < n) findPath(n,row,col+1,path+"R");
	}
	//written in Array
	private static ArrayList<String> findPaths(int n,int row, int col,String path) {
		//as idx position starts from zero,zero
		if(row == n-1 && col == n-1) {
			ArrayList<String> p = new ArrayList<String>();
			p.add(path);
			return p;
		}
		ArrayList<String> ans = new ArrayList<String>();
		if(row < n) {
			ans.addAll(findPaths(n,row+1,col,path+"D"));
		}
		if(col < n)  {
			ans.addAll(findPaths(n,row,col+1,path+"R"));
		}
		return ans;
	}
	
}
