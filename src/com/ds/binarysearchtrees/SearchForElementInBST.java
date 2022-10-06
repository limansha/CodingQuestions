package com.ds.binarysearchtrees;

import com.ds.binarytrees.pojo.NodeInt;

public class SearchForElementInBST {
	static NodeInt tree = new NodeInt(
			new NodeInt(new NodeInt(null, 4, null), 5, new NodeInt(new NodeInt(null, 6, null), 7, null)), 8,
			new NodeInt(new NodeInt(null, 10, null), 12, new NodeInt(new NodeInt(null, 13, null), 14, null)));

	public static void main(String[] args) {
		int ele = 13;
		if (ispresentInBST(tree, ele))
			System.out.println("present");
		else
			System.out.println("not present");
	}

	private static boolean ispresentInBST(NodeInt root, int ele) {
		if(root == null) return false;
		if(root.getData() == ele) return true;
		else if(root.getData() > ele) {
			return ispresentInBST(root.getLeft(),ele);
		}
		else if(root.getData() < ele) {
			return ispresentInBST(root.getRight(), ele);
		}
		return false;
	}
}	
