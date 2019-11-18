package com.hackerrank.medium.problems;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Stranauts {

	static int journeyToMoon(int n, int[][] arr) {
		List<Set> list = new ArrayList();
		Set set = new HashSet();
		set.add(arr[0][0]);
		set.add(arr[0][1]);
		list.add(set);
		for (int i = 1; i < arr.length; i++) {
			for (int j = 0; j < list.size(); j++) {
				if (list.get(j).contains(arr[i][0]) || list.get(j).contains(arr[i][1])) {
					list.get(j).add(arr[i][0]);
					list.get(j).add(arr[i][0]);
					continue;
				}
			}
			set = new HashSet();
			set.add(arr[i][0]);
			set.add(arr[i][1]);
			list.add(set);
		}
		for(int i=0;i<n;i++)
		{
			for (int j = 0; j < list.size(); j++) {
				if(!list.get(j).contains(i))
				{
					set = new HashSet();
					set.add(i);
					list.add(set);
				}
			}
		}
		int val = 0;
		for (int i = 0; i < list.size(); i++) {
			for (int j = i + 1; j < list.size(); j++) {
				val = val + (list.get(i).size() * list.get(j).size());
			}
		}
		return val;
	}
	
	public static void main(String arsg[])
	{
		int[][] arr = {{0, 1},{2, 3},{0,4}};
		System.out.println(journeyToMoon(5, arr));
	}

}
