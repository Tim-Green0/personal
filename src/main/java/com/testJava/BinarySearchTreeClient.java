package com.testJava;

public class BinarySearchTreeClient {
	public static void main(String[] args) {
		BinarySearchTree bst = new BinarySearchTree();
//		bst.insert(60);
//		bst.insert(20);
//		bst.insert(90);
//		bst.insert(40);  
//		bst.insert(10);
		
		bst.insert(60);
		bst.insert(20);
		bst.insert(90);
		bst.insert(10);  
		bst.insert(40);
//		bst.insert(2);
//		bst.insert(15);  
//		bst.insert(13);
//		bst.insert(17);

//		bst.height();
//		bst.max();
//		bst.min();
//		bst.search(30);
		System.out.println();
		System.out.println("Inorder Traversal");
		bst.inorder();
		System.out.println("Preorder Traversal");
		bst.preorder();
		System.out.println("Postorder Traversal");
		bst.postorder();
		
		System.out.println();
		bst.mirror();
		System.out.println();
		
		System.out.println("Inorder Traversal");
		bst.inorder();
		System.out.println("Preorder Traversal");
		bst.preorder();
		System.out.println("Postorder Traversal");
		bst.postorder();
	}
}
