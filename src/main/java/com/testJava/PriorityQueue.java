package com.testJava;

public class PriorityQueue {
	private class Node {
		int data;
		int priority;
		Node next;
	}
	
	private Node first;
	
	private Node create_Node(int data, int priority) {
		Node node = new Node();
		node.data = data;
		node.priority = priority;
		node.next = null;
		
		return node;
	}
	
	public void insertion(int data, int priority) {
		if (first == null || priority <= first.priority) {
			Node node = this.create_Node(data, priority);
			node.next = first;
			first = node;
		} else {
			Node next = first;
			
			while (next.next != null && (next.next).priority <= priority) {
				next = next.next;
			}
			
			Node node = this.create_Node(data, priority);
			
			node.next = next.next;
			next.next = node;
		}
	}
	
	public int deletion() {
		int data = 0;
		
		if (first == null) {
			System.out.println("Nothing in Queue");
		} else {
			data = first.data;
			first = first.next;
		}
		return data;
	}
	
	public void display() {
		if (first == null) {
			System.out.println("Nothing in Queue");
		} else {
			Node temp = first;
			System.out.println("Priority \t\t Value");
			while (temp != null) {
				System.out.println(temp.priority + " \t\t\t " + temp.data);
				temp = temp.next;
			}
		}
	}
	
	public static void main(String[] args) {
		PriorityQueue pq = new PriorityQueue();
		pq.insertion(1, 1);
		pq.insertion(2, 2);
		pq.insertion(5, 5);
		pq.insertion(4, 4);
		pq.insertion(3, 3);
		
		pq.display();
	}
}





















