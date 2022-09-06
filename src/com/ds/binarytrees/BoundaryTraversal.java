package com.ds.binarytrees;

import java.util.ArrayList;
import java.util.Collections;

import com.ds.binarytrees.pojo.NodeInt;

public class BoundaryTraversal {

	public static void main(String[] args) {

		NodeInt root = new NodeInt(new NodeInt(
				new NodeInt(null, 3, new NodeInt(new NodeInt(null, 5, null), 4, new NodeInt(null, 6, null))), 2, null),
				1, new NodeInt(null, 7, new NodeInt(
						new NodeInt(new NodeInt(null, 10, null), 9, new NodeInt(null, 11, null)), 8, null)));
			printLeftTraversal(root);
			printLeafs(root);
			printReverseRightTraversal(root.getRight());
			
	}

	private static void printReverseRightTraversal(NodeInt root) {
		ArrayList<Integer> arr = new ArrayList<Integer>();
		while(root.getLeft() != null || root.getRight() != null) {
			arr.add(root.getData());
			if(root.getRight() != null) {
				root = root.getRight();
				continue;
			}
			if(root.getLeft() != null) {
				root = root.getLeft();
				continue;
			}
		}
		Collections.reverse(arr);
		for(int i:arr) {
			System.out.print(" "+ i +" ");
		}
	}

	private static void printLeafs(NodeInt root) {
		//preorder traversal
		if(root == null) {
			return;
		}
		if(root.getLeft() == null && root.getRight() == null) System.out.print(" "+ root.getData()+" ");
		printLeafs(root.getLeft());
		printLeafs(root.getRight());
	}

	private static void printLeftTraversal(NodeInt root) {
		//ArrayList<Integer> arr = new ArrayList<Integer>();
		while(root.getLeft() != null || root.getRight() != null) {
			//arr.add(root.getData());
			System.out.print(" "+ root.getData()+" ");
			if(root.getLeft() != null) {
				root = root.getLeft();
				continue;
			}
			if(root.getRight() != null) {
				root = root.getRight();
				continue;
			}
		}
		//System.out.println(arr.toString());
	}

}
