package com.thinklikecoder.tasks;

import java.util.Arrays;
import java.util.Stack;

public class Eposide7 {
	/*
	 * find the number of the boxes that can be filled with energy
	 * */
	public static void main(String[] args) {
		int []columns = new int[] {3,4,1,3,2}; //the maximum height of energy is 4
		//int []columns = new int[] {2,1,4,3,1}; //the maximum height of energy is 4
		
		//Algorithm
		/*
		 * take each column as reference and find the maximum element to its right and max element towards its left
		 * pick the value = min(left and right) and if the value > size of column at that pos then boxes filled can be value -column
		 * sum all the boxes at the end to find the number of boxes filled.
		 * */
		int n = columns.length;
		int []right = findMaxToRight(columns);
		System.out.println("right max : "+Arrays.toString(right));
		int []left = findMaxToLeft(columns);
		System.out.println("left max : "+Arrays.toString(left));
		int []min = new int[n];
		for(int i=0;i<n;i++) {
			min[i] = Integer.min(left[i], right[i]);
		}
		System.out.println("min value : "+Arrays.toString(min));
		int totalBoxes = 0;
		for(int i=0;i<n;i++) {
			int value = 0;
			if(min[i] > columns[i]) {
				value = min[i] - columns[i];
				totalBoxes += value;
			}
		}
		System.out.println("totalBoxes filled with Energy is :"+totalBoxes);
	}

	private static int[] findMaxToLeft(int[] columns) {
		Stack<Integer> s = new Stack<Integer>();
		int n = columns.length;
		int []res = new int[n];
		s.push(columns[0]);
		for(int i=0;i<n;i++) {
			if(s.peek() < columns[i]) {
				s.push(columns[i]);
			}
			res[i] = s.peek();
		}
		return res;
	}

	private static int[] findMaxToRight(int[] columns) {
		Stack<Integer> s = new Stack<Integer>();
		int n = columns.length;
		int []res = new int[n];
		s.push(columns[n-1]);
		for(int i=n-1;i>=0;i--) {
				if(s.peek() < columns[i]) {
					s.push(columns[i]);
				}
				res[i] = s.peek();
			}
		return res;
	}

}
