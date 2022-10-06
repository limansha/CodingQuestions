package com.ds.strings;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map.Entry;

public class EditDistance {
	    public static void main(String[] args) throws IOException {
	        BufferedReader br =
	            new BufferedReader(new InputStreamReader(System.in));
	        int T = Integer.parseInt(br.readLine().trim());
	        while (T-- > 0) {
	            String s1 = br.readLine();
	            String[] S = s1.split(" ");
	            String s = S[0];
	            String t = S[1];
	            Solution ob = new Solution();
	            int ans = ob.editDistance(s, t);
	            System.out.println(ans);
	        }
	    }
}


class Solution {
	 public int editDistance(String s, String t) {
	
	        HashMap<Character,Integer> hm1 = new HashMap<Character,Integer>();
	        HashMap<Character,Integer> hm2 = new HashMap<Character,Integer>();
	        for(int i=0;i<s.length();i++){
	            hm1.put(s.charAt(i),hm1.getOrDefault(s.charAt(i),0)+1);   
	        }
	        for(int i=0;i<t.length();i++){
	            hm2.put(t.charAt(i),hm2.getOrDefault(t.charAt(i),0)+1);   
	        }
	        int c = 0;
	        while(!hm1.equals(hm2)) {
	        if(hm1.size() >= hm2.size()){
	            for(Entry<Character, Integer> e: hm1.entrySet()){
	                if(hm2.containsKey(e.getKey())){
	                    if(e.getValue() > hm2.get(e.getKey())){
	                    hm2.put(e.getKey(),hm2.get(e.getKey())+1);
	                    c++;
	                }
	                    else if(e.getValue() < hm2.get(e.getKey())){
	                        hm2.put(e.getKey(),hm2.get(e.getKey())-1);
	                        c++;
	                    }
	            }
	            else{
	                    c++; //not there insert into hm2
	                    hm2.put(e.getKey(),1);
	                }
	            }   
	        }
	        else{
	            for(Entry<Character,Integer> e: hm2.entrySet()){
	                if(hm1.containsKey(e.getKey())){
	                    if(e.getValue() > hm1.get(e.getKey())){
	                    hm1.put(e.getKey(),hm1.get(e.getKey())+1);
	                    c++;
	                }
	                else if(e.getValue() < hm2.get(e.getKey())){
	                        hm1.put(e.getKey(),hm1.get(e.getKey())-1);
	                        c++;
	                    }
	            }
	            else{
	                    c++; //not there insert into hm2
	                    hm1.put(e.getKey(),1);
	                }
	            }
	        }
	    }
	        System.out.println(hm1.equals(hm2));
	       System.out.println(hm1.toString());
	       System.out.println(hm2.toString());
	        return c;
	    }
    
}

