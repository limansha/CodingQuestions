package com.thinklikecoder.tasks;

/*
 * Steal node of power 
 * 
 * It is present in a train which is 10 boxes away from pole where we steal it but the movement of the train is back and forth
 *  so people inside will not know where there box is now . so we need to identify when the box of the power comes under the pole
 * */
public class Eposide4 {

	public static void main(String[] args) {
		// take pole as zero and box is now at 10 on the number line 
		// when moved front -1 as its going near to pole and when
		// moved back add 1 do it until the box value becomes zero when its zero press the button
		int [] trainMovementSeq = new int[] {-1,2,3,4,-3,-4,5,10,-10,1,-2,-5,-10,13,12,-21};
		int box = 10;
		//ans 12th movement box comes under pole
		for(int i=0;i<trainMovementSeq.length;i++) {
			box += trainMovementSeq[i];
			if(box == 0) {
				System.out.println("box comes unde rthe pole that is zero at "+ i + " train movement");
				break;
			}
					
		}
	}

}
