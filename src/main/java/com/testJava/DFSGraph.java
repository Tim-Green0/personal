package com.testJava;

public class DFSGraph {
	private int numV;
	private boolean[][] matrix;
	private int[] complete;
	private int cursor;
	
	public DFSGraph(int size) {
		numV = size;
		matrix = new boolean[numV + 1][numV + 1];
		complete = new int[size];
		cursor = 0;
	}
	
	public void addEdge(int v, int nv) {
		matrix[v][nv] = true;
	}
	
	public void dfs(int start) {
		SStack stack = new SStack(10);
		stack.push(start);
		
		while (stack.size() != 0) {
			int topMost = stack.pop();
			complete[cursor++] = topMost;
			for (int i = 0; i < matrix[topMost].length; i++) {
				if (matrix[topMost][i] == true) {
					if (!isChecked(i) && !stack.isIN(i)) {
						stack.push(i);
					}
				}
			}
		}
	}
	
	public boolean isChecked(int data) {
		for (int i = 0 ; i < complete.length; i++) {
			if (complete[i] == data) {
				return true;
			}
		}
		return false;
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
	
	public void showResult() {
		for (int i = 0 ; i < cursor; i++) {
			if (i == 0) {
				System.out.print("[");
			}
			
			if (i == cursor - 1) {
				System.out.print(complete[i] + "]");
			} else {
				System.out.print(complete[i] + ", ");
			}
		}
	}
	
	public static void main(String[] args) {
		DFSGraph dfs = new DFSGraph(4);
		dfs.addEdge(1, 2);
		dfs.addEdge(1, 3);
		dfs.addEdge(2, 3);
		dfs.addEdge(3, 4);
		dfs.addEdge(4, 2);
		
		dfs.dfs(1);
		dfs.showResult();
	}
}