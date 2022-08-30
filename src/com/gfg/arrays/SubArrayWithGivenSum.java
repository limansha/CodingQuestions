package com.gfg.arrays;

import java.util.ArrayList;

public class SubArrayWithGivenSum {
	public static void main(String[] args) {
		int [] arr= {1,2,3,7,5};
		int n = arr.length;
		int s = 12;
		System.out.println(subarraySum(arr,n,s).toString());
	}
	static ArrayList<Integer> subarraySum(int[] arr, int n, int s) 
    {
        
        ArrayList<Integer> res = new ArrayList<Integer>();  
        if(s == 0) { //as the given array has all positive integers and s can't be zero
            res.add(-1);
            return res;
        }
      int end = 0;
      int start = 0;
      int sum =0;
        while(end <= n && start < n){
           if(sum == s){
                res.add(start+1);
                res.add(end);
                break;
            }
            else if(end < n && sum < s){
                sum+=arr[end++];
            }
            else if(sum > s){
                sum -=arr[start++];
            }
            else if(end == n && sum != s) break;
        }
        if(res.isEmpty()) res.add(-1);
        return res;
    }
}