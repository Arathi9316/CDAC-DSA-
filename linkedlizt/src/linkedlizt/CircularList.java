package linkedlizt;

import java.util.Scanner;

class circularLinked{
	private intNode last;
	public circularLinked() {
		last=null;
	}
	
	public void insertFirst(int d) {
		intNode new_node=new intNode(d);
		if(last==null) {
			last=new_node;
			last.setNext(last);
			return;
		}
		new_node.setNext(last.getNext());
		last.setNext(new_node);
		return;
		
	}
	public void insertLast(int d) {
		intNode new_node=new intNode(d);
		if(last==null) {
			last=new_node;
			last.setNext(last);
			return;
		}
		new_node.setNext(last.getNext());
		last.setNext(new_node);
		last=new_node;
		return;
	}
	
	public void insertByPos(int d,int p) {
		intNode new_node=new intNode(d);
			if(last==null) {
				last=new_node;
				last.setNext(last);
				return;
			}
			if(p==1) {
				insertFirst(d);
				return;
			}
			intNode itr=last.getNext();
			int i=1;
			do {
				if(i==p-1) {
					new_node.setNext(itr.getNext());
					itr.setNext(new_node);
					if(itr==last)last=new_node;
					return;
				
					
				}
				itr=itr.getNext();
				i++;
			}while(itr!=last.getNext());
			
		
	}
	public int deleteFirst() {
		int d=-999;
		if(last==null) {
			System.out.println("List is empty.");
			return d;
		}
		intNode deletable=last.getNext();
		d=deletable.getData();
		 if (last == deletable) {
		        last = null;
		    } else {
		        last.setNext(deletable.getNext());
		    }
		deletable.setNext(null);
		
		return d;
	}
	
	public int deleteLast() {
		int d=-999;
		if(last==null) {
			System.out.println("List is empty.");
			return d;
		}
		intNode deletable=last,itr;
		d=last.getData();
		 if (last.getNext() == last) {
		        last = null;
		        return d;
		    }
		itr=last.getNext();
		while(itr.getNext()!=last) {
			itr=itr.getNext();
		}
		
		itr.setNext(deletable.getNext());
		last=itr;
		deletable.setNext(null);

		
		return d;
		
		
		
	}
	
	public void display() {
		if(last==null) {
			System.out.println("List is empty!!");
			return;
		}
		intNode itr=last.getNext();
		do {
			System.out.print(itr.getData()+"->");
			itr=itr.getNext();
		}while(itr!=last.getNext());
		System.out.println();
	}
}

public class CircularList {
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		circularLinked circular=new circularLinked();
		int ch,n,p,del;
		intNode d;
		do {
		System.out.println("=====Queue Operations=====");
		System.out.println("1.InsertFirst\n2.InsertLast\n3.Display\n4.InsertByPos\n5.DeleteFirst\n6.DeleteLast\n7.Exit");
		System.out.println("Enter your choice ...");
		ch=sc.nextInt();
		switch(ch) {
		case 1:
			System.out.println("Enter element to insert: ");
			n=sc.nextInt();
			circular.insertFirst(n);
			break;
		case 2:
			System.out.println("Enter element to insert: ");
			n=sc.nextInt();
			circular.insertLast	(n);
			break;
		case 3:
			circular.display();
			break;
		case 4:
			System.out.println("Enter element and position : ");
			n=sc.nextInt();
			p=sc.nextInt();
			circular.insertByPos(n, p);
			break;
		case 5:
			 del=circular.deleteFirst();
			System.out.println(del+" deleted");
			break;
		case 6:
			 del=circular.deleteLast();
			System.out.println(del+" deleted");
			break;
		case 7:
			System.out.println("Exiting..");
			break;
		default:
			System.out.println("Invalid choice.");
			
		}
		}while(ch!=7);
	}
}
