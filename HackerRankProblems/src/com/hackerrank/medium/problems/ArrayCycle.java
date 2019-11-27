package com.hackerrank.medium.problems;

public class ArrayCycle {

	public static int arrayNesting(int[] nums) {
		int max = 0;
		int currentVal = 0;
		int pos = 0;
		int temp = 0;
		for (int i = 0; i < nums.length; i++) {
			currentVal = 0;
			pos=i;
			if (pos != nums[pos]) {
				while (pos < nums.length && nums[pos] >= 0) {
					temp = nums[pos];
					if (nums[pos] == 0)
						nums[pos] = nums.length;
					else
						nums[pos] = -nums[pos];
					pos = temp;
					currentVal++;
				}
			} else {
				pos = i + 1;
				currentVal = 1;
			}
			max = Math.max(max, currentVal);
		}
		return max;
	}

	public static void main(String args[]) {
		int[] A = {1,0,3,4,2};
		System.out.println(arrayNesting(A));
	}

}
