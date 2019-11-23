package com.hackerrank.hard.problems;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class ArrayProblem {

	public static int lastStoneWeight(int[] stones) {
		int result = 0;
		List<Integer> list = new ArrayList();
		for (int in : stones) {
			list.add(in);
		}
		while (list.size() > 1) {
			Collections.sort(list);
			int size = list.size();
			int rock1 = list.remove(size - 1);
			int rock2 = list.remove(size - 2);
			int temp = Math.abs(rock1 - rock2);
			if (temp != 0) {
				list.add(temp);
			}
		}
		result = list.size() == 1 ? list.get(0) : 0;
		return result;
	}

	public static int lastStoneWeight11(int[] stones) {
		int sum = 0;
		for (int s : stones)
			sum += s;
		int n = stones.length;
		boolean[][] dp = new boolean[n][sum + 1];
		dp[0][stones[0]] = true;
		for (int i = 1; i < n; i++) {
			for (int j = 0; j <= sum; j++) {
				if (dp[i - 1][j]) {
					dp[i][j + stones[i]] = true;
					dp[i][Math.abs(j - stones[i])] = true;
				}
			}
		}

		for (int i = 0; i <= sum; i++) {
			if (dp[n - 1][i])
				return i;
		}
		return sum;
	}

	public static void main(String args[]) {
		int[] arr = { 31, 26, 33, 21, 40 };
		System.out.println(lastStoneWeight11(arr));
	}

}
