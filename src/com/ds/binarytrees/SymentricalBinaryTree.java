package com.ds.binarytrees;

import java.util.ArrayList;

import com.ds.binarytrees.pojo.NodeInt;

public class SymentricalBinaryTree {
	static NodeInt tree = new NodeInt(
			new NodeInt(new NodeInt(null,3, null),2,new NodeInt(null,4, null)),
					1, new NodeInt(new NodeInt(null, 4, null),2,new NodeInt(null, 3, null)));
	public static void main(String[] args) {
		if(isSymentric(tree)) System.out.println("symmentric");
		else System.out.println("non symmentric");
	}
	static boolean isSymentric(NodeInt tree) {
		ArrayList<Integer> left = traversalLR(tree.getLeft(),new ArrayList());
		ArrayList<Integer> right = traversalRL(tree.getRight(),new ArrayList<Integer>());
		System.out.println(left.toString());
		System.out.println(right.toString());
		if(left.equals(right)) return true;
		return false;
	}
	private static ArrayList<Integer> traversalRL(NodeInt root, ArrayList arr) {
		if(root == null) {
			return arr;
		}
		arr.add(root.getData());
		traversalRL(root.getRight(),arr);
		traversalRL(root.getLeft(),arr);
		return arr;
		
	}
	private static ArrayList<Integer> traversalLR(NodeInt root, ArrayList<Integer> arr) {
		if(root == null) {
			return arr;
		}
		arr.add(root.getData());
		traversalLR(root.getLeft(),arr);
		traversalLR(root.getRight(),arr);
		return arr;
	}
}
