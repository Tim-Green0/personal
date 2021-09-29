package com.testJava;

public class MG {
	public static void main(String[] args) {
		int problem = 987;
		int solve = 0;
		
		while (true) {
			solve = problem % 10 + solve;
			problem = problem / 10;
			
			if (problem == 0) {
				break;
			}
		}
		
		System.out.println(solve);
	}
}
