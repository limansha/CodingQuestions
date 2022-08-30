package com.ds.subSequence;

import java.util.ArrayList;

public class SubSequenceMain {
	//we say a string s1  is subsequence of string s only when s1 can be formed by the characters of string s which out change in order.
	//diff b/w subString and subSequence is the chanracters in s1 should be a continous block of chars for substring but for subsequence only order of char is requried not the continous block 
	//subset means order is also not maintained i.e for string s = abc subset has {ca also as a part though a comes first than c in string s }
	public static void main(String[] args) {
		//ArrayList<String> visited = new ArrayList<String>();
		PrintAllSubSequences pas = new PrintAllSubSequences();
//		pas.printSubSequence("", "aabc");
		//pas.printUniqueSubSequence("", "aabc",visited);
		//pas.printSpacesInBetween("","abc");
		System.out.println(pas.letterCasePermutation("ab").toString());
	}

}
