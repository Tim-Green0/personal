package com.testJava;

import java.util.Arrays;

public class MergeSorting {
	public void mergeSort(int[] arri) {
		divideArray(arri, 0, arri.length - 1);
	}
	
	private void divideArray(int[] arri, int beg, int end) {
		if (beg < end) {
			int mid = (beg + end) / 2;
			divideArray(arri, beg, mid);
			divideArray(arri, mid + 1, end);
			mergeSort(arri, beg, mid, end);
		}
	}
	
	private void mergeSort(int[] arri, int beg, int mid, int end) {
		int i = beg;
		int j = mid + 1;
		int k = beg;
		int temp[] = new int[arri.length];
		
		while (i <= mid && j <= end) {
			if (arri[i] < arri[j]) {
				temp[k++] = arri[i++];
			} else {
				temp[k++] = arri[j++];
			}
		}
		
		while (i <= mid) {
			temp[k++] = arri[i++];
		}
		
		while (j <= end) {
			temp[k++] = arri[j++];
		}
		
		for (int update = beg; update < k; update++) {
			arri[update] = temp[update];
		}
	}
	
	public static void main(String[] args) {
		int[] arri = {3, 9, 4, 7, 5, 0, 1, 6, 8, 2};
		System.out.println(Arrays.toString(arri));
		MergeSorting m = new MergeSorting();
		m.mergeSort(arri); 
		System.out.println(Arrays.toString(arri));
	}
}
