package com.hackerrank.medium.problems;

public class Customer {
	public static int maxSatisfied(int[] customers, int[] grumpy, int X) {
		int max = 0;
		int[] sum = new int[customers.length];
		int[] left = new int[customers.length];
		int[] right = new int[customers.length];
		sum[0] = customers[0];
		for (int i = 1; i < customers.length; i++) {
			sum[i] = sum[i - 1] + customers[i];
		}
		for (int i = 0; i < customers.length; i++) {
			int temp = (grumpy[i] == 0) ? customers[i] : 0;
			left[i] = (i - 1 >= 0) ? left[i - 1] + temp : temp;
		}
		for (int i = customers.length - 1; i >= 0; i--) {
			int temp = (grumpy[i] == 0) ? customers[i] : 0;
			right[i] = (i + 1 < customers.length) ? right[i + 1] + temp : temp;
		}
		for (int i = 0; i + X <= customers.length; i++) {
			int leftval = (i - 1 >= 0) ? left[i - 1] : 0;
			int val = sum[i + X - 1] - ((i - 1 >= 0) ? sum[i - 1] : 0);
			int rightVal = (((i + X) < customers.length) ? right[i + X] : 0);
			max = Math.max(max, val + leftval + rightVal);
		}
		return max;

	}

	public static void main(String args[]) {
		int[] customers = { 1, 0, 1, 2, 1, 1, 7, 5 };
		int[] grumpy = { 0, 1, 0, 1, 0, 1, 0, 1 };
		System.out.println(maxSatisfied(customers, grumpy, 3));
	}

}
