package com.testJava;

public class Cars extends First{
	public static void main(String[] args) {
		Cars cars = new Cars();
		cars.method(5, "in");
		
	}
	
	public String method(int number, String name) {
		super.method(5, "1");
		System.out.println("Cars");
		return null;
	}
}
