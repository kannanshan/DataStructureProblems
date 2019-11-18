package com.hackerrank.medium.problems;

import java.text.DecimalFormat;

public class Sum {

	static void plusMinus(int[] arr) {
		double pos = 0;
		double neg = 0;
		double zero = 0;
		for (int in : arr) {
			if (in > 0)
				pos++;
			if (in < 0)
				neg++;
			if (in == 0)
				zero++;
		}
		DecimalFormat numberFormat = new DecimalFormat("#.000000");
		double val = pos / new Double(arr.length);
		System.out.println(numberFormat.format(val));
		val = neg / new Double(arr.length);
		System.out.println(numberFormat.format(val));
		val = zero / new Double(arr.length);
		System.out.println(numberFormat.format(val));

	}

	public static void main(String args[]) {
		int[] arr = { -4, 3, -9, 0, 4, 1 };
		plusMinus(arr);
	}

}
