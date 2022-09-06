package com.ds.binarytrees.pojo;


public class TreeNode {
	TreeNode left;
	String data;
	TreeNode right;
	
	
	public TreeNode(TreeNode left, String data, TreeNode right) {
		super();
		this.left = left;
		this.data = data;
		this.right = right;
	}

	public TreeNode getRight() {
		return right;
	}

	public String getData() {
		return data;
	}

	public TreeNode getLeft() {
		return left;
	}
}
