package com.ds.binarytrees;

import com.ds.binarytrees.pojo.TreeNode;

public class DFSTraversal {

	public static void main(String[] args) {
		
			TreeNode root = new TreeNode(new TreeNode(new TreeNode(new TreeNode(null,"D",null),"C",null),"B",new TreeNode(null,"F",null)),"A",
					new TreeNode(new TreeNode(new TreeNode(null,"H",null),"G" ,new TreeNode(null,"I",null)),"E",new TreeNode(null,"J",null)));
	preOrder(root);//root left right
	System.out.println();
	System.out.println("*****************************");
	inOrder(root); // left root right
	System.out.println();
	System.out.println("*****************************");
	postOrder(root); // left right root
	}

	private static void postOrder(TreeNode root) {
		if(root == null) return;
		postOrder(root.getLeft());
		postOrder(root.getRight());
		System.out.print(root.getData() + " ");
		
	}

	private static void inOrder(TreeNode root) {
		if(root == null) return;
		inOrder(root.getLeft());
		System.out.print(root.getData()+ " ");
		inOrder(root.getRight());
	}

	private static void preOrder(TreeNode root) {
		if(root == null) return;
		System.out.print(root.getData()+ " ");
		preOrder(root.getLeft());
		preOrder(root.getRight());
		
	}

}
