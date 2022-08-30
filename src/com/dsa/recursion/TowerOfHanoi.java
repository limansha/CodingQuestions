package com.dsa.recursion;

public class TowerOfHanoi {

	public static void main(String[] args) {
	//print all the steps to build tower Of Hanoi for given n
		//toh(int plates,String s,String h,String d)
		toh(3,"source","intermediate","destination");
	}
//(2^n)-1 steps are requried
	//picking one plate at a time
	//larger plate can't be placed on smaller plate
	private static void toh(int n, String s, String h, String d) {
		//bc while having only one plate
		if(n == 1) {
			System.out.println("Moving plate-"+ n +" from "+s +" -> "+ d);
			return;
		}
		//hypothesis
		toh(n-1,s,d,h);// as all n-1 plates moved to intermideate rod source will have only one plate left and we move it to destination
		System.out.println("Moving plate-"+ n +" from "+s +" -> "+ d);
		//now we need to call method to  move the intermidate toh to destination d via source
		toh(n-1,h,s,d);
	}

}
