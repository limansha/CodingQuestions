package com.dsa.recursion;

import java.util.ArrayList;

public class GenerateBalanceParanthesis {

	ArrayList<String> comtns = new ArrayList<String>();
	public static void main(String[] args) {
		//n = 2 will have 4 positions in String and balanced sequence is ()() ,(()).
		int n= 2;
		GenerateBalencedParanthesis(n,n,"");
	}
	//draw the recursion tree and figure out the conditionals 
	public static void GenerateBalencedParanthesis(int open ,int close,String processed) {
		if(open == 0 && close == 0) {
			System.out.println(processed);
			return;
		}
	
			if(open != 0) {
				GenerateBalencedParanthesis(open-1,close,processed+"(");
			}
			if(close > open) {
				GenerateBalencedParanthesis(open,close-1,processed+")");
			}
	}
	
}
