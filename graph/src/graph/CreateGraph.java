package graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;

class MyGraph{
	private int adj[][];
	private int n;
	public MyGraph(int i) {
		n=i;
		adj=new int[n][n];
	}
	public void createGraph() {
		int i,max_edges,dest,origin;
		Scanner sc=new Scanner(System.in);
		max_edges=n*(n-1);
		
		for(i=0;i<max_edges;i++) {
			System.out.println("Enter edge (-1 -1) to quit: ");
			origin=sc.nextInt();
			dest=sc.nextInt();
			if(origin==-1&&dest==-1) {
				break;
			}
			if(origin>=n||dest>=n||origin<0||dest<0) {
				System.out.println("Invalid edge!\n");
				i--;
			}
			else {
				adj[origin][dest]=1;
			}
		}
		sc.close();
	}
	public void insertEdge(int origin,int dest) {
		if(origin<0||origin>=n) {
			System.out.println("Origin vertex does not exists.");
			return;
		}
		if(dest<0||dest>=n) {
			System.out.println("Destination vertes does not exists.");
			return;
		}
		adj[origin][dest]=1;
	}
	public void delEdge(int origin,int dest) {
		if(origin<0||origin>=n||dest<0||dest>=n) {
			System.out.println("This edge does not exists.");
			return;
		}
		adj[origin][dest]=0;
	}
	public void display() {
		
		for(int i=0;i<n;i++) {
			System.out.print("["+i+"]    " );
			for(int j=0;j<n;j++) {
				
				System.out.print(adj[i][j]+" ");
			}
			System.out.println();
		}
	}
	
	//DFS traversal
	public void DFS_Traversal(int v) {
		int i;
		int state[] = new int[n];;
		for(i=0;i<n;i++) {
			state[i]=0;
		}
		Stack<Integer> s=new Stack<>();
		s.push(v);
		while(!s.isEmpty()) {
			v=s.pop();
			if(state[v]==0) {
				System.out.print(v + " ");
				state[v]=1;
			}
			for(i=0;i<n;i++) {
				if(adj[v][i]==1&&state[i]==0)
					s.push(i);
			}
		}
	}
	
	//BFS Traversal
	public void BFS_Traversal(int v) {
		int i;
		int state[] = new int[n];;
		for(i=0;i<n;i++) {
			state[i]=1;
		}
		Queue<Integer> q=new LinkedList<>();
		q.offer(v);
		state[v]=2;
		while(!q.isEmpty()) {
			v=q.poll();
			System.out.print(v+ " ");
			state[v]=3;
			for(i=0;i<n;i++) {
				//Check for adjacent unvisited vertices
				if(adj[v][i]==1&&state[i]==1) {
					q.offer(i);
					state[i]=2;
				}
			}
		}
		System.out.println();
		
		
	}
}
public class CreateGraph {
		public static void main(String[] args) {
			MyGraph graph=new MyGraph(10);
			graph.insertEdge(0, 1);
			graph.insertEdge(0, 3);
			graph.insertEdge(1, 2);
			graph.insertEdge(1, 4);
			graph.insertEdge(1, 5);
			graph.insertEdge(2, 3);
			graph.insertEdge(2, 5);
			graph.insertEdge(3, 6);
			graph.insertEdge(4, 7);
			graph.insertEdge(5, 6);
			graph.insertEdge(5, 7);
			graph.insertEdge(5, 8);
			graph.insertEdge(6, 9);
			graph.insertEdge(7, 8);
			graph.insertEdge(8, 9);
			
			graph.display();
			
			graph.DFS_Traversal(0);
			System.out.println();
			graph.BFS_Traversal(0);
			
			
		}		
}
