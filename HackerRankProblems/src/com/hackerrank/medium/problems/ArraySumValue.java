package com.hackerrank.medium.problems;

import java.util.ArrayList;
import java.util.List;

public class ArraySumValue {

	public static void checkSum(int count, int pos, int sum, List<Integer> currentList,
			List<List<Integer>> resultList) {
		if (sum == 0 && count==0) {
			resultList.add(new ArrayList(currentList));
			return;
		}
		if (sum > 0 && count != 0) {
			for (int i = pos; i <= 9; i++) {
				currentList.add(i);
				checkSum(count - 1,  i+1, sum - i, currentList, resultList);
				currentList.remove(currentList.size() - 1);
			}
		}
	}

	public static void main(String args[]) {
		List<List<Integer>> resultList = new ArrayList();
		checkSum(3, 1, 7, new ArrayList(), resultList);
		System.out.println(resultList);
	}

}
