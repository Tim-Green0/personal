package com.testJava;

public class Factorial {
	public static int factor(int data) {
		if (data <= 1) {
			return data;
		}
		return factor(data - 1) * data;
	}
	
	public static void main(String[] args) {
		int result = factor(4);
		System.out.println(result);
	}
}
