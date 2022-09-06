package com.ds.binarytrees;

import com.ds.binarytrees.pojo.NodeInt;

public class MaximumPathSumFromLeafs {
	static int res = 0;
	public static void main(String[] args) {
		NodeInt root = new NodeInt(new NodeInt(new NodeInt(null,20,null),2,new NodeInt(null,1,null)),10,
				new NodeInt(null,10,new NodeInt(new NodeInt(null,3,null),-25,new NodeInt(null,4,null))));
		MaxPathSumFromLeaf(root);
		System.out.println("result : "+res);
	}
	private static int MaxPathSumFromLeaf(NodeInt root) {
if(root == null) return 0;
		
		int left = MaxPathSumFromLeaf(root.getLeft());
		int right = MaxPathSumFromLeaf(root.getRight());
		int temp =0;
		if(root.getLeft() == null && root.getRight() == null) {
			temp = root.getData();
		}
		else {
			temp = Math.max(left, right) + root.getData();
		}
		
		int ans = Math.max(temp, left + right + root.getData());
		res = Math.max(ans, res);
		return temp;
	}

}
