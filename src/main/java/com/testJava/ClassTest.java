package com.testJava;

public class ClassTest {
	public static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) {
		int n = 5;
		int cnt = 0;
		sb.append((int) (Math.pow(2, n) - 1)).append("\n");
		
		Hanoi(n, 1, 2, 3);
		System.out.println(sb);
	}
	
	public static void Hanoi(int n, int start, int mid, int to) {
		if (n == 1) {
			sb.append(start + " " + to + "\n");
			return;
		}
		
		Hanoi(n - 1, start, to, mid); 
		sb.append(start + " " + to + "\n");
		Hanoi(n - 1, mid, start, to);
	}
}
