package binarytree;

class BST {
	private BtNode root;
	public BST() {
		root=null;
	}
	public void insertNonRec(int d) {
		BtNode new_node=new BtNode(d);
		if(root==null) {
			root=new_node;
			return;
		}
		BtNode itr=root;
		BtNode par =null;
		while(itr!=null) {
			par=itr;
			if(d<itr.getData())
				itr=itr.getLeft();
			else if(d>itr.getData())
				itr=itr.getRight();
			else {
				System.out.println("Duplicate..");
				return;
			}
		}	
		if(d<par.getData()) {
			par.setLeft(new_node);
		}
		else
			par.setRight(new_node);
	}
	private void preOrder(BtNode r) {
		if(r==null) {
//			System.out.print(" null ");
			return;
		}
		System.out.print(r.getData()+" ");
		preOrder(r.getLeft());
		preOrder(r.getRight());
		
	}
	public void display() {
		preOrder(root);
	}
	
	public void postOrder(BtNode r) {
		if(r==null)return;
//		System.out.println(r);
		postOrder(r.getLeft());
		postOrder(r.getRight());
		System.out.print(r.getData()+" ");
	}
	public void display1() {
		postOrder(root);
	}
	private void inOrder(BtNode r) {
		if(r==null)return;
		inOrder(r.getLeft());
		System.out.print(r.getData()+" ");
		inOrder(r.getRight());
	}
	public void display3() {
		inOrder(root);
	}
	public BtNode search(int key) {
		if(root==null) {
		System.out.println("Empty..");
		return null;
		}
		BtNode itr=root;
		while(itr!=null) {
			if(itr.getData()==key)return itr;
			
			if(key<itr.getData())
				itr=itr.getLeft();
			else 
				itr=itr.getRight();	
		}
//		System.out.println("not found");
		return null;
	
	}
	
	private int min(BtNode root) {
		int min=Integer.MAX_VALUE;
		BtNode itr=root;
		if(root==null)return -999;
		while(itr!=null) {
			if(itr.getData()<min) 
				min=itr.getData();
			
			itr=itr.getLeft();
		}
		return min;

	}
	public int minElement() {
		return min(root);
	}
	
	private int max(BtNode root) {
		int max=Integer.MIN_VALUE;
		BtNode itr=root;
		if(root==null)return -999;
		while(itr!=null) {
			if(itr.getData()>max) 
				max=itr.getData();
			
			itr=itr.getRight();
		}
		return max;

	}
	public int maxElement() {
		return max(root);
	}
	
	//insert using recursion
	private BtNode insert(BtNode ptr,int d) {
		if(ptr==null)return new BtNode(d);
		else if(d<ptr.getData()) {
			ptr.setLeft(insert(ptr.getLeft(),d));
		}
		else if(d>ptr.getData()) {
			ptr.setRight(insert(ptr.getRight(),d));	
		}
		else
			System.out.println("Dupliacte..");
	return ptr;
	}
	public void insert(int d) {
		root=insert(root,d);
	}
	
	//search by recursion
	private BtNode searchRec(BtNode ptr,int key) {
		if(ptr==null) {
			System.out.println("Not found");
			return null;
		}
		if(key>ptr.getData())
			ptr=searchRec(ptr.getRight(),key);
		else if(key<ptr.getData())
			ptr=searchRec(ptr.getLeft(),key);
		
		return ptr;
	}
	public void searchRec(int d) {
		System.out.println(searchRec(root,d));
	}
	
	private BtNode del_Rec(BtNode ptr,int d) {
		if(ptr==null) {		
			System.out.println("Not found");
			return null;
		}
		BtNode succ,deletable;
		if(d<ptr.getData()) {
			ptr.setLeft(del_Rec(ptr.getLeft(),d));
		}
		else if(d>ptr.getData()) {
			ptr.setRight(del_Rec(ptr.getRight(), d));
		}
		else {
			if(ptr.getLeft()!=null&&ptr.getRight()!=null) {
				succ=ptr.getRight();
				while(succ.getLeft()!=null) {
					succ=succ.getLeft();	
				}
				ptr.setData(succ.getData());
				ptr.setRight(del_Rec(ptr.getRight(),succ.getData()));
			}
			else {
				deletable =ptr;
				if(ptr.getLeft()!=null)
					ptr=ptr.getLeft();
				if(ptr.getRight()!=null)
					ptr=ptr.getRight();
				else 
					ptr=null;
				System.out.println(deletable.getData());
				deletable=null;
			}
		}
		return ptr;
			
		
	}
	public void deleteRec(int d) {
		del_Rec(root,d);
	}
	
	//HEIGHT
	private int find_ht(BtNode ptr) {
		int left=0,right=0;
		if(ptr==null)
			return 0;
		if(ptr.getLeft()!=null) 
			left=find_ht(ptr.getLeft());
		if(ptr.getRight()!=null)
			right=find_ht(ptr.getRight());
		if(left>right)
				return left+1;
		else 
				return right+1;
		
		
	}
	public void findHeight() {
		System.out.println(find_ht(root));
	}
	
}
public class BSTMain{
	public static void main(String[] args) {
		BST tree=new BST();
		tree.insertNonRec(45);
		tree.insertNonRec(23);
		tree.insertNonRec(78);
		tree.insertNonRec(77);
		tree.insertNonRec(65);
		tree.insertNonRec(42);
		tree.insertNonRec(12);
		tree.insertNonRec(10);
		tree.insertNonRec(11);
		tree.insertNonRec(69);
		System.out.println("===PreOrder===");
		tree.display();
		System.out.println("\n===PostOrder===");
		tree.display1();
		System.out.println("\n===InOrder===");
		tree.display3();
		
//		System.out.println("\n"+tree.search(23));
//		if(!(tree.search(22)==null)) {
//			System.out.println("\n"+tree.search(23).getData());
//		}
//		else {
//			System.out.println("\nNot found");
//		}
		System.out.println("\nMinValue = "+tree.minElement());
		System.out.println("\nMaxValue = "+tree.maxElement());
		
		tree.insert(100);
		System.out.println("\n===InOrder===");
		tree.display3();
		System.out.println("\nSearch using recursion.");
		tree.searchRec(110);
		System.out.println("===Delete===");
		tree.deleteRec(78);
		System.out.println("\n===InOrder===");
		tree.display3();
		
		System.out.println("\n");
		tree.findHeight();
	}
}
