package com.ds.binarytrees;

import com.ds.binarytrees.pojo.NodeInt;

public class FlattenBinaryTreeToLinkedList {
	static NodeInt tree = new NodeInt(
			new NodeInt(new NodeInt(null,4, null),5, new NodeInt(new NodeInt(null,6, null),7, null)),
					8,new NodeInt(new NodeInt(null,10, null),12, new NodeInt(new NodeInt(null,13, null),14, null)));
	public static void main(String[] args) {
		//with O(1) space
		flattenTree(tree);
		while(tree != null) {
			System.out.print(tree.getData()+ " ");
			tree = tree.getRight();
		}
	}
	static NodeInt prev = null;
	//reverse preorder(right,left root) as we are using recursion as we need preorder traversal linkedlist(root left right)
	private static void flattenTree(NodeInt root) {
		if(root == null) return ;
		flattenTree(root.getRight());
		flattenTree(root.getLeft());
		root.setRight(prev);
		root.setLeft(null);
		prev = root; //imp
		//note the links will be formed while coming out of call stack
		}

}
