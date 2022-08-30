package com.ds.subSequence;

import java.util.ArrayList;

public class PrintAllSubSequences {
	
	void printUniqueSubSequence(String processed,String unProcessed,ArrayList<String> visited) {
		if(unProcessed.isEmpty()) {
			if(!visited.contains(processed)) {
			visited.add(processed);
			
			//System.out.println(visited.toString());
			System.out.println(processed);
			}
			return;
		}
		char ch = unProcessed.charAt(0);
		printUniqueSubSequence(processed, unProcessed.substring(1),visited); //not taking character 
		printUniqueSubSequence(processed+ch, unProcessed.substring(1),visited); // taking character always reducing the unprocessed to 1 char
	}
	void printSubSequence(String processed,String unProcessed) {
		if(unProcessed.isEmpty()) {
			System.out.println(processed);
			return;
		}
		char ch = unProcessed.charAt(0);
		printSubSequence(processed, unProcessed.substring(1)); //not taking character 
		printSubSequence(processed+ch, unProcessed.substring(1)); // taking character always reducing the unprocessed to 1 char
	}
	
	void printSpacesInBetween(String processed,String unProcessed) {
		if(unProcessed.isEmpty()) {
			System.out.println(processed);
			return;
		}
		char ch = unProcessed.charAt(0);
		if(unProcessed.length() > 1) printSpacesInBetween(processed+ch+"#", unProcessed.substring(1)); 
		printSpacesInBetween(processed+ch, unProcessed.substring(1)); 
		
	}
	 ArrayList<String> result = new ArrayList<String>();
	    public ArrayList<String> letterCasePermutation(String s) {
	        printPermutedCasesOfString("",s.toLowerCase());
	        return result;
	    }
	    void printPermutedCasesOfString(String processed,String unProcessed) {
			if(unProcessed.isEmpty()) {
	            result.add(processed);
				//System.out.println(processed);
				return;
			}
			String ch = unProcessed.substring(0, 1);
			
			printPermutedCasesOfString(processed+ch, unProcessed.substring(1)); 
			if(!(ch.charAt(0) >= '0' && ch.charAt(0) <= '9')) printPermutedCasesOfString(processed+ch.toUpperCase(), unProcessed.substring(1)); 
			
		}
}
