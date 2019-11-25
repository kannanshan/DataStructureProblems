package com.hackerrank.hard.problems;

import java.util.Stack;

public class Island {

	static class Pointer {
		int row;
		int col;

		public Pointer(int row, int col) {
			this.row = row;
			this.col = col;
		}
	}

	public static int maxAreaOfIsland(int[][] grid) {
		int max = 0;
		for (int i = 0; i < grid.length; i++) {
			for (int j = 0; j < grid[0].length; j++) {
				if (grid[i][j] == 1)
					max = Math.max(max, getValue(i, j, grid));
			}
		}
		return max;
	}

	private static int getValue(int row, int col, int[][] grid) {
		int value = 0;
		Stack<Pointer> stack = new Stack();
		grid[row][col]=-1;
		stack.push(new Pointer(row, col));
		while (!stack.empty()) {
			Pointer p = stack.pop();
			int[][] posArray = { { 0, 1 }, { 0, -1 }, { 1, 0 }, { -1, 0 } };
			for (int[] pos : posArray) {
				int tempRow = p.row + pos[0];
				int tempCol = p.col + pos[1];
				if (tempRow >= 0 && tempRow < grid.length && tempCol >= 0 && tempCol < grid[0].length
						&& grid[tempRow][tempCol] == 1) {
					grid[tempRow][tempCol] = -1;
					stack.push(new Pointer(tempRow, tempCol));
				}
			}
			value++;
		}
		return value;
	}

	public static void main(String args[]) {
		int[][] arr = { { 1, 1, 0, 0, 0 }, { 1, 1, 0, 0, 0 }, { 0, 0, 0, 1, 1 }, { 0, 0, 0, 1, 1 } };
		System.out.println(maxAreaOfIsland(arr));
	}

}
