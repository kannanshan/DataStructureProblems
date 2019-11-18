package com.hackerrank.medium.problems;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class ListToArray {

	public int[] solution(int[] A, int[] B) {
		if(A.length>100000 || B.length>100000)
			return new int[0];
		int number1 = decode(A);
		int number2 = decode(B);
		int number3 = number1 + number2;
		return encode(number3);
	}

	public static int[] encode(int number) {
		List<Integer> result = new ArrayList();
		int rem = 0;
		while (number != 0) {
			rem = number % (-2);
			number = number / (-2);
			if (rem < 0) {
				rem = rem + 2;
				number = number + 1;
			}
			result.add(rem);
		}
		int resultArray[] = new int[result.size()];
		for (int i = 0; i < result.size(); i++) {
			resultArray[i] = result.get(i);
		}
		return resultArray;
	}

	private static int decode(int[] inputArray) {
		int val = 0;
		for (int i = 0; i < inputArray.length; i++) {
			val = val + inputArray[i] * (int) Math.pow(-2, i);
		}
		return val;
	}

	public static void main(String args[]) {
		int[] input = { 1, 0, 0, 1, 1 };
		System.out.println(decode(input));
		System.out.println(encode(-2396));
	}

}
