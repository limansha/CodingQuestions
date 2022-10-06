package com.ds.strings;

import java.util.ArrayList;

public class CompressStringLC443 {

	public static void main(String[] args) {
		ArrayList<String> input = new  ArrayList<String>();
		input.add("abbbbbbbbbbbbbbbbbbbbbb"); //ab21 - 4
		input.add("aaabbbbbbbbbbbbbbbbbb");//a3b18 - 5
		input.add("abcd"); //abcd - 4
		input.add("aabbccbbbddaaczcc"); //a2b2c2b3d2a2czc2 - 16
		for(int i=0;i<input.size();i++) {
			System.out.println(compressString(input.get(i).toCharArray()));
			System.out.println(compressStringReturnArrayList(input.get(i).toCharArray()).toString());
		}
	}
	private static ArrayList<Character> compressStringReturnArrayList(char[] str) {
		int index = 0;
		int i = 0;
		int j =i;
		while(i < str.length) {
			while(j < str.length && str[i] == str[j]){
				j++;
			}
			if(j-i > 1) {
				str[index++] = str[i];
				String count = j-i + "";
				for(char ch : count.toCharArray()) {
					str[index++] = ch;
				}
			}
			i = j;
		}
		ArrayList<Character> ans = new ArrayList<Character>();
		for(int k=0;k<index;k++) {
			ans.add(str[k]);
		}
		return ans;
	}
	//compress string inplace with O(1) space complexcity so can't use hashmap.only print the count if it occurs more than once  
	private static int compressString(char[] str) {
		int index = 0;
		int i = 0;
		int j =i;
		while(i < str.length) {
			while(j < str.length && str[i] == str[j]){
				j++;
			}
			if(j-i > 1) {
				str[index++] = str[i];
			}
			String count = j-i + "";
			for(char ch : count.toCharArray()) {
				str[index++] = ch;
			}
			i = j;
		}
		return index;
	}
}
