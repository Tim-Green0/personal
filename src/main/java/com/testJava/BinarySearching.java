package com.testJava;

public class BinarySearching {
	public static void main(String[] args) {
		int[] arri = {10, 20, 30, 40, 50, 60, 70, 80};
		
		int begin = 0;
		int end = arri.length;
		int pos;
		int value = 55;
		
		while(begin <= end) {
			int mid = (begin + end) / 2;
			
			if (arri[mid] < value) {
				begin = mid + 1;
			} else if (arri[mid] > value) {
				end = mid - 1;
			} else {
				System.out.println(mid);
			}
			System.out.println("Not Found: " + mid);
		}
	}
}
