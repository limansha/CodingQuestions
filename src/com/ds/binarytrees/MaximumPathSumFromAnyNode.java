package com.ds.binarytrees;

import com.ds.binarytrees.pojo.NodeInt;

public class MaximumPathSumFromAnyNode {
	static int res = 0;
	public static void main(String[] args) {
		NodeInt root = new NodeInt(new NodeInt(new NodeInt(null,20,null),2,new NodeInt(null,1,null)),10,
				new NodeInt(null,10,new NodeInt(new NodeInt(null,3,null),-25,new NodeInt(null,4,null))));
		MaxPathSumFromAnyNode(root);
		System.out.println("result : "+res);
	}

	private static int MaxPathSumFromAnyNode(NodeInt root) {
		if(root == null) return 0;
		
		int left = MaxPathSumFromAnyNode(root.getLeft());
		int right = MaxPathSumFromAnyNode(root.getRight());
		
		int temp = Math.max(Math.max(left, right) + root.getData(),root.getData()); //max possible value for each call so returning temp
		int ans = Math.max(temp, left + right + root.getData());
		res = Math.max(ans, res);
		return temp;
	}

}
