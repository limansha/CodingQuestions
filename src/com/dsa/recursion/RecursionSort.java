package com.dsa.recursion;

import java.util.ArrayList;
import java.util.Stack;

public class RecursionSort {
//sorting an array Using recursion
		public static void main(String[] args) {
		ArrayList<Integer> nums = new ArrayList<Integer>();
		nums.add(3);
		nums.add(8);
		nums.add(9);
		nums.add(6);
		nums.add(1);
		nums.add(3);
		sort(nums);
		System.out.println(nums.toString());
		Stack<Integer> s = new Stack<Integer>();
		s.push(6);
		s.push(4);
		s.push(3);
		s.push(2);
		s.push(7);
		s.push(38);
		s.push(39);
		s.push(43);
		s.push(53);
		sortStack(s);
		System.out.println(s.toString());
	}
	
	public static void sort(ArrayList<Integer> arr) {
		int n = arr.size();
		if(n==1) return;
		int temp =  (int)arr.remove(n-1);
		//System.out.println(arr.toString());
		sort(arr);
		insert(arr,temp);
	}
	public static void insert(ArrayList<Integer> arr,int value) {
		int n = arr.size();
		if(n == 0 || arr.get(n-1) <= value) {
			arr.add(n, value);
			return;
		}
		int temp = arr.remove(n-1);
		insert(arr,value);
		arr.add(temp);
	}
//sorting on stack
	//try creating recursion tree and check for small i/p [3 2 1]
	public static void sortStack(Stack<Integer> s) {
		int n = s.size(); 
		if(n == 1) return; //if only one element its already sorted
		int temp = s.pop(); 
		sortStack(s); //into the sorted list insert the temp value into its correct position
		insertIntoStack(s,temp);
	}

	private static void insertIntoStack(Stack<Integer> s, int value) {
		int n = s.size();
		if(n == 0 || s.peek() <= value) {
			s.push(value);
			return;
		} 
		//the value is smaller than top so need to be placed into its correct position
		int temp = s.pop(); 
		insertIntoStack(s, value);
		s.push(temp); 
	}
}
