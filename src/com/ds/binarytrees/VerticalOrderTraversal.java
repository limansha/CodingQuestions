package com.ds.binarytrees;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.TreeMap;
import java.util.stream.Collectors;

import com.ds.binarytrees.pojo.NodeInt;
class Pair{
	int data;
	int level;
	public Pair(int data, int level) {
		super();
		this.data = data;
		this.level = level;
	}
	@Override
	public String toString() {
		return "Pair [data=" + data + ", level=" + level + "]";
	}
	
}
class NodeWithXY{
	int data;
	int y;//level of the node from 0 to n direction bottom
	int x;  // root will be at 0 left will be from -1 to -n andright will be from 1 to n
	public NodeWithXY(int data, int x, int y) {
		super();
		this.data = data;
		this.x = x;
		this.y = y;
	}
	
	public int getData() {
		return data;
	}

	public int getY() {
		return y;
	}

	public int getX() {
		return x;
	}

	@Override
	public String toString() {
		return "NodeWithXY [data=" + data + ", y=" + y + ", x=" + x + "]";
	}
	
}
class SortX implements Comparator<NodeWithXY>{

	@Override
	public int compare(NodeWithXY o1, NodeWithXY o2) {
		
		return o1.getX() > o2.getX() ? 1 : (o1.getX() < o2.getX() ? -1 : 0);
	}
	
}
class SortY implements Comparator<NodeWithXY>{

	@Override
	public int compare(NodeWithXY o1, NodeWithXY o2) {
		
		return o1.getY() > o2.getY() ? 1 : (o1.getY() < o2.getY() ? -1 : 0);
	}
	
}
public class VerticalOrderTraversal {
	static ArrayList<NodeWithXY> nodes = new ArrayList<NodeWithXY>();
	static NodeInt tree = new NodeInt(
			new NodeInt(new NodeInt(null, 4, new NodeInt(null, 5, new NodeInt(null, 6, null))),2,new NodeInt(null, 10, null)),
			1, new NodeInt(new NodeInt(null, 9, null),3,new NodeInt(null, 10, null)));
	public static void main(String[] args) {
	
			// Ans
		/*
		 * 4
		 * 2 5
		 * 1 10 9 6
		 * 3
		 * 10
		 * */
		xIndex(tree,0);
		
		for(NodeWithXY n : nodes) {
			System.out.println(n.toString());
		}
		Map<Integer, List<NodeWithXY>> map =  nodes.stream()
							.collect(Collectors.groupingBy(NodeWithXY::getX));
		
		TreeMap<Integer, List<NodeWithXY>> m= map.entrySet().stream()
				.collect(Collectors.toMap(Map.Entry::getKey,Map.Entry::getValue,(oldValue,newValue)->newValue,TreeMap::new));
		System.out.println("************************");
		System.out.println(m);
	}

	static int getLevelUtil(NodeInt root,int data,int level) {
		if(root == null) return 0;
		if(root.getData() == data) return level;
		int downLevel =  getLevelUtil(root.getLeft(),data,level+1);
		if(downLevel != 0) {
			return downLevel;
		}
		downLevel = getLevelUtil(root.getRight(),data,level+1);
		return downLevel;
	}
	private static void xIndex(NodeInt root,int val) {
		//add idx to each node 
		if(root == null) return;
		int l = getLevelUtil(tree,root.getData(),0);
		nodes.add(new NodeWithXY(root.getData(),val,l));
		xIndex(root.getLeft(),val-1);
		xIndex(root.getRight(),val+1);
	}

}
