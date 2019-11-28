package com.hackerrank.medium.problems;

public class ArrayChunk {

	public static int maxChunksToSorted(int[] arr) {
		int max = 0;
		int tempSum = 0;
		for (int i = 0; i < arr.length; i++) {
			tempSum = tempSum + arr[i];
			if (tempSum == (i * (i + 1)) / 2) {
				max++;
			}
		}
		return max;
	}
	
	public static void main(String args[])
	{
		int[] arr={1,0,2,3,4};
		System.out.println(maxChunksToSorted(arr));
	}

}
