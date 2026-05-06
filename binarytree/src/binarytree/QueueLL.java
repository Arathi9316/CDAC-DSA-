package binarytree;


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
}

public class QueueLL {
	
	private intNode rear,front;
	public QueueLL() {
		rear=front=null;
	}
	public QueueLL(int s) {
		rear=front=null;
	}
	public boolean isEmpty() {
		if(front==null)
			return true;
		else return false;
	}
	
	public void add(int d) {
		intNode new_node=new intNode(d);
		if(isEmpty()) {
		front=rear=new_node;
		}
		rear.setNext(new_node);
		rear=new_node;
	}
	public int remove() {
		int d=-999;
		if(!(isEmpty())) {
			intNode del;
			d=front.getData();
			del=front;
			front=front.getNext();
			del.setNext(null);
			if(front==null) rear=null;
			return d;	
		}
		else {
			System.out.println("Empty!!");
			return d;
		}
	}
	
	public void display() {
		intNode i=front;
		while(i!=null) {
			System.out.println(i.getData()+" ");
			i=i.getNext();
		}
		System.out.println();
	}
	public static void main(String[] args) {
		
		QueueLL q=new QueueLL();
		q.add(45);
		q.add(32);
		q.add(23);
		q.add(50);
		q.display();
		q.remove();
		q.display();
		
	}
	
}
