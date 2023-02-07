package com.thinklikecoder.tasks;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map.Entry;

public class Eposide6 {
	
	//make a bridge - for a bridge to be stable it should be palindromic (that to odd palindrome)
	public static void main(String[] args) {
		char []blocks1 = new char[] {'A','A','B','B','C'};
		char []blocks2 = new char[] {'A','A','B','B','C','C'};
		char []blocks4 = new char[] {'A','A','B','B','C','C','L','M','M','M'};
		char []blocks3 = new char[] {'A','A','B','B','C','C','A','A','C','C','B','B','Z','Z','Z'};
		char[][] bridges = new char[][] {blocks1,blocks2,blocks3,blocks4};
		//print arrangement of blocks in palidrome if possible. condtn : use all the blocks
		
		//based on observation for any sequence to be an odd palindrome with n blocks the occurance of n-1 characters 
		//should be even and atmost 1 character occurance should be odd
	for(char []block : bridges) {
		System.out.println("Input block : "+Arrays.toString(block));
		if(isBridgePossible(block)) {
			//printBridge(block);
		}
		else {
			System.out.println("Bridge not possible for "+Arrays.toString(block));
		}
		System.out.println();
	}
	}

	private static void printBridge(char[] block) {
		System.out.println(Arrays.toString(block));
	}

	private static boolean isBridgePossible(char[] block) {
		HashMap<Character,Integer> blockCount = new HashMap<Character,Integer>();
		for(char b:block) {
			if(blockCount.containsKey(b)) {
				blockCount.put(b, blockCount.get(b)+1);
			}else {
				blockCount.put(b,1);
			}
		}
		//System.out.println("Dictionary : "+blockCount.toString());
		int oddOcc = 0;
		Character oddCh = null;
		for(Entry<Character, Integer> e: blockCount.entrySet()) {
			if(e.getValue() % 2 == 1) {
				oddOcc++;
				oddCh = e.getKey();
			}
		}
		//
		System.out.println(oddOcc+" "+oddCh);
		if(oddOcc <= 1) {
			int n = block.length-1;
			int idx  = 0;
			//one way of palindrome
//			while(n >= idx) {
//			for(Entry<Character, Integer> e: blockCount.entrySet()) {
//				if(e.getValue() >= 1) {
//					blockCount.put(e.getKey(),e.getValue()-2);
//					block[idx] = e.getKey();
//					block[n] = e.getKey();
//					idx++;
//					n--;
//				}
//			}
//			}
//second way of palindrome
			int flag = 0;
			for(Entry<Character, Integer> e: blockCount.entrySet()) {
					if(e.getValue() >= 1) {
						int mid = e.getValue() / 2;
						while(mid > 0) {
						block[idx] = e.getKey();
						block[n] = e.getKey();
						idx++;
						n--;
						mid = mid-2;
						}
						if(e.getValue() % 2 == 1) flag =1;
					}
				}
			if(flag == 1) {
				int i = block.length/2;
				//System.out.println(flag + " "+ i );
				block[i] = oddCh;
			}
			System.out.println("Palindrome Bridge : "+ Arrays.toString(block));
			return true;
		}
		return false;
	}
	
}
