package com.testJava;

public class BinarySearchTreeClient {
	public static void main(String[] args) {
		BinarySearchTree bst = new BinarySearchTree();
		bst.insert(60);
		bst.insert(20);
		bst.insert(90);
		bst.insert(40);
		bst.insert(50);
		bst.insert(80);
		bst.insert(39);
		bst.height();
		bst.max();
		bst.min();
		bst.search(30);
		System.out.println();
		System.out.println("Inorder Traversal");
		bst.inorder();
		System.out.println("Preorder Traversal");
		bst.preorder();
		System.out.println("Postorder Traversal");
		bst.postorder();
		
		System.out.println();
		bst.delete(39);
		System.out.println();
		
		System.out.println("Inorder Traversal");
		bst.inorder();
		System.out.println("Preorder Traversal");
		bst.preorder();
		System.out.println("Postorder Traversal");
		bst.postorder();
	}
}
