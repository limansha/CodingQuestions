package com.ds.binarysearchtrees;

import com.ds.binarytrees.pojo.NodeInt;

public class InsertElementIntoBST {
	static NodeInt tree = new NodeInt(
			new NodeInt(new NodeInt(null, 4, null), 5, new NodeInt(new NodeInt(null, 6, null), 7, null)), 8,
			new NodeInt(new NodeInt(null, 10, null), 12, new NodeInt(new NodeInt(null, 13, null), 14, null)));

	public static void main(String[] args) {
		int ele = 13;
		printTree(tree);
		System.out.println();
		insertToBST(tree, ele);
		printTree(tree);
	}

	private static void printTree(NodeInt root) {
		// inorder
		if (root == null)
			return;
		printTree(root.getLeft());
		System.out.print(root.getData() + " ");
		printTree(root.getRight());
	}

	private static void insertToBST(NodeInt root, int ele) {
		while (true) {
			if (ele > root.getData()) {
				if((root.getLeft()!= null && root.getLeft().getData() == ele) || (root.getRight()!= null && root.getRight().getData() == ele)) {
					System.out.println(ele +" already present");
					break;
				}
				if (root.getLeft() == null) {
					root.setLeft(new NodeInt(null, ele, null));
					break;
				} else if (root.getRight() == null) {
					root.setRight(new NodeInt(null, ele, null));
					break;
				}
				root = root.getRight();
			} else if (ele < root.getData()) {
				if((root.getLeft()!= null && root.getLeft().getData() == ele) || (root.getRight()!= null && root.getRight().getData() == ele)) {
					System.out.println(ele+ " already present");
					break;
				}
				if (root.getLeft() == null) {
					root.setLeft(new NodeInt(null, ele, null));
					break;
				} else if (root.getRight() == null) {
					root.setRight(new NodeInt(null, ele, null));
					break;
				}
				root = root.getLeft();
			}
			
		}
	}

}
