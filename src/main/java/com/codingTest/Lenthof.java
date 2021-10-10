package com.codingTest;

import java.util.Arrays;

public class Lenthof {
	public static void main(String[] args) {
		int[] chars = new int[128];

		String s = "abcabcbb";
		char r = s.charAt(0);
		System.out.println((int) r);
		chars[r]++;
		System.out.println(Arrays.toString(chars));
	}

	public static void test() {

	}
}
