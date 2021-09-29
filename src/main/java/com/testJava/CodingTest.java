package com.testJava;

import java.util.Arrays;
import java.util.HashMap;

public class CodingTest {
	public static void main(String[] args) {
		int array1[] = new int[10];
		array1[0] = 6;
		array1[1] = 12;
		array1[2] = 18;
		array1[3] = 24;
		array1[4] = 30;

		int array2[] = new int[10];
		array2[0] = 7;
		array2[1] = 14;
		array2[2] = 21;
		array2[3] = 28;
		array2[4] = 35;

		int array3[] = new int[10];

		int afp = 0;
		int asp = 0;
		int atp = 0;

		for (int j = 0; j < array1.length; j++) {
			if (array1[afp] < array2[asp]) {
				array3[atp] = array1[afp];
				afp = afp + 1;
				atp = atp + 1;
				System.out.print("inside1: ");
				System.out.print(Arrays.toString(array3));
				System.out.print(" " + "afp: " + afp);
				System.out.print(" " + "asp: " + asp);
				System.out.print(" " + "atp: " + atp);
				System.out.print(" " + "array1[" + afp +"]: " + array1[afp]);
				System.out.println(" " + "array2[" + afp +"]: " + array2[asp]);
			} else if (array2[asp] < array1[afp]) {
				array3[atp] = array2[asp];
				asp = asp + 1;
				atp = atp + 1;
				System.out.print("inside2: ");
				System.out.print(Arrays.toString(array3));
				System.out.print(" " + "afp: " + afp);
				System.out.print(" " + "asp: " + asp);
				System.out.print(" " + "atp: " + atp);
				System.out.print(" " + "array1[" + afp +"]: " + array1[afp]);
				System.out.println(" " + "array2[" + afp +"]: " + array2[asp]);
			} else {
				array3[atp] = array1[afp];
				atp = atp + 1;
				afp = afp + 1;
				
				array3[atp] = array2[asp];
				atp = atp + 1;
				asp = asp + 1;
			}
		}

		System.out.println(Arrays.toString(array3));
	}

	public void cloth() {
		String[][] clothes = { { "yellowhat", "headgear" }, { "bluesunglasses", "eyewear" },
				{ "green_turban", "headgear" } };

		HashMap<String, String> map = new HashMap<String, String>();

		for (int i = 0; i < clothes.length; i++) {
			map.put(clothes[i][1], clothes[i][0]);
			if (!map.get(clothes[i][1]).equals(clothes[i][1])) {
				map.put(clothes[i][1] + String.valueOf(i), clothes[i][0]);
			} else {
				map.put(clothes[i][1], clothes[i][0]);
			}
		}

		System.out.println(map);
	}

	public String player(String[] participant, String[] completion) {
		Arrays.toString(participant);
		Arrays.toString(completion);

		System.out.println(Arrays.toString(participant));
		System.out.println(Arrays.toString(completion));

		int i;

		for (i = 0; i < completion.length; i++) {
			if (!participant[i].equals(completion[i])) {
				return participant[i];
			}
		}

		return null;
	}
}
