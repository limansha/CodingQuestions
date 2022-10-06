package com.ds.general;

public class GfGSolution {
	/*
	 * Find the largest Jumping Number smaller than or equal to X. Jumping Number: A
	 * number is called Jumping Number if all adjacent digits in it differ by only
	 * 1. All single digit numbers are considered as Jumping Numbers. For example 7,
	 * 8987 and 4343456 are Jumping numbers but 796 and 89098 are not.
	 */

	public static void main(String[] args) {
		System.out.println(jumpingNums(89098));
	}

	static long jumpingNums(long X) {
		while (X > 0) {
			if (isJumpNo(X))
				return X;
			X = X - 1;
		}
		return -1;
	}

	static boolean isJumpNo(long X) {
		int dgt = (int) Math.log10(X) + 1;
		if (dgt == 1)
			return true;
		int[] num = new int[dgt + 1];
		int d = dgt - 1;
		while (X > 0) {
			num[d] = (int) X % 10;
			X = X / 10;
			d = d - 1;
		}
		for (int i = 0; i < dgt - 1; i++) {
			if (Math.abs(num[i] - num[i + 1]) != 1)
				return false;
		}
		return true;
	}
}
