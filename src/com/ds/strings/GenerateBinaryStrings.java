package com.ds.strings;

import java.util.ArrayList;
import java.util.List;

public class GenerateBinaryStrings {

	public static void main(String[] args) {
		String value = "11110?";
		List<String>res = generate_binary_string(value);
		System.out.println(res.toString());
	}
	public static List<String>generate_binary_string(String s)
    {
        List<String> result = new ArrayList<String>();
        int len = s.length();
		ArrayList<Integer> idx = new ArrayList<Integer>();
		for(int i =0;i<len;i++) {
			if(s.charAt(i)== '?') {
				idx.add(i);
			}
		}
		int c = idx.size();
		if(c > 0){
		int n = (int) Math.pow(2, c);
		String s1[] = new String[n];
		for(int i=0;i<n;i++) {
			s1[i] = Integer.toBinaryString(i);
		
		}
		for(int i=0;i<n;i++) {
			int d = s1[i].length();
			int z = c - d;
			StringBuilder str = new StringBuilder();
			str.append(s.substring(0, idx.get(0)));
			int k =0;
			for(int j =1;j<c;j++) {
				if(z-- > 0 )str.append("0");
				else{
					str.append(s1[i].charAt(k++));
				}
				str.append(s.substring(idx.get(j-1)+1, idx.get(j)));
			}
			if(z-- > 0 )str.append("0");
			else{
				str.append(s1[i].charAt(k++));
			}
			str.append(s.substring(idx.get(c-1)+1,len));
			result.add(str.toString());
		}
		}
		else {
		    result.add(s);
		}
        return result;
    }

}
