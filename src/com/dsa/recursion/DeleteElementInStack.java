package com.dsa.recursion;

import java.util.Stack;

public class DeleteElementInStack {

	public static void main(String[] args) {
		int k = 5;
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
//		deleteKthElementInStack(s,k);
//		System.out.println(s.toString());
		reverseStack(s);
		System.out.println(s.toString());
	}

	private static void reverseStack(Stack<Integer> s) {
		int n = s.size();
		if(n == 0) {
			return;
		}
		int temp = s.peek();
		s.pop();
		reverseStack(s);
		insertToBottom(s,temp);
	}

	private static void insertToBottom(Stack<Integer> s, int ele) {
		int n = s.size();
		if(n == 0) {
			s.push(ele);
			return;
		}
		int temp = s.pop();
		insertToBottom(s,ele);
		s.push(temp);
	}

	private static void deleteKthElementInStack(Stack<Integer> s, int k) {
		if(k > s.size()) {
			System.out.println("position "+ k+" doesn't exist in stack");
			return;
		}
		deleteElement(s,k-1);
	}

	private static void deleteElement(Stack<Integer> s, int k) {
		if(k == 0) {
			System.out.println("element removed from stack is "+ s.pop());
			return;
		}
		int temp = s.pop();
		deleteElement(s,k-1); //recursion is LIFO Last In first out as it uses stack 
		s.push(temp); 
	}
	

}
