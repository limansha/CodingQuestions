package com.ds.binarytrees;

import com.ds.binarytrees.pojo.TreeNode;

public class isBalancedBinaryTree {

	public static void main(String[] args) {
		// TUF 15
		TreeNode root = new TreeNode(new TreeNode(new TreeNode(new TreeNode(null,"D",null),"C",null),"B",new TreeNode(null,"F",null)),"A",
				new TreeNode(new TreeNode(new TreeNode(null,"H",null),"G" ,new TreeNode(null,"I",null)),"E",new TreeNode(null,"J",null)));
		
		TreeNode root1 = new TreeNode(new TreeNode(new TreeNode(new TreeNode(null,"D",null),"C",null),"B",new TreeNode(null,"F",null)),"A",
				new TreeNode(null ,"E",null));
				
		if(isBalanced(root1)) {
				System.out.println("balanced");
			}
			else {
				System.out.println("not balanced");
			}
	}

	private static boolean isBalanced(TreeNode root) {
		int left = lengthOfBT(root.getLeft()); //check for max height in left tree
		int right = lengthOfBT(root.getRight()); //check for max height in right tree
		return Math.abs(left - right) <= 1 ? true : false;
	}

	private static int lengthOfBT(TreeNode node) { // to check depth of the tree i.e height
		if(node == null) return 0;
		return 1 + Math.max(lengthOfBT(node.getLeft()) , lengthOfBT(node.getRight()));
	}

}
