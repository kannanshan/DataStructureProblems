package com.hackerrank.easy.problems;

import java.util.Arrays;

public class ReserachCitation {

	public static int hIndex(int[] citations) {
		int result = 0;
		Arrays.sort(citations);

		for (int i = citations.length - 1; i >= 0; i--) {
			result++;
			if (result >= citations[i])
				return citations[i];
		}
		return result;
	}
	
	public static void main(String args[])
	{
		int[] arr = {1,2};
		System.out.println(hIndex(arr));
	}

}
