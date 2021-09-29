package com.testJava;

public class CircularQueue {
	int front;
	int end;
	int size;
	int[] array;
	
	public CircularQueue(int size) {
		this.front = 0;
		this.end = 0;
		this.size = size;
		this.array = new int[size];
	}
	
	public boolean isFull() {
		if (((end + 1) % size) == front) {
			return true;
		}
		return false;
	}
	
	public boolean isEmpty() {
		return (front == end);
	}
	
	public void enQueue(int data) {
		if (isFull()) {
			System.out.println("Queue has no space");
		} else {
			
		}
	}
}
