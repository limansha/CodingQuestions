package com.ds.binarytrees;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;

import com.ds.binarytrees.pojo.TreeNode;

public class PrintZigZagInTree {

	public static void main(String[] args) {
		TreeNode root = new TreeNode(
				new TreeNode(new TreeNode(new TreeNode(null, "D", null), "C", null), "B",
						new TreeNode(null, "F", null)),
				"A", new TreeNode(new TreeNode(new TreeNode(null, "H", null), "G", new TreeNode(null, "I", null)), "E",
						new TreeNode(null, "J", null)));
		ArrayList<ArrayList<String>> res  =printZigZag(root);
		for(ArrayList<String> s : res) {
			System.out.println(s.toString());
		}
	}

	private static ArrayList<ArrayList<String>> printZigZag(TreeNode root) {
		boolean LeftToRight = true;
		//perform Level order Traversal Using Queue //only printing differs based on LeftToRight value
		Queue<TreeNode> q = new LinkedList<TreeNode>();
		ArrayList<ArrayList<String>> res = new ArrayList<ArrayList<String>>();
		q.offer(root);
		while(!q.isEmpty()) {
			int size = q.size();
			ArrayList<String> tem = new ArrayList<String>();
			for(int i = 0;i<size;i++) {
				TreeNode n = q.poll();
				tem.add(n.getData());
				if(n.getLeft() != null) q.offer(n.getLeft());
				if(n.getRight() != null) q.offer(n.getRight());
			}
//			if(!LeftToRight) {
//				ArrayList<String> tem1 = new ArrayList<String>(); //extra space
//					 
//				for(int i = tem.size()-1;i >= 0; i--) {
//					tem1.add(tem.get(i)); //reverse elements
//				}
//				res.add(tem1);
//			}
//			else {
//				res.add(tem);
//			}
			if(!LeftToRight) {
					Collections.reverse(tem);
				}
				res.add(tem);
			
			LeftToRight = !LeftToRight;
		}
		return res;
	}
	
}
	