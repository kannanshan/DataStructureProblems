package com.hackerrank.hard.problems;

public class CountServers {

	public int countServers(int[][] grid) {
		int val = 0;
		for (int i = 0; i < grid.length; i++) {
			for (int j = 0; j < grid[0].length; j++) {
				if (Math.abs(grid[i][j]) == 1) {
					val = val + checcol(i, j, grid) + checRow(i, j, grid);
				}
			}
		}
		return val;
	}

	private int checRow(int k, int l, int[][] grid) {
		int val = 0;
		boolean flag = false;
		for (int i = 0; i < grid.length; i++) {
			if (Math.abs(grid[i][l]) == 1 && k != i) {
				flag = true;
				if (grid[i][l] != -1)
					val++;
				grid[i][l] = -1;
			}
		}
		if (flag && grid[k][l] == 1) {
			grid[k][l] = -1;
			val++;
		}
		return val;
	}

	private int checcol(int k, int l, int[][] grid) {

		int val = 0;
		boolean flag = false;
		for (int i = 0; i < grid[0].length; i++) {
			if (Math.abs(grid[k][i]) == 1 && l != i) {
				flag = true;
				if (grid[k][i] != -1)
					val++;
				grid[k][i] = -1;
			}
		}
		if (flag && grid[k][l] == 1) {
			grid[k][l] = -1;
			val++;
		}
		return val;

	}

	public static void main(String args[]) {

		int[][] arr = { { 0, 0, 0, 0 }, { 1, 1, 1, 1 }, { 0, 0, 0, 1 }, { 0, 0, 1, 1 }, { 0, 0, 0, 1 } };
		CountServers c = new CountServers();
		System.out.println(c.countServers(arr));
	}

}
