package recursion;

import java.util.*;


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
class LinkedList{
	private intNode head;
	public LinkedList() {
		head=null;
	}
	public void setHead(intNode h) {
		this.head=h;
	}
	public intNode getHead() {
		return head;
	}
	public void insertFirst(int d) {
		intNode new_node=new intNode(d);
		if(head==null) {
			head=new_node;
			return;
		}
		
		new_node.setNext(head);
		
		head=new_node;
	}
	public void insertLast(int d) {
		intNode new_node=new intNode(d);
		if(head==null) {
		head=new_node;
		return;
		}
		intNode itr=head;
		while(itr.getNext()!=null) {
			itr=itr.getNext();
			}
			itr.setNext(new_node);
			return;
	}
	public void display() {
		intNode itr=head;
		while(itr!=null) {
			System.out.print(itr);
			itr=itr.getNext();
			
		}
		System.out.println();
	
	}
	public intNode deleteFirst() {
		intNode d;
		if(head==null) {
			return null;
		}
		 d=head;
		 head=d.getNext();
		 return d;
		
	}
	public intNode deleteLast() {
		if(head==null)return null;
		if(head.getNext()==null) {
		intNode temp=head;
		head=null;
		return temp;
		}
		intNode itr=head;
		while(itr.getNext().getNext()!=null) {
			itr=itr.getNext();
		}
		intNode del=itr.getNext();
		itr.setNext(null);
		return del;
		
	}
	public static intNode reverse(intNode head) {
		intNode temp;
		if(head.getNext()==null) return head;
		temp=reverse(head.getNext()); 
		head.getNext().setNext(head);
		head.setNext(null);
		return temp;
	}
	public static void displayRev(intNode head) {
		if(head==null) return;
		displayRev(head.getNext());
		System.out.print(head.getData()+"->");
	}
}

public class LinkedListUsingRecursion {
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		LinkedList list=new LinkedList();
		int ch,n;
		intNode d;
		do {
		System.out.println("=====Queue Operations=====");
		System.out.println("1.InsertFirst\n2.InsertLast\n3.Display\n4.DeleteFirst\n5.DeleteLast\n6.Reverse list\n7.Display in reverse order\n8.Exit");
		System.out.println("Enter your choice ...");
		ch=sc.nextInt();
		switch(ch) {
		case 1:
			System.out.println("Enter element to insert: ");
			n=sc.nextInt();
			list.insertFirst(n);
			break;
		case 2:
			System.out.println("Enter element to insert: ");
			n=sc.nextInt();
			list.insertLast(n);
			break;
			
		case 3:
			System.out.println("===All elements===");
			list.display();
			break;
			
		case 4:
			 d=list.deleteFirst();
			if(d!=null) {
			System.out.println(d);
			}
			else 
			System.out.println("List is already empty!!");
			break;
			
		case 5:
			 d=list.deleteLast();
			if(d!=null) {
			System.out.println(d);
			}
			else 
			System.out.println("List is already empty!!");
			break;
			
		case 6:
			list.setHead(LinkedList.reverse(list.getHead()));
			break;
		case 7:
			LinkedList.displayRev(list.getHead());
			System.out.println() ; 

			break;
		case 8:
			System.out.println("Exiting....");
			break;
			
		default:
			System.out.println("Invalid choice..");
		}
		}while(ch!=8);
		
		sc.close();
	}
}
