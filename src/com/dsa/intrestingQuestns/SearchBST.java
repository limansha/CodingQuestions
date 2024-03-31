package com.dsa.intrestingQuestns;

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;

class Node {
    int key;
    Node left;
    Node right;

    Node(int x) {
        this.key = x;
        left = null;
        right = null;
    }
}

public class SearchBST {

    static Node buildTree(String str) {

        if (str.length() == 0 || str.charAt(0) == 'N') {
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
        while (queue.size() > 0 && i < ip.length) {

            // Get and remove the front of the queue
            Node currNode = queue.peek();
            queue.remove();

            // Get the current node's value from the string
            String currVal = ip[i];

            // If the left child is not null
            if (!currVal.equals("N")) {

                // Create the left child for the current node
                currNode.left = new Node(Integer.parseInt(currVal));
                // Push it to the queue
                queue.add(currNode.left);
            }

            // For the right child
            i++;
            if (i >= ip.length) break;

            currVal = ip[i];

            // If the right child is not null
            if (!currVal.equals("N")) {

                // Create the right child for the current node
                currNode.right = new Node(Integer.parseInt(currVal));

                // Push it to the queue
                queue.add(currNode.right);
            }
            i++;
        }

        return root;
    }
    static int ans = 0;
    public static int findMaxForN(Node root, int n) {
        //can be solved using iterative approach
        int ans = Integer.MIN_VALUE;
        while(root != null){
            if(root.key  == n) return n;
            else if(root.key < n){
                ans = Math.max(ans,root.key);
                root = root.right;
            }
            else root = root.left;
        }
        return ans == Integer.MIN_VALUE ? -1 : ans;
       
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // int t = Integer.parseInt(br.readLine());
        int t = 1;
        while (t > 0) {
            // String s = br.readLine();
            // int N = Integer.parseInt(br.readLine());
            String s = "5 2 12 1 3 9 21 N N N N 19 25";
            Node root = buildTree(s);
           
            System.out.println(findMaxForN(root, 10));
            t--;
        }
    }
}


