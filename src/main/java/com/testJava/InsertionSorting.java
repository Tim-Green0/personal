package com.testJava;

import java.util.Arrays;

public class InsertionSorting {
	public static void main(String[] args) {
		int[] array = {5, 8, 6, 2, 4, 10, 19, 20};
		
		for (int i = 1; i < array.length; i++) {  
			int target = array[i];
			int prev = i - 1;
			
			while (prev >= 0 && target < array[prev]) { // 이전 요소가 0보다 크고, target이 이전요소보다 작을때만 돌음  // 이전 요소가 target보다 크면, 노상관
				array[prev + 1] = array[prev];
				prev--;
			}
			 
			array[prev + 1] = target;
		}
		
		System.out.println(Arrays.toString(array));
	}
	
	public static void insertSorting(int[] arri) {
		if (arri.length <= 1) {
			return;
		}
		
		for (int i = 1; i < arri.length; i++) {
			for (int j = i; j - 1 >= 0; j--) {
				if (arri[j - 1] > arri[j]) {
					swap(arri, j - 1, j);
				}
			}
		}
	}
	
	public static void swap(int[] arri, int start, int end) {
		int temp = arri[end];
		arri[end] = arri[start];
		arri[start] = temp;
	}
}
 