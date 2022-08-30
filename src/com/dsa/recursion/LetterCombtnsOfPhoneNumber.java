package com.dsa.recursion;

import java.util.ArrayList;
import java.util.HashMap;

public class LetterCombtnsOfPhoneNumber {

	static HashMap<Integer, String> book = new HashMap<Integer, String>();
	static ArrayList<String> res = new ArrayList<String>();

	public static void main(String[] args) {
		/*
		 * i/p: digits = "23" o/p: ["ad","ae","af","bd","be","bf","cd","ce","cf"]
		 */
		book.put(2, "abc");
		book.put(3, "def");
		book.put(4, "ghi");
		book.put(5, "jkl");
		book.put(6, "mno");
		book.put(7, "pqrs");
		book.put(8, "tuv");
		book.put(9, "wxyz");
		letterCombinations("", "234");
		System.out.println(res.toString());
	}

	public static void letterCombinations(String processed, String digits) {
		if (digits.isEmpty()) {
			System.out.println(processed);
			res.add(processed);
			return;
		}
		int ch = digits.charAt(0) - '0';
		String s = book.get(ch);
		for (int j = 0; j < s.length(); j++) {
			letterCombinations(processed + s.charAt(j), digits.substring(1));
		}
	}
}
