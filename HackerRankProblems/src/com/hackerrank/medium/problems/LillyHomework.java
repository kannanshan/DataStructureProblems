package com.hackerrank.medium.problems;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class LillyHomework {

	static int lilysHomework(int[] arr) {
		int val = 0;
		int[] pos1 = new int[arr.length];
		Map<Integer, Integer> map = new HashMap();
		int i = 0;
		int[] tempA=Arrays.copyOf(arr, arr.length);
		Arrays.sort(arr);
		for (int in : arr) {
			map.put(in, i);
			i++;
		}
		i = 0;
		for (int in : tempA) {
			pos1[i] = map.get(in);
			i++;
		}
		for (int j = 0; j < pos1.length; j++) {
			if (j != pos1[j]) {
				val++;
				int temp = pos1[j];
				pos1[j] = pos1[temp];
				pos1[temp] = temp;
			}
		}
		return val;
	}

	public static void main(String args[]) {
		int[] arr = { 3,4,2,5,1};
		System.out.println(lilysHomework(arr));
	}

}
