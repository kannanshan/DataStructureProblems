package com.hackerrank.medium.problems;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Pairs {
	static int pairs(int k, int[] arr) {
		int val = 0;
		Arrays.sort(arr);
		Set<Integer> set = new HashSet<>();
		for (int i = 0; i < arr.length; i++) {
			set.add(arr[i]);
		}

		for (int i = 0; i < arr.length; i++) {
			if (set.contains(arr[i] + k)) {
				val++;
			}
		}

		return val;

	}

	public static void main(String args[]) {
		int[] arr = { 1, 3, 4, 2 };
		System.out.println(pairs(1, arr));
	}
}
