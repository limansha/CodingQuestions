package com.ds.general;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.PriorityQueue;
import java.util.Queue;

public class KLargestElements {

	public static void main(String[] args) {
		int N = 5;
		int k = 2;
		int arr[] = {12,5,787,1,23};
		int N1 = 5;
		int Arr[] = {3, 2, 4, 6, 5};
		ArrayList<Integer> res = kLargest(arr,N,k);
		System.out.println(res.toString());
		if(checkTriplet(Arr,N1)) System.out.println("Triplet");
		else System.out.println("Not Triplet");
	}
	public static ArrayList<Integer> kLargest(int arr[], int n, int k)
    {
       Queue<Integer> q = new PriorityQueue<Integer>(Collections.reverseOrder());
      
       for(int i=0;i<n;i++) {
    	   q.add(arr[i]);
       }
       ArrayList<Integer> ans = new ArrayList<Integer>();
       for(int i=0;i<k;i++) {
    	   ans.add(q.poll());
       }
	return ans;
    }
	 static boolean checkTriplet(int[] arr, int n) {
		 //https://practice.geeksforgeeks.org/problems/pythagorean-triplet3018/1
		
		 Arrays.sort(arr);
	        for(int k =n -1 ; k >= 2 ;k--){
	            int right = arr[k]*arr[k];
	            int i =0;
	            int j = k-1;
	            while(i < j){
	                int left = (arr[i] * arr[i]) + (arr[j]*arr[j]);
	                if(left == right) return true;
	                else if(left < right) i++;
	                else if(left > right) j--;
	            }
	        }
	        return false;
		
	    }
}
