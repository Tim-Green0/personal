package com.testJava;

public class SStack {
	private int size;
	private int[] array;
	private int top;
	
	public SStack(int num) {
		size = num;
		array = new int[size];
		top = -1;
	}
	
	public void push(int data) {
		array[++top] = data;
	}
	
	public int pop() {
		int topMost = array[top--];
		return topMost;
	}
	
	public int size() {
		return top + 1;
	}
	
	public int peek() {
		return array[top];
	}
	
	public boolean isIN(int data) {
		for (int i = 0; i < top + 1; i++) {
			if (array[i] == data) {
				return true;
			}
		}
		return false;
	}
}
