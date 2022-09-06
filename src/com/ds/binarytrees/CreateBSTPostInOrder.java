package com.ds.binarytrees;


import java.util.HashMap;

import com.ds.binarytrees.pojo.NodeInt;

public class CreateBSTPostInOrder {

	public static void main(String[] args) {
		int n = 6;
		int []inorder = new int[] {40,20,50,10,60,30};
		int []postodr = new int[] {40,50,20,60,30,10};
		int is = 0;
		int ps = 0;
		int ie = n-1;
		int pe = n-1;
		HashMap<Integer, Integer> hm = new HashMap<Integer, Integer>();
		for(int i =0;i<n;i++) {
			hm.put(inorder[i], i); //storing the index of the values
		}
		 NodeInt tree = createTree(inorder,is,ie,postodr,ps,pe,hm);
		 System.out.println(tree.getData());
	}

	private static NodeInt createTree(int[] inorder, int is, int ie, int[] postodr, int ps, int pe,
			HashMap<Integer, Integer> hm) {
		if(is>ie || ps > pe ) return null;
		int element = postodr[pe];
		int rootAt = hm.get(element);
		int numsleft = rootAt - is;
		NodeInt l = createTree(inorder,is,rootAt-1,postodr,ps,ps+numsleft-1,hm);
		NodeInt r = createTree(inorder,rootAt+1,ie,postodr,ps+numsleft,pe-1,hm);
		NodeInt n = new NodeInt(l,element,r);
		return n;
	}

}
