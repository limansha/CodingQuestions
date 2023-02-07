package com.ds.binarysearchtrees;

//https://practice.geeksforgeeks.org/problems/c85e3a573a7de6dfd18398def16d05387852b319/1
//{ Driver Code Starts
//Initial Template for Java
import java.util.LinkedList; 
import java.util.Queue; 
import java.io.*;
import java.util.*;

class Node{
  int data;
  Node left;
  Node right;
  Node(int data){
      this.data = data;
      left=null;
      right=null;
  }
}

class VerticalBSTDownwardTraversal {
  
  static Node buildTree(String str){
      
      if(str.length()==0 || str.charAt(0)=='N'){
          return null;
      }
      
      String ip[] = str.split(" ");
      // Create the root of the tree
      Node root = new Node(Integer.parseInt(ip[0]));
      // Push the root to the queue
      
      Queue<Node> queue = new LinkedList<>(); 
      
      queue.add(root);
      // Starting from the second element
      
      int i = 1;
      while(queue.size()>0 && i < ip.length) {
          
          // Get and remove the front of the queue
          Node currNode = queue.peek();
          queue.remove();
              
          // Get the current node's value from the string
          String currVal = ip[i];
              
          // If the left child is not null
          if(!currVal.equals("N")) {
                  
              // Create the left child for the current node
              currNode.left = new Node(Integer.parseInt(currVal));
              // Push it to the queue
              queue.add(currNode.left);
          }
              
          // For the right child
          i++;
          if(i >= ip.length)
              break;
              
          currVal = ip[i];
              
          // If the right child is not null
          if(!currVal.equals("N")) {
                  
              // Create the right child for the current node
              currNode.right = new Node(Integer.parseInt(currVal));
                  
              // Push it to the queue
              queue.add(currNode.right);
          }
          i++;
      }
      
      return root;
  }
  static void printInorder(Node root)
  {
      if(root == null)
          return;
          
      printInorder(root.left);
      System.out.print(root.data+" ");
      
      printInorder(root.right);
  }
  
	public static void main (String[] args) throws IOException{
	        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	        PrintWriter out=new PrintWriter(System.out);
	        
	        int t=Integer.parseInt(br.readLine());
  
	        while(t > 0){
  	    	int target=Integer.parseInt(br.readLine());
	            String s = br.readLine();
  	    	Node root = buildTree(s);
      	    Solution g = new Solution();
      	    long ans=g.verticallyDownBST(root,target);
      	    out.println(ans);
              t--;
          
      }
      out.close();
  }

}




//} Driver Code Ends


//User function Template for Java
class Tuple{
  Node node;
  int vertical;
  int level;
  public Tuple(Node node,int vertical, int level){
      this.node = node;
      this.vertical = vertical;
      this.level = level;
  }
@Override
public String toString() {
	return "Tuple [node=" + node + ", vertical=" + vertical + ", level=" + level + "]";
}
  
}

class Solution
{
  long verticallyDownBST(Node root,int target)
  {
      //find the target node if not present return -1
      //perform vertical traversal assuming terget as root
      //vertical traversal
      //take a Level order traversal and update a DS TreeMap<Vertical,TreeMap<Level,Priority Queue(for overlapping nodes as its a BST)>
      Node targetNode = isTargetFound(root,target);
      long ans = -1;
      if(targetNode != null){
         // System.out.println(targetNode.data);
          ans = verticalTraversal(targetNode) - targetNode.data;
      }
      return ans;
  }
  long verticalTraversal(Node targetNode){
      int vertical = 0;
      int level = 0;
      TreeMap<Integer,TreeMap<Integer,PriorityQueue<Integer>>> map = new TreeMap<>();
      Queue<Tuple> pq = new LinkedList<Tuple>();
      pq.offer(new Tuple(targetNode,vertical,level));
      while(!pq.isEmpty() && pq != null){
          //System.out.println(pq.toString());
    	  Tuple t = pq.poll();
         // System.out.println(t.toString());
          Node node = t.node;
         // System.out.println(node.data);
          vertical = t.vertical;
          level = t.level;
          if(!map.containsKey(vertical)){
              map.put(vertical,new TreeMap<>());
          }
          if(!map.get(vertical).containsKey(level)){
              map.get(vertical).put(level,new PriorityQueue<Integer>());
          }
          map.get(vertical).get(level).offer(node.data);
          if(node.left != null) pq.offer(new Tuple(node.left,vertical-1,level+1));
          if(node.right != null) pq.offer(new Tuple(node.right,vertical+1,level+1));
      }
      long ans = 0;
      ArrayList<Integer> a = new ArrayList<Integer>();
      for(PriorityQueue<Integer> tmp: map.get(0).values()){
          a.addAll(tmp);
      }
      for(int i: a){
          ans+=i;
      }
      return ans;
  }
  Node isTargetFound(Node root,int target){
      if(root != null){
          if(root.data == target){
              return root;
          }
          if(root.data > target){
              return isTargetFound(root.left,target);
          }
          else if(root.data < target){
              return isTargetFound(root.right,target);
          }
      }
      return null;
  }
}