package com.ds.binarytrees;

import java.util.HashMap;

import com.ds.binarytrees.pojo.NodeInt;

public class CreatePreInorder {

	public static void main(String[] args) {
		int n = 6;
		int []inorder = new int[] {40,20,50,10,60,30};
		int []preodr = new int[] {10,20,40,50,30,60};
		int is = 0;
		int ps = 0;
		int ie = n-1;
		int pe = n-1;
		HashMap<Integer, Integer> hm = new HashMap<Integer, Integer>();
		for(int i =0;i<n;i++) {
			hm.put(inorder[i], i); //storing the index of the values
		}
		 NodeInt tree = createTree(inorder,is,ie,preodr,ps,pe,hm);
		 System.out.println(tree.getData());

	}
	private static NodeInt createTree(int[] inorder, int is, int ie, int[] preodr, int ps, int pe,
			HashMap<Integer, Integer> hm) {
				if(is > ie || ps >pe ) return null;
				int ele = preodr[ps];
				int rootAt = hm.get(ele);
				NodeInt l = createTree(inorder,is,rootAt-1,preodr,ps+1,ps+rootAt,hm);
				NodeInt r = createTree(inorder,rootAt+1,ie,preodr,ps+rootAt+1,pe,hm);
				NodeInt n  = new NodeInt(l,ele,r);
				return n;

	}

}