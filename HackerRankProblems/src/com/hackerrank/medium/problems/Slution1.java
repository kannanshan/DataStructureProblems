package com.hackerrank.medium.problems;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Slution1 {

	static class CustomerData implements Comparable {
		int startTime;
		int endTime;
		int id;

		public CustomerData(int startTime, int endTime) {
			this.startTime = startTime;
			this.endTime = endTime;
		}

		@Override
		public int compareTo(Object o) {
			CustomerData cust = (CustomerData) o;
			return Integer.compare(this.startTime, cust.startTime);
		}

	}

	public static List<List<Integer>> employeeWithLesserThanKBreaks(List<List<Integer>> employeeCalls, int k) {
		List<List<Integer>> result = new ArrayList();

		Map<Integer, List<CustomerData>> map = new HashMap();
		for (int i = 0; i < employeeCalls.size(); i++) {
			List<CustomerData> tempList = map.get(employeeCalls.get(i).get(0));
			if (tempList == null)
				tempList = new ArrayList();
			tempList.add(new CustomerData(employeeCalls.get(i).get(1), employeeCalls.get(i).get(2)));
			map.put(employeeCalls.get(i).get(0), tempList);
		}
		for (Integer in : map.keySet()) {
			List<CustomerData> tempList = map.get(in);
			Collections.sort(tempList);
			int breakVal = 0;
			for (int i = 1; i < tempList.size(); i++) {
				if (tempList.get(i - 1).endTime < tempList.get(i).startTime)
					breakVal++;
			}
			if (breakVal < k) {
				List<Integer> temp = new ArrayList();
				temp.add(in);
				temp.add(breakVal);
				result.add(temp);
			}
		}
		return result;

	}
	
	public static void main(String args[])
	{
		
		List<List<Integer>> list1 = new ArrayList();
		List<Integer> temp = new ArrayList();
		temp = new ArrayList();
		temp.add(3);
		temp.add(1481122000);
		temp.add(1481122020);
		list1.add(temp);
		
		
		temp = new ArrayList();
		temp.add(3);
		temp.add(1481122040);
		temp.add(1481122060);
		list1.add(temp);
		temp = new ArrayList();
		temp.add(3);
		temp.add(1481122070);
		temp.add(1481122090);
		list1.add(temp);
		employeeWithLesserThanKBreaks(list1, 3);
	}

}
