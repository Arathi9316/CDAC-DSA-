package queue;

import java.util.Scanner;

class Squeue{
	private int arr[];
	private int front,rear;
	public Squeue() {
		arr=new int[10];
		front=rear=-1;
	}
	public Squeue(int s) {
		arr=new int[s];
		front=rear=-1;
	}
	public boolean isFull() {
		if(rear==arr.length-1) {
			return true;
		}
		else return false;
	}
	public void enqueue(int d) {
		if(isFull()) {
			System.out.println("Overflow!!");
			return;
		}
		if(front==-1) front=0;
		rear=rear+1;
		arr[rear]=d;
		return;
	}
	public boolean isEmpty() {
		if((front==-1)||(front==rear+1)) {
			return true;
		}
		else return false;
	}
	
	public int dequeue() {
		int d=-999;
		if(!(isEmpty())) {
			d=arr[front];
			front=front+1;
			return d;
		}
		else return d;
	}
	public int peek() {
		int d=-999;
		if(!(isEmpty())) {
			d=arr[front];
			return d;
		}
		else return d;
	}
	public void show() {
		for(int i=front;i<=rear;i++) {
			System.out.print(arr[i]+" ");
		}
		System.out.println();
	}
}

public class SimpleQueuee {
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		Squeue q=new Squeue(5);
		int ch;
		do {
		System.out.println("=====Queue Operations=====");
		System.out.println("1.Enqueue\n2.Dequeue\n3.Peek\n4.Show\n5.Exit");
		System.out.println("Enter your choice ...");
		ch=sc.nextInt();
		switch(ch) {
		case 1:
			System.out.println("Enter element to insert: ");
			int n=sc.nextInt();
			q.enqueue(n);
			break;
		case 2:
			int a=q.dequeue();
			if(a!=-999)
			System.out.println(a);
			break;
			
		case 3:
			q.peek();
			break;
			
		case 4:
			q.show();
			break;
			
		case 5:
			System.out.println("Exiting....");
			break;
			
		default:
			System.out.println("Invalid choice..");
		}
		}while(ch!=5);
	}
}
