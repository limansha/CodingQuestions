package com.ds.slidingwindow;

import java.util.HashMap;
import java.util.Map.Entry;
import java.util.Set;

public class OccuranceOfAnagram {

	public static void main(String[] args) {
		System.out.println(search("for","forxxorfxdofr"));
	}

    static int search(String pat, String txt) {
        HashMap<Character,Integer> hm = new HashMap<Character,Integer>();
        HashMap<Character,Integer> hm1 = new HashMap<Character,Integer>();
        int p = pat.length();
        //creating the map for the pat
        for(int i =0;i<p;i++){
           char ch =pat.charAt(i);
           int value  = hm.getOrDefault(ch, 0) + 1;
           hm.put(ch, value);
        }
        //System.out.println(hm.toString());
        int count = hm.size();
        int ans = 0;
        int N = txt.length();
        int j =0;
        int i =0;
        
        Set<Character> keys = hm.keySet();

 	   while(j < N){
     	   char ch =txt.charAt(j);
     	   if(hm.containsKey(ch)) {
     		   int value  = hm1.getOrDefault(ch, 0) + 1;
                hm1.put(ch, value);
     	   }
            if(j-i+1 == p) {
                Set<Character> ks = hm1.keySet();
                if(ks.equals(keys)) {
             	   boolean flag = false;
                    for(char k :keys) {
             		   if(hm.get(k) != hm1.get(k)) {
             			   flag = true;
             			   break;
             		   }
             	   }
                    if(!flag) ans++;
                }
                char pch =txt.charAt(i);
                if(hm1.get(pch)!= null) {
             	  int v = hm1.get(pch);
             	  v--;
             	  hm1.put(pch, v);
                }
         	   i++;
            }
            j++;
        }
        return ans;
    }
}
