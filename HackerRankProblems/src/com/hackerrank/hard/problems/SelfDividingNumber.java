package com.hackerrank.hard.problems;

import java.util.ArrayList;
import java.util.List;

public class SelfDividingNumber {

	public static boolean checkNumber(int n) {
		int quo = n;
		int rem = n;
		while (quo > 0) {
			rem = quo % 10;
			quo = quo / 10;
			if ( rem == 0 || n % rem != 0)
				return false;
		}
		return true;
	}

	public static List<Integer> selfDividingNumbers(int left, int right) {
		List<Integer> result = new ArrayList();
		for (int i = left; i <= right; i++) {
			if (checkNumber(i))
				result.add(i);
		}
		return result;
	}

	public static void main(String args[]) {
		System.out.println(selfDividingNumbers(1, 22));
		//System.out.println(checkNumber(1));
	}

}
