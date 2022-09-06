package com.ds.binarytrees;

import com.ds.binarytrees.pojo.TreeNode;

public class DiameterOfTree {
	static int res = 0;
	//number of nodes present in the longest path present between leaf nodes
	public static void main(String[] args) {
		
		TreeNode root = new TreeNode(new TreeNode(new TreeNode(new TreeNode(null,"D",null),"C",null),"B",new TreeNode(null,"F",null)),"A",
				new TreeNode(new TreeNode(new TreeNode(null,"H",null),"G" ,new TreeNode(null,"I",null)),"E",new TreeNode(null,"J",null)));
		
		TreeNode root1 = new TreeNode(new TreeNode(null,"2",null),"1",
				new TreeNode(new TreeNode(new TreeNode(new TreeNode(null,"9",null),"5",null),"4",null),"3",new TreeNode(null,"6",new TreeNode(null,"7",new TreeNode(null,"8",null)))));
		diameterOfTree(root);
		System.out.println(res);
	}

	private static int diameterOfTree(TreeNode root) {
		if(root == null) return 0; //BC
		
		int left = diameterOfTree(root.getLeft());
		int right = diameterOfTree(root.getRight());
		
		int temp = 1 + Math.max(left,right);
		
		int ans = Math.max(temp, 1 + left + right);
		res = Math.max(ans, res);
		
		return temp;
	}

}
