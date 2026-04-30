package stack;

import java.util.Scanner;

class intNode{
	private int data;
	private intNode next;
	public intNode() {
		data=0;
		next=null;
	}
	public intNode(int d) {
		this.data=d;
		this.next=null;
	}
	public void setData(int d) {
		this.data=d;
	}
	public void setNext(intNode n) {
		this.next=n;
	}
	public int getData() {
		return data;
	}
	public intNode getNext() {
		return next; 
	}
	public String toString() {
		return "["+data+"]->";
	}
	
}

class StackLL{
	private intNode top;
	public StackLL() {
		top=null;
	}
	public void push(int d) {
		intNode new_node=new intNode(d);
		if(top==null) {
			top=new_node;
			return;
		}
		new_node.setNext(top);
		top=new_node;
		return;
	}
	public int pop() {	
		int d=-999;
		if(top==null) {
			return d;
		}
		intNode deletable=top;
		d=deletable.getData();
		top=deletable.getNext();
		deletable.setNext(null);
		deletable=null;
		return d;
		
		
	}
	public int peek() {
		if(top==null) return -999;
		return top.getData();
	}
	public void display() {
		if(top==null) {
			System.out.println("Stack is empty!");
			return;
		}
		intNode itr=top;
		while(itr!=null) {
			System.out.print(itr.getData()+"->");
			itr=itr.getNext();
		}
		System.out.println();
		
	}
}

public class StackUsingLinked {
	public static void main(String[]args) {
	StackLL stack=new StackLL();
	Scanner sc=new Scanner(System.in);
	int ch,n;
	do {
	System.out.println("1.Push\n2.Pop\n3.Peek\n4.Display\n5.Exit");
	System.out.println("Enter your choice...");
	ch=sc.nextInt();
	switch(ch) {
	case 1:
		System.out.println("Enter element to insert: ");
		n=sc.nextInt();
		stack.push(n);
		break;
	case 2:
		int p=stack.pop();
		System.out.println(p+" popped");
		break;
	case 3:
		int p1=stack.peek();
		System.out.println(p1+" is peeked node.");
		break;
	case 4:
		stack.display();
		break;
	case 5:
		System.out.println("Services stopped!");
	break;
	default: System.out.println("Invalid choicee.");
	}
	}while(ch!=5);
	
}}
