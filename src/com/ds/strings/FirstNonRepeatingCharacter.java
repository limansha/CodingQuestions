package com.ds.strings;

import java.util.HashMap;
import java.util.Map.Entry;

public class FirstNonRepeatingCharacter {

	public static void main(String[] args) {
		String str = "abacabad";
		char ans = firstNonRepeatingChar(str);
		System.out.println(ans);
	}

	private static char firstNonRepeatingChar(String str) {

		HashMap<Character,Integer> hm = new HashMap<Character,Integer>();
		for(int i=0;i<str.length();i++) {
			hm.put(str.charAt(i),hm.getOrDefault(str.charAt(i), 0)+1);
		}
		for(Entry<Character, Integer> e: hm.entrySet()) {
			if(e.getValue() == 1) return e.getKey();
		}
		
		return '_';
	}

}
