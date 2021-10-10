package com.codingTest;

import java.util.Arrays;

public class twoSum {
	public static void main(String[] args) {
		int[] nums = {3,3};
		int[] result = twoSum(nums, 6);
		System.out.println(Arrays.toString(result));
	}
	
	public static int[] twoSum(int[] nums, int target) {
		int[] result = new int[2];
		boolean flag = false;
		
		for (int i = 0; i < nums.length; i++) {
			for (int j = 0 ; j < nums.length; j++) {
				if (i == j) {
					continue;
				}
				if ((nums[i] + nums[j]) == target) {
					result[0] = i;
					result[1] = j;
					flag = true;
					break;
				}
			}
			
			if (flag == true) {
				break;
			}
		}
		
		
		return result;
	}
}
