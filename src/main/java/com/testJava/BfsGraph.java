package com.testJava;

import java.util.Arrays;

public class BfsGraph {
	private int numV;
	private boolean[][] matrix;
	int[] checkArray;
	int[] result;
	int rear;
	int front;
	
	public BfsGraph(int v) {
		numV = v;
		matrix = new boolean[numV + 1][numV + 1];
		checkArray = new int[10];
		result = new int[10];
		rear = -1;
		front = -1;
	}
	
	public void addEdge(int u, int v) {
		matrix[u][v] = true;
	}
	
	public void showMatrix() {
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[i].length; j++) {
				if (matrix[i][j] == true) {
					System.out.print("TRUE!" + " ");
				} else {
					System.out.print(matrix[i][j] + " ");
				}
			}
			System.out.println();
		}
	}
	
	public void bfs(int start) {
		int resultIndex = 0;
		checkArray[++rear] = start;
		
		while (rear > front) {
			for (int i = 0; i < matrix[start].length; i++) {
				if (matrix[start][i] == true) {
					if (!isResultIn(i) && !isCheck(i)) { // false여야 작동함
						checkArray[++rear] = i;
					}
				}
			}
			result[resultIndex++] = checkArray[++front];
			start = checkArray[front + 1];
		}
		
		this.printResult();
	}
	
	public boolean isResultIn(int num) {
		for (int i = 0; i < result.length; i++) {
			if (num == result[i]) {
				return true;
			}
		}
		return false;
	}
	
	public boolean isCheck(int num) {
		for (int i = 0; i < checkArray.length; i++) {
			if (num == checkArray[i]) {
				return true;
			}
		}
		
		return false;
	}
	
	public void printResult() {
		System.out.println(Arrays.toString(checkArray));
		System.out.println(Arrays.toString(result));
	}
	
	public static void main(String[] args) {
		BfsGraph g = new BfsGraph(7);
		g.addEdge(1, 2);
		g.addEdge(1, 4);
		g.addEdge(2, 3);
		g.addEdge(3, 4);
		g.addEdge(4, 5);
		g.addEdge(5, 6);
		g.addEdge(6, 7);
		g.addEdge(5, 7);
		
		g.bfs(1);
		
	}
}
