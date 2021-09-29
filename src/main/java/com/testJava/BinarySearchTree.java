package com.testJava;

public class BinarySearchTree {
	private class Node {
		Node left;
		int data;
		Node right;
	}
	
	private Node root;
	
	public Node createNewNode(int data) {
		Node newNode = new Node();
		newNode.data = data;
		newNode.left = null;
		newNode.right = null;
		return newNode;
	}
	
	public void insert(int data) {
		if (root == null) {
			Node newRoot = new Node();
			newRoot.data = data;
			newRoot.left = null;
			newRoot.right = null;
			root = newRoot;
		} else {
			insert(root, data);
		}
		System.out.println("Insertion Successful!!");
		System.out.println("Tree after insertion is: ");
		display();
		System.out.println();
	}
	
	private void insert(Node node, int data) {
		if (node == null) {
			return;
		}
		
		if (data <= root.data) { // 왼쪽 탐색
			if (node.left == null) {
				Node newNode = createNewNode(data);
				node.left = newNode;
				return;
			}
			insert(node.left, data);
		} else { // 오른쪽 탐색
			if (node.right == null) {
				Node newNode = createNewNode(data);
				node.right = newNode;
				return;
			}
			insert(node.right, data);
		}
	}
	
	public void search(int data) {
		boolean answer = search(root, data);
		if (answer) {
			System.out.println(data + "found in tree");
		} else {
			System.out.println(data + "not found in tree");
		}
	}
	
	private boolean search(Node node, int data) {
		if (node == null) {
			return false;
		}
		
		if (data < node.data) { // 왼쪽으로
			return search(node.left, data);
		} else if (data > node.data) { // 오른쪽으로
			return search(node.right, data);
		} else {
			return true;
		}
	}
	
	public void delete(int data) {
		if (data == root.data) { // root 노드를 없애야될때
			if (root.left == null) {
				root = root.right;
			} else if (root.right == null) {
				root = root.left;
			} else {
				delete(root, null, data);
			}
		} else {
			delete(root, null, data);
		}
		
		System.out.println("Deletion Successful!!");
		System.out.println("Tree after deletion is: ");
		display();
		System.out.println();
	}
	
	private void delete(Node node, Node parent, int data) {
		if (node == null) {
			return;
		}
		
		if (data < node.data) { // 왼쪽으로
			delete(node.left, node, data);
		} else if (data > node.data) {
			delete(node.right, node, data);
		} else {
			if (node.left == null && node.right == null) {
				if (data <= parent.data) {
					parent.left = null;
				} else {
					parent.right = null;
				}
			} else if (node.left != null && node.right == null) {
				if (data <= parent.data) { /* 한단계 위의 노드와 쇼부보는거 -> 위의 노드의 데이터 보다 찾는 데이터가 작으면 -> 위의 노드의 왼쪽에 위치함 */
					parent.left = node.left;
				} else {
					parent.right = node.left;
				}
			} else if (node.left == null && node.right != null) {
				if (data <= parent.data) { /* 한단계 위의 노드와 쇼부보는거 -> 위의 노드의 데이터 보다 찾는 데이터가 크면 -> 위의 노드의 오른쪽에 위치함 */
					parent.left = node.right;
				} else {
					parent.right = node.right;
				}
			} else {
				int max = max(node.left);
				delete(node.left, node, max);
				node.data = max;
				
				
//				if (flag == 'l') {
//					Node rightNode = node.right;
//					rightNode.left = node.left;
//					parent.left = rightNode;
//				} else {
//					Node leftNode = node.left;
//					leftNode.right = node.right;
//					parent.right = leftNode;
//				}
				
			}
		}	
	}
	
	public void min() {
		System.out.println("Min element of tree is: " + min(root));
	}
	
	private int min(Node node) {
		if (node.left == null) {
			return node.data;
		}
		return min(node.left);
	}
	
	public void max() {
		System.out.println("Max element of tree is: " + max(root));
	}
	
	private int max(Node node) {
		if (node.right == null) {
			return node.data;
		}
		return max(node.right);
	}
	
	public void height() {
		System.out.println("Height of tree is: " + height(root));
	}
	
	private int height(Node node) {
		if (node == null) {
			return -1;
		}
		
		int ht = 0;
		int lh = height(node.left);
		int rh = height(node.right);
		if (lh > rh) {
			ht += lh;
		} else {
			ht += rh;
		}
		return ht + 1;
	}
	
	public void preorder() {
		preorder(root);
		System.out.println();
	}
	
	public void preorder(Node node) {
		if (node == null) {
			return;
		}
		System.out.print(node.data + " ");
		preorder(node.left);
		preorder(node.right);
	}
	
	public void postorder() {
		postorder(root);
		System.out.println();
	}
	
	public void postorder(Node node) {
		if (node == null) {
			return;
		}
		postorder(node.left);
		postorder(node.right);
		System.out.print(node.data + " ");
	}
	
	public void inorder() {
		inorder(root);
		System.out.println();
	}
	
	public void inorder(Node node) {
		if (node == null) {
			return;
		}
		inorder(node.left);
		System.out.print(node.data + " ");
		inorder(node.right);
	}
	
	public void display() {
		inorder(root);
	}
}