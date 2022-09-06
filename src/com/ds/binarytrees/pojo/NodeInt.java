package com.ds.binarytrees.pojo;

public class NodeInt {

	NodeInt left;
	int data;
	NodeInt right;
	
	public NodeInt(NodeInt left, int data, NodeInt right) {
		super();
		this.left = left;
		this.data = data;
		this.right = right;
	}

	public NodeInt() {
		// TODO Auto-generated constructor stub
	}

	public NodeInt getRight() {
		return right;
	}

	public int getData() {
		return data;
	}

	public NodeInt getLeft() {
		return left;
	}

	public void setLeft(NodeInt left) {
		this.left = left;
	}

	public void setData(int data) {
		this.data = data;
	}

	public void setRight(NodeInt right) {
		this.right = right;
	}
}
