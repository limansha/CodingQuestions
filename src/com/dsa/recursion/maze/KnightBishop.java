package com.dsa.recursion.maze;
//
//import java.util.Comparator;
//import java.util.LinkedList;
//import java.util.PriorityQueue;
//import java.util.Queue;
//class Cell{
//    int x;
//    int y;
//    int step;
//    public Cell(int x ,int y,int step){
//        this.x = x;
//        this.y = y;
//        this.step = step;
//    }
//}
//class CellComparator implements Comparator<Cell>{
//
//	@Override
//	public int compare(Cell o1, Cell o2) {
//		
//		if(o1.step > o2.step) return -1;
//		else if(o1.step < o2.step) return 1;
//		return 0;
//	}
//	
//}
//public class KnightBishop {
//	
//    //Function to find out minimum steps Knight needs to reach target position.
//    public static int minStepToReachTarget(int KnightPos[], int TargetPos[], int N)
//    {
//        int[] dx = new int[]{2,2,-2,-2,1,-1,1,-1};
//        int[] dy = new int[]{1,-1,1,-1,2,2,-2,-2};
//        //Queue<Cell> p = new LinkedList<Cell>();
//        PriorityQueue<Cell> p = new PriorityQueue<Cell>(new CellComparator());
//        int kx = KnightPos[0];
//        int ky = KnightPos[1];
//        p.add(new Cell(kx,ky,0));
//        int c =-1;
//        while(!p.isEmpty()){
//            Cell curr = p.poll();
//            
//            for(int i=0;i<8;i++){
//                int nx = curr.x - dx[i];
//                int ny = curr.y - dy[i];
//                int step = curr.step;
//                if(nx >= 1 && nx <= N && ny >= 1 && ny <= N){
//                    p.add(new Cell(nx,ny,step+1));
//                }
//            }
//            System.out.println(curr.x +"   "+ curr.y+" "+ " steps "+ curr.step);
//            if(curr.x == TargetPos[0] && curr.y== TargetPos[1]) {
//            	c = curr.step;
//            	break;
//            } 
//        }
//           return c;
//	    }
//    public static void main(String[] args) {
//    	int []k = new int[]{4,5};
//    	int []t = new int[]{1,1};
//    	System.out.println(minStepToReachTarget(k,t,6));
//	}
//}

class Stack{
int n;
int []stack;
int top;
public Stack(int size){
n = size;
stack = new int[n];
top =-1;
}
void push(int v){
if(top >= n) System.out.println("stack is full");
top = top+1;
stack[top] = v; 
}
int pop(){
if(top == -1){
return -1;
}
return stack[top--];
}
int peek(){
if(top == -1) return -1;
return stack[top];
}
void inc(int p,int v){
 for(int i =0;i<p;i++){
	stack[i] += v; 
}
}
void display(){
 for(int i =0;i<top;i++){
	 System.out.print(stack[i]+"  ");	
}
 System.out.println("top " +top);
}
}
public class KnightBishop {
public static void main(String[] args) {
	Stack s = new Stack(5);
	s.push(4);
	s.push(3);
	s.push(2);
	System.out.println(s.pop());
	System.out.println(s.pop());
	System.out.println(s.pop());
	System.out.println(s.peek());
	s.display();
 }
}	
