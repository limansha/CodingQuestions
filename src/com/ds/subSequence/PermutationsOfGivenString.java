package com.ds.subSequence;

public class PermutationsOfGivenString {

	public static void main(String[] args) {
		String str = "abc";
		permutations("",str);
		System.out.println(permutationCount("",str));
		System.out.println(factorial(str.length()));//using formula we can find in order of 1
	}

	private static int factorial(int length) {
		if(length == 0 || length ==1) return 1;
		return length * factorial(length-1);
	}

	static void permutations(String processed,String unprocessed) {
		if(unprocessed.isEmpty()) {
			System.out.println(processed);
			return;
		}
		char ch = unprocessed.charAt(0);
		int n = processed.length();
		for(int i=0;i<=n;i++) {
			String f = processed.substring(0,i);
			String s = processed.substring(i,n);
			permutations(f+ch+s,unprocessed.substring(1));
		}
	}
	
	static int permutationCount(String processed,String unprocessed) {
		if(unprocessed.isEmpty()) {
			//System.out.println(processed);
			return 1;
		}
		char ch = unprocessed.charAt(0);
		int n = processed.length();
		int count =0;
		for(int i=0;i<=n;i++) {
			String f = processed.substring(0,i);
			String s = processed.substring(i,n);
			count += permutationCount(f+ch+s,unprocessed.substring(1));
		}
		return count;
	}
}
