package com.testJava;

import java.util.Arrays;

public class Sequence {
	public static void main(String[] args) {
		int[] arr = {4, 1, 3};
		boolean answer = true;
		
		Arrays.sort(arr);
		
		for (int i = 1; i <= arr.length; i++) {
			if (i != arr[i - 1]) {
				answer = false;
				break;
			}
		}
	}
}
