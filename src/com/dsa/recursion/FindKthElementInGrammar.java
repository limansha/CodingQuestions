package com.dsa.recursion;

public class FindKthElementInGrammar {

	public static void main(String[] args) {
		/**
		 * Grammar is like this 
		 * n = 1 : 0
		 * n = 2 : 0 1
		 * n = 3 : 0 1 1 0
		 * n = 4 : 0 1 1 0 1 0 0 1
		 * n = 5 : 0 1 1 0 1 0 0 1|1 0 0 1 0 1 1 0 
		 */
		//find the kth element in the nth sequence i.e for n=5 k= 5 ans = 1 for k = 7 ans = 0
		/*
		 * for n-1th row there will be 2^n elements
		 * for nth row there will be 2^n elements therefore each time n increased by 1 size of i/p is doubling itself by filling the remaining columns as complement of n-1 row columns 
		 * check n= 3 and n= 4 
		 * */
		/*
		 * we need to return element at kth position in nth row so elements from 0 to size(n)/2 will be exactly same as n-1 row elements
		 * from size(n)/2 + 1 till size(n) will be reverse of n-1th row elements (size(n-1)-(k-mid))
		 * */
		
		int n = 5;
		int k = 7;
		// find the element at position k by observing the grammar . no need to create grammar for this question
		System.out.println(solve(n,k));
	}

	private static int solve(int n, int k) {
		if(n == 0 || k == 1) return 0;
		int mid = (int) (Math.pow(2, n-1)/2);
		if(k <= mid) {
			return solve(n-1,k);
		}
		else {
			return (solve(n-1,k-mid)== 0) ? 1 : 0;
		}
	}

}
