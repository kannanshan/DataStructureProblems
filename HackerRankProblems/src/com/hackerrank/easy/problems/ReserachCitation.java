package com.hackerrank.easy.problems;

import java.util.Arrays;

public class ReserachCitation {

	public static int hIndex(int[] citations) {
		
		char ch = 23422;
		int result = 0;
		Arrays.sort(citations);
		if(citations.length==1)
		{
			if(citations[0]!=0)
				return citations[0];
			else
				return 0;
		}
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
