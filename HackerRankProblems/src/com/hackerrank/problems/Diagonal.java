package com.hackerrank.problems;

import java.util.List;

public class Diagonal {

	public static int diagonalDifference(List<List<Integer>> arr) {
		int row = arr.size();
		int val = 0;
		for (int i = 0; i < row; i++) {
			val = val + arr.get(i).get(i);
		}
		for (int i = 0; i < row; i++) {
			val = val - arr.get(i).get(row - 1 - i);
		}
		return Math.abs(val);

	}

}
