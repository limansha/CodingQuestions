package com.ds.strings;

import java.util.ArrayList;
import java.util.Arrays;

public class CountPermutationsOnConstraint {
//1) strings of length n that can be made using ‘a’, ‘b’ and ‘c’ with at-most one ‘b’ and one ‘c’ allowed
//2)  number of strings of length n that can be made using ‘a’, ‘b’ and ‘c’ with at-most one ‘b’ and two ‘c’s allowed.
	public static void main(String[] args) {
		int n =3;
		System.out.println(countStr1(n));
		
	}
	static long countStr1(long n)
	{
		long res =0;
		//for all a's in str is 1
		long a = factorial(n);
		long b = factorial(n-1);
		long c = factorial(n-2);
		res = 1 + 2 * (a / b) + (a / c);
		return res;
	}
	
		static long countStr2(long n)
		{
		    long c = 1;
		    c += 2*n;
		    c+=n * (n-1);
		    c+= (n * (n-1) * (n-2)) / 2;
		    c+=(n * (n-1)/2);
		    return c;
		}
	
	public static long factorial(long n) {
		if(n <= 1) return 1;
		return n * factorial(n-1);
	}

}
