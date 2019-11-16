package com.hackerrank.problems;

import java.util.ArrayList;
import java.util.List;

public class Swap {

	static String balancedSums(List<Integer> arr) {
		int[] temp1 = new int[arr.size()];
		int[] temp2 = new int[arr.size()];
		int val = 0;
		for (int i = 0; i < arr.size(); i++) {
			val = val + arr.get(i);
			temp1[i]=val;
		}
		val = 0;
		for (int i = arr.size()-1; i >= 0; i--) {
			val = val + arr.get(i);
			temp2[i]=val;
		}
		for (int i = 0; i < arr.size(); i++) {
			if (temp1[i] == temp2[i])
				return "YES";
		}
		return "NO";
	}
	
	public static void main(String args[])
	{
		List<Integer> arr =new ArrayList();
		arr.add(1);
		arr.add(2);
		arr.add(3);
		System.out.println(balancedSums(arr));
	}

}
