package com.testJava;

import java.util.Scanner;

public class LLClient {
	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		LinkedList1 list = new LinkedList1();
		boolean flag = true;
		
		try {
			while (flag) {
				System.out.println("\n***MENU***");
				System.out.println("1. Insertion");
				System.out.println("2. Deletion");
				System.out.println("3. Display");
				System.out.println("4. Exit");
				System.out.println("Enter your choice: ");
				int choice = scn.nextInt();
				int item = 0;
				int pos = 0;
				
				switch (choice) {
				case 1:
					System.out.println("Enter value of node: ");
					item = scn.nextInt();
					System.out.println("Enter postition of node: ");
					pos = scn.nextInt();
					list.insertion(item, pos - 1);
					System.out.println(item + " Insertion successfully at " + pos);
					break;
				
				case 2:
					System.out.println("Enter postition of node: ");
					pos = scn.nextInt();
					list.deletion(pos - 1);
					System.out.println("Item deleted successfully");
					break;
				
				case 3:
					list.display();
					break;
					
				case 4:
					flag = false;
					System.out.println("Terminated.....");
					break;
				
				default:
					System.out.println("Wrong choice");
					break;
				}
				
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
}
