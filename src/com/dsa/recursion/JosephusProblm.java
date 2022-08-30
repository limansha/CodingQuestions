package com.dsa.recursion;

import java.util.ArrayList;

public class JosephusProblm {

	public static void main(String[] args) {
		int n = 5;
		int k = 3;
		ArrayList<Integer> persons = new ArrayList<Integer>();
		for(int i =1;i<n+1;i++) persons.add(i);
		System.out.println(solve(persons,k-1,0));
	}

	private static int solve(ArrayList<Integer> persons, int k, int idx) {
		int n = persons.size();
		if(n == 1) {
			//System.out.println(persons.get(0));
			return persons.get(0);
		}
		idx = (idx + k)%n;
		persons.remove(idx);
		return solve(persons,k,idx);
		
	}
	
}
