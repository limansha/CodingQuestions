package com.dsa.recursion;

public class RollDiceWithTargetSum {

	public static void main(String[] args) {
		//find the sequence of dice throwed that result in target 3
		//1 2 
		//2 1
		// 1 1 1
		//3
		int target = 4;
		dice("",target);
	}

	private static void dice(String processed, int target) {
		if(target == 0) {
			System.out.println(processed);
			return;
		}
		for(int i = 1;i<=6 && i <=target;i++) {
			dice(processed+i,target-i);
		}
	}
	

}
