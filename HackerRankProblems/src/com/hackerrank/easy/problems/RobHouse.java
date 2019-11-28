package com.hackerrank.easy.problems;

public class RobHouse {

	public static int rob(int[] nums) {
		 return rob(nums, nums.length - 1);
	}
	private static int rob(int[] nums, int i) {
	    if (i < 0) {
	        return 0;
	    }
	    return Math.max(rob(nums, i - 2) + nums[i], rob(nums, i - 1));
	}

	public static void main(String args[]) {
		int[] arr = { 2, 4, 6, 2, 5 };
		System.out.println(rob(arr));
	}

}
