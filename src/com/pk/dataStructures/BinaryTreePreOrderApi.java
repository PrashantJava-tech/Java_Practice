package com.pk.dataStructures;

import java.util.LinkedList;
import java.util.Queue;

public class BinaryTreePreOrderApi {

	/**
	 * class to hold single node
	 */
	static class Node{
		int data;
		Node left;
		Node right;
		
		Node(int data){
			this.data = data;
			this.left = null;
			this.right = null;
		}
	}
	
	/**
	 * populate binary tree using recursion
	 */
	static class BinaryTree{
		
		static int idx = -1;
		public static Node buildTree(int nodes[]) {
			
			// index to traverse element from nodes[] and create new nodes
			idx++; 
			if(nodes[idx] == -1) {
				return null;
			}
			Node newNode = new Node(nodes[idx]);
			newNode.left = buildTree(nodes);
			newNode.right = buildTree(nodes);

			return newNode;
		}
	}
	
	/**
	 * Traverse binary tree using preOrder
	 * @param root
	 */
	public static void preOrder(Node root) {
		if( root == null) {
			//System.out.print("-1 ");
			return;
		}
		System.out.print(root.data+" ");
		preOrder(root.left);
		preOrder(root.right);
		
	}

	/**
	 * Traverse binary tree using inOrder
	 * @param root
	 */
	public static void inOrder(Node root) {
		if( root == null) {
			//System.out.print("-1 ");
			return;
		}
		inOrder(root.left);
		System.out.print(root.data+" ");
		inOrder(root.right);
		
	}

	/**
	 * Traverse binary tree using postOrder
	 * @param root
	 */
	public static void postOrder(Node root) {
		if( root == null) {
			//System.out.print("-1 ");
			return;
		}
		postOrder(root.left);
		postOrder(root.right);
		System.out.print(root.data+" ");
		
	}
	
	/**
	 * Traverse binary tree using levelOrder
	 * @param root
	 */

	public static void levelOrder(Node root) {
		if( root == null) {
			//System.out.print("-1 ");
			return;
		}
		Queue<Node> queue = new LinkedList<>();
		queue.add(root);
		queue.add(null);
		
		while(!queue.isEmpty()) {
			Node currNode = queue.remove();
			if(currNode == null) {
				System.out.println();
				if(queue.isEmpty()) {
					break;
				}else {
					queue.add(null);
				}
			} else {
				System.out.print(currNode.data+" ");
				if(currNode.left != null) {
					queue.add(currNode.left);
				}
				if(currNode.right != null) {
					queue.add(currNode.right);
				}
			}
		}
	}
	

	/**
	 * get the total number of nodes in given binary tree
	 * @param root
	 */
	public static int countOfNodes(Node root) {
		if( root == null) {
			//System.out.print("-1 ");
			return 0;
		}
		
		int leftNodeCount = countOfNodes(root.left);
		int rightNodeCount = countOfNodes(root.right);
		return leftNodeCount + rightNodeCount + 1;
	}
	
	/**
	 * get the sum of node data of nodes in given binary tree
	 * @param root
	 */
	public static int sumOfNodes(Node root) {
		if( root == null) {
			//System.out.print("-1 ");
			return 0;
		}
		
		int leftSum = sumOfNodes(root.left);
		int rightSum = sumOfNodes(root.right);
		return leftSum + rightSum + root.data;
	}

	/**
	 * get the height of node in given binary tree
	 * @param root
	 */
	public static int heightOfNodes(Node root) {
		if( root == null) {
			//System.out.print("-1 ");
			return 0;
		}
		
		int leftHeight = heightOfNodes(root.left);
		int rightHeight = heightOfNodes(root.right);
		
		int height = Math.max(leftHeight, rightHeight) + 1;
		return height;
	}

	/**
	 * get the diameter of nodes(longest distance between two nodes) in given binary tree
	 * 
	 * o(n2), diameter + height, 
	 * will update in next method
	 * @param root
	 */
	public static int diameterOfNodes(Node root) {
		if( root == null) {
			//System.out.print("-1 ");
			return 0;
		}
		
		int DLS = diameterOfNodes(root.left);
		int DRS = diameterOfNodes(root.right);
		int Diameter= heightOfNodes(root.left) + heightOfNodes(root.right) + 1;
		
		return Math.max(Diameter, Math.max(DLS, DRS ));
	}

	
	
	static class TreeInfo {
		int diameter;
		int height;
		public TreeInfo(int diam, int height) {
			this.diameter = diam;
			this.height = height;
		}
	}
	/**
	 * get the diameter of nodes(longest distance between two nodes) in given binary tree
	 * 
	 * o(n), as we are calculating this at one traverse only.( diameter + height) 
	 * @param root
	 */
	public static TreeInfo diameterOfNodes2(Node root) {
		
		//best case
		if( root == null) {
			return new TreeInfo(0, 0);
		}
		TreeInfo leftTreeInfo = diameterOfNodes2(root.left);
		TreeInfo rightTreeInfo = diameterOfNodes2(root.right);
		
		int rootHeight = Math.max(leftTreeInfo.height, rightTreeInfo.height) + 1;
		
		int diam1 = leftTreeInfo.diameter;
		int diam2 = rightTreeInfo.diameter;
		int diam3 = leftTreeInfo.height + rightTreeInfo.height + 1;
				
		int rootDiam =  Math.max(Math.max(diam1, diam2 ), diam3);
		
		return new TreeInfo(rootDiam, rootHeight);
	}

	public static void main(String[] args) {
		
		int nodes[] = {1, 2, 4, -1, -1, 5, -1, -1, 3, -1, 6, -1, -1};
		Node root = BinaryTree.buildTree(nodes);  
		//System.out.println(root.data);
		
		//preOrder(root);
		//inOrder(root);
		//postOrder(root);
		//levelOrder(root);
		System.out.println("countOfNodes="+countOfNodes(root));
		System.out.println("sumOfNodes="+sumOfNodes(root));
		System.out.println("heightOfNodes="+heightOfNodes(root));
		System.out.println("diameterOfNodes with o(n2)="+diameterOfNodes(root));
		System.out.println("diameterOfNodes2 with o(n)="+diameterOfNodes2(root).diameter);

}
}
