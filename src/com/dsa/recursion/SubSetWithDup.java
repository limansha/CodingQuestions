package com.dsa.recursion;

public class SubSetWithDup {

	public static void main(String[] args) {
		String s = "pwwkew";
		int N = s.length();
		int sum = 0;
		int max = 0;
		String sub = s.charAt(0)+"";
	
		for (int i = 1; i < N; i++) {
			char ch = s.charAt(i);
			if (sub.indexOf(ch) >= 0) {
				max = Math.max(max, sum);
				sub = "";
				sum =0;
			}
			
			sub += ch;
			System.out.println(sub);
			sum++;
		}
		System.out.println(max);
	}

}
