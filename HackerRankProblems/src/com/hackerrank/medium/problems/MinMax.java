package com.hackerrank.medium.problems;

import java.util.Arrays;

public class MinMax {

	static void miniMaxSum(int[] arr) {
		int val = 0;
		for (int in : arr) {
			val = val + in;
		}
		Arrays.sort(arr);
		System.out.println((val - arr[arr.length]) + " " + (val - arr[0]));
	}

}
