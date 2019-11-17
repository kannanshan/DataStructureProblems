package com.hackerrank.problems;

public class SurfaceArea {

	static int surfaceArea(int[][] A) {
		int row = A.length;
		int col = A[0].length;
		int area = 0;
		for (int i = 0; i < row; i++) {
			for (int j = 0; j < col; j++) {
				area=area+getArea(i, j, A);
			}
		}
		return area;
	}

	static int getArea(int i, int j, int[][] arr) {
		int val = 0;
		int val1[] = new int[4];
		val1[0] = -1;
		val1[1] = -1;
		val1[2] = -1;
		val1[3] = -1;
		int[][] temp = { { -1, 0 }, { 1, 0 }, { 0, 1 }, { 0, -1 } };
		int k = 0;
		for (int[] te : temp) {
			int row = i + te[0];
			int col = j + te[1];
			if ((row >= 0 && row < arr.length) && (col >= 0 && col < arr[0].length)) {
				val1[k] = arr[row][col];
			}
			k++;
		}
		for (int l = 0; l < 4; l++) {
			if (val1[l] == -1) {
				val = val + arr[i][j];
			}
			else if (arr[i][j] > val1[l]) {
				val = val + arr[i][j] - val1[l];
			}
		}

		return val+2;
	}
	
	public static void main(String args[])
	{
		//int[][] arr = {{1}};
		int[][] arr = {{1,3,4},{2,2,3},{1,2,4}};
		System.out.println(surfaceArea(arr));
	}

}
