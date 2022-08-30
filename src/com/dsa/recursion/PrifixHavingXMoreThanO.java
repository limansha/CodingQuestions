package com.dsa.recursion;

import java.util.ArrayList;

public class PrifixHavingXMoreThanO {
	static ArrayList<String> result = new ArrayList<String>();

	public static void main(String[] args) {
		// Print N-bit binary numbers having more 1’s than 0’s for any prefix
		/*
		 * Ex: 111101 valid prefixes are 111101 11110 1111 111 11 1 #1 > #0
		 */
		int n = 5;
		System.out.println(NBitBinary(n).toString());
	}

	static ArrayList<String> NBitBinary(int n) {
		solve(1, 0, n - 1, "1"); 
		return result;
	}

	static void solve(int ones, int zeros, int n, String processed) {
		if (n == 0) {
			// System.out.println(processed);
			result.add(processed);
			return;
		}
		solve(ones + 1, zeros, n - 1, processed + "1");
		if (ones > zeros) {
			solve(ones, zeros + 1, n - 1, processed + "0");
		}
	}
}
