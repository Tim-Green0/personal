package com.testJava;

public class Fibonacci {
	public void fibo(int end) {
		for (int i = 1; i < end; i++) {
			System.out.print(fiboSol(i) + " ");
		}
	}
	
	private int fiboSol(int data) {
		if (data <= 1) {
			return 1;
		}
		return (data - 2) + (data - 1);
	}
	
	public static void main(String[] args) {
		Fibonacci f = new Fibonacci();
		f.fibo(10);
	}
}
