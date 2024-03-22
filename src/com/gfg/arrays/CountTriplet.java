package com.gfg.arrays;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;
// a + b = c such that a,b,c belongs to the given array 
//countTriplet takes array and size of array
public class CountTriplet {
	public static int countTriplet(Integer arr[], int s)
	{
		int n = arr.length;
		//sorted using bubble sort
		for(int i = 1;i<n;i++) {
			for(int j = i;j > 0;j--) {
				if(arr[j-1] < arr[j]) {
						int temp = arr[j-1];
						arr[j-1] = arr[j];
						arr[j] = temp;
				}
			}
		}
		//sorted in descending order
		System.out.println(Arrays.toString(arr));
		int count = 0;
		//then perform twoSum problem on each element and remaining array
	   for(int i=0;i<n;i++){
		  count += sum2(arr,i,arr[i],n);
	    }
	   return count;
	}
	public static int countTriplet2(Integer arr[], int s)
	{
		int n = arr.length;
		//sort using Compartor in  desc note that the arr shouldn't be on primitive int rather should be Integer class
		Arrays.sort(arr, Comparator.reverseOrder());
		//sorted in descending order
		System.out.println(Arrays.toString(arr));
		int count = 0;
		//then perform twoSum problem on each element and remaining array
	   for(int i=0;i<n;i++){
		  count += sum2(arr,i,arr[i],n);
	    }
	   return count;
	}
	
	public static int sum2(Integer[] a,int pos,int s,int n) {
		 HashMap<Integer,Integer> hm = new HashMap<Integer,Integer>();
		 int c = 0;
		 for(int i=pos;i<n;i++){
			   int remaining = s - a[i];
		       if(hm.keySet().contains(remaining)) {
		    	   System.out.println(s+" "+a[i] + " "+ remaining);
		    	   c++;
		       }
		       hm.put(a[i],i);
		   }
		 return c;
	}
	public static void main(String args[]) {
		Integer arr[] = {14,3,6,8,11,16};
		System.out.println(countTriplet(arr,6));
		System.out.println(countTriplet2(arr,6));
	}
}
