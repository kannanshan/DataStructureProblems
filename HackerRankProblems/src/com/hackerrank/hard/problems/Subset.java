package com.hackerrank.hard.problems;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Subset {

	public List<List<Integer>> subsets(int[] nums) {
		List<List<Integer>> resultList = new ArrayList();
		check(nums, 0, resultList, new ArrayList());
		return resultList;
	}

	private void check(int[] nums, int k, List<List<Integer>> resultList, List<Integer> tempList) {
		resultList.add(new ArrayList(tempList));
		if(k>=nums.length)
			return;
		for (int i = k; i < nums.length; i++) {
			if(tempList.size()<=k)
				tempList.add(nums[i]);
			else
				tempList.set(k, nums[i]);
			check(nums, i+1, resultList, new ArrayList(tempList));
		}
	}
	
	public static void main(String args[])
	{
		int[] nums={1,2,3,4};
		//Arrays.sort(nums);
		Subset s = new Subset();
		System.out.println(s.subsets(nums));
		//[[],[3],[2],[2,3],[4],[3,4],[2,4],[2,3,4],[1],[1,3],[1,2],[1,2,3],[1,4],[1,3,4],[1,2,4],[1,2,3,4]]
	}

}
