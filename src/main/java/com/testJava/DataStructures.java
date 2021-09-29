package com.testJava;

import java.util.Scanner;

public class DataStructures {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
		int[] arri;
		System.out.println("***Linear Search***");
		System.out.println("Enter number of elements in array: ");
		int n = scan.nextInt();
		arri = new int[n];
		
		System.out.println("Enter value of arrays: ");
		for (int i = 0; i < n; i++) {
			arri[i] = scan.nextInt();
		}
		
		System.out.println("Enter value to serach: ");
		int value = scan.nextInt();
		
		int result = linear_search(arri, value);
		
		if (result != 00 ) {
			System.out.println(value + " found at " + (result + 1) + " position");
		} else {
			System.out.println("Value Not Found");
		}
	}
	
	public static int linear_search(int[] arri, int value) {
		int result = 00;
		
		for (int i = 0; i < arri.length; i++) {
			if (arri[i] == value) {
				result = i;
				break;
			} 
		}
		
		return result;
		
	}
}
