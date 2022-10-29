package com.math;

public class SequenceFun {

	public static void main(String[] args) {
		// is sequence 2,5,16,65 formula f(n) = f(n-1) * n +1; first element i.e f(1) = 2
		System.out.println(NthTerm(4));
	}
	public static int NthTerm(int n)
	    {
	        long prev = 2L;
	        long i = 1;
	        long mod = 1000000007;
	        long term = 0L;
	        if(n == 1) return (int)prev;
	        while(++i <= n){
	            term = ((prev % mod * i % mod )+ 1) % mod;
	            prev = term;
	        }
	        return (int)term;
	    }
}
