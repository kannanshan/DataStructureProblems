package com.hackerrank.hard.problems;

import java.util.Arrays;

public class Citation {

	public static int hIndex(int[] citations) {
		int result = 0;
		Arrays.sort(citations);
		for (int i = 0; i < citations.length; i++) {
			if (citations[i] == (citations.length - i))
				return citations[i];
		}
		return result;

	}

}
