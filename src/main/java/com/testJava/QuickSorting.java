package com.testJava;

import java.util.Arrays;

public class QuickSorting {
	public void quickSort(int[] arri) {
		this.quickSort(arri, 0, arri.length - 1);
	}
	
	public void quickSort(int[] arri, int start, int end) {
		int nextPart = partion(arri, start, end);
		
		if (start < nextPart - 1) {
			quickSort(arri, start, nextPart - 1);
		}
		
		if (nextPart < end) {
			quickSort(arri, nextPart, end);
		}
	}
	
	public int partion(int[] arri, int start, int end) {
		int pivot = arri[(start + end) / 2];
		
		while (start <= end) {
			while (arri[start] < pivot) {
				start++;
			}
			
			while (arri[end] > pivot) {
				end--;
			}
			
			if (start <= end) {
				swap(arri, start, end);
				start++;
				end--;
			}
		}
		
		return start;
	}
	
	public void swap(int[] arri, int start, int end) {
		int temp = arri[end];
		arri[end] = arri[start];
		arri[start] = temp;
	}
	
	public static void main(String[] args) {
		int[] arri = {3, 9, 4, 7, 5, 0, 1, 6, 8, 2};
		System.out.println(Arrays.toString(arri));
		QuickSorting q = new QuickSorting();
		q.quickSort(arri);
		System.out.println(Arrays.toString(arri));
	}
}
