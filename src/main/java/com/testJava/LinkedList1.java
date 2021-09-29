package com.testJava;

public class LinkedList1 {
	private class Node {
		int data;
		Node next;
	}

	private Node start;
	private int size;

	private Node create_new_node(int item) throws Exception {
		Node node = new Node();

		node.data = item;
		node.next = null;
		return node;

	}

	public void insertion(int item, int pos) throws Exception {
		if (pos < 0 || pos > size) {
			throw new Exception("Invalid Index");
		}
		if (pos == 0) {
			insertion_at_beginning(item);
		} else if (pos == size) {
			insertion_at_end(item);
		} else {
			Node node = create_new_node(item);
			Node prev = getNodeAt(pos - 1);
			node.next = prev.next;
			prev.next = node;
			size++;
		}
	}

	private void insertion_at_beginning(int item) throws Exception {
		Node node = create_new_node(item);
		Node temp = new Node();

		if (start == null) {
			start = node;
			start.next = null;
		} else {
			temp = start;
			start = node;
			start.next = temp;
		}
		size++;
	}

	private void insertion_at_end(int item) throws Exception {
		Node node = create_new_node(item);
		Node temp = new Node();
		temp = start;
		while (temp.next != null) {
			temp = temp.next;
		}
		temp.next = node;
		size++;
	}

	public void deletion(int pos) throws Exception {
		if (pos < 0 || pos == size) {
			throw new Exception("Invalid Index");
		}
		if (size == 0) {
			throw new Exception("Linked List is Empty");
		}
		if (pos == 0) {
			deletion_at_beginning();
		} else if (pos == size - 1) {
			deletion_at_end(pos);
		} else {
			Node prev = getNodeAt(pos - 1);
			Node next = getNodeAt(pos + 1);
			prev.next = next;
		}
		size--;
	}

	private void deletion_at_beginning() {
		start = start.next;
	}

	private void deletion_at_end(int pos) throws Exception {
		Node prev = getNodeAt(pos - 1);
		prev.next = null;
	}

	public void display() throws Exception {
		if (size == 0) {
			throw new Exception("Linked List is Empty");
		}
		Node temp = start;
		while (temp != null) {
			System.out.println(temp.data + "->");
			temp = temp.next;
		}
		System.out.println("NULL \n");
	}

	public Node getNodeAt(int index) throws Exception {
		if (size == 0) {
			throw new Exception("Linked List is Empty");
		}
		if (index < 0 || index >= size) {
			throw new Exception("Invalid Index");
		}
		Node temp = start;
		for (int i = 0; i < index; i++) {
			temp = temp.next;
		}
		return temp;
	}
}
