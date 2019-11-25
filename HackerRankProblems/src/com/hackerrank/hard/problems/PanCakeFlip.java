package com.hackerrank.hard.problems;

import java.util.ArrayList;
import java.util.List;

public class PanCakeFlip {

	public static List<Integer> pancakeSort(int[] A) {
		int pos = A.length;
		if (checkSorted(A))
			return new ArrayList();
		List<Integer> result = new ArrayList();
		while (pos > 0) {
			int minimum = getPosition(pos, A);
			if (minimum != pos) {
				result.add(minimum+1);
				result.add(pos);
			}
			pos--;
		}
		result.add(A.length);
		return result;
	}

	private static int getPosition(int pos, int[] arr) {
		int minPos = Integer.MAX_VALUE;
		int minVal = Integer.MAX_VALUE;
		for (int i = 0; i < pos; i++) {
			if (arr[i] < minVal) {
				minPos = i;
				minVal = arr[i];
			}
		}
		return minPos;
	}

	private static boolean checkSorted(int[] arr) {
		for (int i = 1; i < arr.length; i++) {
			if (arr[i - 1] > arr[i])
				return false;
		}
		return true;
	}

	public static void main(String args[]) {
		int[] arr = { 3,1,2 };
		System.out.println(pancakeSort(arr));
	}

}
