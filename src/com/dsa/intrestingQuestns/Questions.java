package com.dsa.intrestingQuestns;

import java.io.*;
import java.util.*;

class Questions {
    public static void main(String args[]) throws IOException {
        BufferedReader read =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            int n = Integer.parseInt(read.readLine());
            Solution ob = new Solution();
            ArrayList<String> result = ob.NBitBinary(n);
            for(String value  : result){
                System.out.print(value + " ");
            }
            System.out.println();
        }
    }
}
class Solution {
    ArrayList<String> NBitBinary(int N) {
        StringBuilder sb = new StringBuilder();
        ArrayList<String> ans = new ArrayList<String>();
        sb.append("1");
        helper(ans,1,0,sb,N);
        Collections.sort(ans,Collections.reverseOrder());
        return ans;
    }
    void helper(ArrayList<String> ans,int ones,int zeros,StringBuilder sb,int n){
        if(sb.length() == n){
            ans.add(sb.toString());
            return;
        }
        if(ones > zeros){
            sb.append("0");
            helper(ans,ones,zeros+1,sb,n);
            sb.deleteCharAt(sb.length()-1);
        }
        sb.append("1");
        helper(ans,ones+1,zeros,sb,n);
        sb.deleteCharAt(sb.length()-1);
    }
}