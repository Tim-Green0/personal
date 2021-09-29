package com.testJava;

public class CircularLinkedList {
	private class Node {
		int data;
		Node next;
	}
	
	Node start;
	Node end;
	int size;
	
	private Node create_new_Node(int data) {
		Node newNode = new Node();
		newNode.data = data;
		newNode.next = null;
		
		return newNode;
	}
	
	private Node getNodeAt(int pos) throws Exception {
		if (size == 0) {
			throw new Exception("Linked List is Empty");
		}
		if (pos < 0 || size <= pos) {
			throw new Exception("Invalid Index");
		}
		
		Node temp = start;
		for (int i = 0; i < pos; i++) {
			temp = temp.next;
		}
		
		return temp;
	}
	
	public void insertion(int data, int pos) throws Exception {
		if (pos < 0 || pos > size) {
			throw new Exception("Invalid Index");
		}
		
		if (pos == 0) { // Beginning
			insertion_beginning(data);
		} else if (pos == size) { // End
			insertion_end(data);
		} else { // Particular Position
			Node prev = getNodeAt(pos - 1);
			Node newNode = create_new_Node(data);
			Node nextNode = prev.next;
			prev.next = newNode;
			newNode.next = nextNode;
			size++;
		}
	}
	
	private void insertion_beginning(int data) {
		Node newNode = create_new_Node(data);
		
		if (size == 0) {
			start = newNode;
			end = newNode;
		} else {
			newNode.next = start;
			start = newNode;
		}
		
		end.next = start;
		size++;
	}
	
	private void insertion_end(int data) {
		Node newNode = create_new_Node(data);
		if (size > 0) {
			end.next = newNode;
			end = newNode;	
		}
		if (size == 0) {
			start = newNode;
			end = newNode;
		}
		
		end.next = start;
		size++;
	}
	
	public void deletion(int pos) throws Exception {
		if (pos < 0 || pos > size) {
			throw new Exception("Invalid Position");
		}
		
		if (pos == 0) {
			delete_beginning();
		} else if (pos == size) {
			delete_end();
		} else {
			Node prev = getNodeAt(pos - 1);
			Node next = getNodeAt(pos + 1);
			prev.next = next;
		}
		size--;
	}
	
	private void delete_beginning() {
		Node nextNode = start.next;
		end.next = nextNode;
		start = nextNode;
	}
	
	private void delete_end() throws Exception {
		Node newLast = getNodeAt(size - 1);
		newLast.next = start;
		end = newLast;
	}
	
	public void display() throws Exception {
		if (size == 0) {
			throw new Exception("Linked List is Empty");
		}
		
		Node temp = start;
		while (temp != end) {
			System.out.print(temp.data + " -> ");
			temp = temp.next;
		}
		
		System.out.print(end.data + " -> ");
		Node first = end.next;
		System.out.println(first.data + "\n");
//		System.out.println("NULL \n");
	}
}





















