package com.ds.binarytrees;

import com.ds.binarytrees.pojo.TreeNode;

public class checkTwoTreesIdentical {

	public static void main(String[] args) {
		// case1
		TreeNode rootc11 = new TreeNode(
				new TreeNode(new TreeNode(new TreeNode(null, "D", null), "C", null), "B",
						new TreeNode(null, "F", null)),
				"A", new TreeNode(new TreeNode(new TreeNode(null, "H", null), "G", new TreeNode(null, "I", null)), "E",
						new TreeNode(null, "J", null)));

		TreeNode rootc12 = new TreeNode(new TreeNode(new TreeNode(new TreeNode(null, "D", null), "C", null), "B",
				new TreeNode(null, "F", null)), "A", new TreeNode(null, "E", null));

		// case2
		TreeNode rootc21 = new TreeNode(
				new TreeNode(new TreeNode(new TreeNode(null, "D", null), "C", null), "B",
						new TreeNode(null, "F", null)),
				"A", new TreeNode(new TreeNode(new TreeNode(null, "H", null), "G", new TreeNode(null, "I", null)), "E",
						new TreeNode(null, "J", null)));

		TreeNode rootc22 = new TreeNode(
				new TreeNode(new TreeNode(new TreeNode(null, "D", null), "C", null), "B",
						new TreeNode(null, "F", null)),
				"A", new TreeNode(new TreeNode(new TreeNode(null, "H", null), "G", new TreeNode(null, "I", null)), "E",
						new TreeNode(null, "J", null)));

		if (isIdentical(rootc21, rootc22)) {
			System.out.println("Identical");
		} else {
			System.out.println("not identical");
		}
	}

	private static boolean isIdentical(TreeNode root1, TreeNode root2) {
		if (root1 == null || root2 == null) {
			return root1 == root2 ? true : false;
		}

		return (root1.getData() == root2.getData() && isIdentical(root1.getLeft(), root2.getLeft())
				&& isIdentical(root1.getRight(), root2.getRight())) ? true : false;
	}

}
