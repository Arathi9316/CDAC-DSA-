package binarytree;

import java.util.LinkedList;
import java.util.Queue;

class BinaryTree1{
	private  BtNode root;
	public BinaryTree1() {
		root=null;
	}
	public void setRoot(BtNode r) {
		root=r;
	}
	public BtNode getRoot() {
		return root;
	}
	//levelwise insertion
	public void insert(int d) {
		BtNode new_node=new BtNode(d);
		if(root==null) {
		root=new_node;
		return;
		}
		Queue<BtNode> q=new LinkedList<BtNode>();
		q.add(root);
		BtNode itr;
		while(!q.isEmpty()) {
			itr=q.remove();
			if(itr.getLeft()==null) {
				itr.setLeft(new_node);
				return;
			}
			else {
				q.add(itr.getLeft());
			}
			if(itr.getRight()==null) {
				itr.setRight(new_node);
				return;
			}
			else {
				q.add(itr.getRight());
			}
			
		}}
		private void preOrder(BtNode r) {
			if(r==null) {
//				System.out.print(" null ");
				return;
			}
			System.out.print(r.getData()+" ");
			preOrder(r.getLeft());
			preOrder(r.getRight());
		}
		public void preOrderTraversal() {
			preOrder(root);
		}
		public boolean compareTree(BinaryTree1 t1) {
			BtNode itr1,itr2;
			if(root==null||t1.root==null)return false;
			Queue<BtNode> q1=new LinkedList<BtNode>();
			Queue<BtNode> q2=new LinkedList<BtNode>();
			q1.add(root);
			q2.add(t1.root);
			while((!q1.isEmpty())&&(!q2.isEmpty())){
				itr1=q1.remove();
				itr2=q2.remove();
				if(itr1.getData()!=itr2.getData())return false;
				if(itr1.getLeft()!=null) {
					q1.add(itr1.getLeft());
				}
				if(itr1.getRight()!=null) {
					q1.add(itr1.getRight());
				}
				if(itr2.getLeft()!=null) {
					q2.add(itr2.getLeft());
				}
				if(itr2.getRight()!=null) {
					q2.add(itr2.getRight());
				}
			}
			if(q1.isEmpty()&&q2.isEmpty())
				return true;
			else return false;
		}
	}


public class TreeComparison {
	
	public static void main(String[] args) {
		BinaryTree1 tree1=new BinaryTree1();
		tree1.insert(5);
		tree1.insert(7);
		tree1.insert(4);
		tree1.insert(2);
		tree1.insert(1);
		tree1.insert(8);
		System.out.println("===Tree 1===");
		tree1.preOrderTraversal();
		BinaryTree1 tree2=new BinaryTree1();
		tree2.insert(5);
		tree2.insert(7);
		tree2.insert(4);
		tree2.insert(2);
		tree2.insert(1);
		tree2.insert(8);
		
		System.out.println("\n===Tree 2===");
		tree2.preOrderTraversal();
		
		System.out.println("\n"+tree1.compareTree(tree2));
	}
}
