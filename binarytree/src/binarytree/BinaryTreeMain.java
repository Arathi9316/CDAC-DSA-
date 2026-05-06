package binarytree;

import java.util.LinkedList;
import java.util.Queue;

class BtNode{
	private int data;
	private BtNode left,right;
	public BtNode() {
		data=0;
		left=right=null;
	}
	public BtNode(int d) {
		data=d;
		left=right=null;
	}
	public void setData(int d) {
		this.data=d;
	}
	public void setLeft(BtNode l) {
		this.left=l;
	}
	public void setRight(BtNode r) {
		this.right=r;
	}
	public int getData() {
		return data;
	}
	public BtNode getLeft() {
		return left;
	}
	public BtNode getRight() {
		return right;
	}
	
}
class BinaryTree{
	private BtNode root;
	public BinaryTree() {
		root=null;
	}
	public void setRoot(BtNode r) {
		root=r;
	}
	public BtNode getRoot() {
		return root;
	}
	
	public BtNode createRoot(int d) {
		BtNode new_node=new BtNode(d);
		return new_node;
				
	}
	public void visitPreOrder(BtNode r) {
		if(r==null) return;
		System.out.print(r.getData()+" ");
		visitPreOrder(r.getLeft());
		visitPreOrder(r.getRight());
	}
	
	public void preOrder() {
		visitPreOrder(root);
	}
	public void displayLevelWise() {
		BtNode itr;
		if(root==null) {
			System.out.println("Empty");
			return;
		}
		Queue<BtNode> q=new LinkedList<BtNode>();
		q.add(root);
		while(!q.isEmpty()) {
			itr=q.remove();
			System.out.print(itr.getData()+" ");
			if(itr.getLeft()!=null)
				q.add(itr.getLeft());
			if(itr.getRight()!=null)
				q.add(itr.getRight());
		}
		
	}
	
	public void displayLeaf() {
		if(root==null) {
			System.out.println("Empty..");
			return;
		}
		Queue<BtNode> q=new LinkedList<BtNode>();
		q.add(root);
		BtNode itr;
		while(!q.isEmpty()) {
			itr=q.remove();
			if(itr.getLeft()==null && itr.getRight()==null)
			{
				System.out.print(itr.getData()+" ");
			}
			if(itr.getLeft()!=null)
				q.add(itr.getLeft());
			if(itr.getRight()!=null)
				q.add(itr.getRight());
		}
		
	}
	public void nonLeafNode() {
		BtNode itr;
		if(root==null) {
			System.out.println("Empty");
			return;
		}
		
		Queue<BtNode> q1=new LinkedList<BtNode>();
		q1.add(root);

		while(!q1.isEmpty()) {
			itr=q1.remove();
			if(itr.getLeft()!=null||itr.getRight()!=null) {
				System.out.print(itr.getData()+" ");
			}
			if(itr.getLeft()!=null)
				q1.add(itr.getLeft());
			if(itr.getRight()!=null)
				q1.add(itr.getRight());
		}
	}
	
	public void sumLeafNode() {
		int sum1=0,sum2=0;
		BtNode itr;
		if(root==null) {
			System.out.println("Empty");
			return;
		}
		
		Queue<BtNode> q1=new LinkedList<BtNode>();
		q1.add(root);
		while(!q1.isEmpty()) {
			itr=q1.remove();
			if(itr.getLeft()==null&&itr.getRight()==null) {
				sum1+=itr.getData();
			}
			if(itr.getLeft()!=null&&itr.getRight()!=null) {
				sum2+=itr.getData();
			}
			if(itr.getLeft()!=null)
				q1.add(itr.getLeft());
			if(itr.getRight()!=null)
				q1.add(itr.getRight());
		}
		System.out.println("Sum of leafNode = "+sum1);
		System.out.println("Sum of nonLeafNode = "+sum2);

	}
	public int minLeaf() {
		int min=root.getData();
		BtNode itr;
		if(root==null) return 0;
		Queue<BtNode> q=new LinkedList<BtNode>();
		q.add(root);
		while(!q.isEmpty()) {
			itr=q.remove();
			if(itr.getData()<min) {
				min=itr.getData();
				
			}
			if(itr.getLeft()!=null)
				q.add(itr.getLeft());
			if(itr.getRight()!=null)
				q.add(itr.getRight());
			
		}
		return min;
	}
	public int maxLeaf() {
		int max=root.getData();
		BtNode itr;
		if(root==null) return 0;
		Queue<BtNode> q=new LinkedList<BtNode>();
		q.add(root);
		while(!q.isEmpty()) {
			itr=q.remove();
			if(itr.getData()>max) {
				max=itr.getData();
				
			}
			if(itr.getLeft()!=null)
				q.add(itr.getLeft());
			if(itr.getRight()!=null)
				q.add(itr.getRight());
			
		}
		return max;
	}
	
}

public class BinaryTreeMain {
	public static void main(String[] args) {
		BinaryTree tree=new BinaryTree();
		tree.setRoot(tree.createRoot(50));
		tree.getRoot().setLeft(tree.createRoot(17));
		tree.getRoot().setRight(tree.createRoot(72));
		tree.getRoot().getLeft().setLeft(tree.createRoot(12));
		tree.getRoot().getLeft().setRight(tree.createRoot(23));
		tree.getRoot().getLeft().getLeft().setLeft(tree.createRoot(9));
		tree.getRoot().getLeft().getLeft().setRight(tree.createRoot(14));
		tree.getRoot().getLeft().getRight().setLeft(tree.createRoot(19));
		tree.getRoot().setRight(tree.createRoot(72));
		tree.getRoot().getRight().setLeft(tree.createRoot(54));
		tree.getRoot().getRight().getLeft().setRight(tree.createRoot(67));
		tree.getRoot().getRight().setRight(tree.createRoot(76));
		
		System.out.println("===Display preOrder===");
		tree.preOrder();
		System.out.println();
		System.out.println("===Display Level Wise===");
		tree.displayLevelWise();
		System.out.println();
		System.out.println("===Display leaf node===");
		tree.displayLeaf();
		System.out.println();
		System.out.println("===Display Non Leaf===");
		tree.nonLeafNode();
		System.out.println();
		tree.sumLeafNode();
		System.out.println("\nMin from nodes: "+tree.minLeaf());
		System.out.println("\nMax from nodes: "+tree.maxLeaf());

	}
	
}
