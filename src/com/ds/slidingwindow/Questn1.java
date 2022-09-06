package com.ds.slidingwindow;

public class Questn1 {
	static int res=0;
	public static void main(String[] args) {
		int [] arr = {6,2,3,4,5,5};
		int n = arr.length;
		findMaxScore(arr,0,n-1);
		System.out.println(res);
	}
	//nlogn time complexcity
	private static void findMaxScore(int[] arr, int s, int e) {
		if(s == e) return;
		int min = Integer.MAX_VALUE;
		int newStart =0;
		int newEnd = 0;
		int []left = new int[e+1];
		int  []right = new int[e+1];
		left[s] = arr[s];
		right[e] = arr[e];
		for(int i = s+1;i<=e;i++) {
			left[i] = left[i-1]+arr[i];
		}
		for(int i = e-1;i>=s;i--) {
			right[i] = right[i+1]+arr[i];
		}
		int value =0;
		for(int k = s; k<=e-1;k++) {
			int ls = left[k];
			int rs = right[k+1];
			int diff = Math.abs(ls-rs);
			//System.out.println(ls +" - "+rs + " = "+diff);
			//System.out.println("min "+ min+ "   diff  "+ diff);
			if(min >= diff) {
				min = diff;
				if(ls > rs) {
					newStart = k+1;
					newEnd = e;
					value = rs;
			//		System.out.println(newStart +" ......... "+newEnd + " $ "+value);
				}
				else {
					newStart = s;
					newEnd = k;
					value = ls;
				//	System.out.println(newStart +" ............"+newEnd + " $ "+value);
							
				}
			}
			else {
				continue;
			}
 		}
		res +=value;
		findMaxScore(arr,newStart,newEnd);
	}

}
