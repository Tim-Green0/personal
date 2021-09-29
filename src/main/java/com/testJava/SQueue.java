package com.testJava;

public class SQueue {
	static int MAX = 50;
	
	private int[] data = new int[MAX];
	private int front;
	private int rear;
	
	public void insertion(int item) throws Exception {
		if (rear == MAX - 1) {
			throw new Exception("Queue is full");
		} else {
			data[rear++] = item;
		}
	}
	
	public int deletion() throws Exception {
		if (front == rear) {
			throw new Exception("Queue is empty");
		}
		
		int temp = data[front];
		front++;
		return temp;
	}
	
	public void display() throws Exception {
		if (front == rear) {
			throw new Exception("Queue is empty");
		}
		
		for (int i = front; i < rear; i++) {
			System.out.print(data[i] + " ");
		}
	}
}
