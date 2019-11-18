package com.hackerrank.medium.problems;

import java.io.*;
import java.util.*;

public class Solution {

	static class ReservationWrapper implements Comparable {
		int timeStamp;
		int reservationId;

		public ReservationWrapper(int timeStamp, int reservationId) {
			this.timeStamp = timeStamp;
			this.reservationId = reservationId;
		}

		@Override
		public int compareTo(Object o) {
			ReservationWrapper wrapper = (ReservationWrapper) o;
			return Integer.compare(this.timeStamp, wrapper.timeStamp);
		}

		public boolean equals(Object anObject) {
			ReservationWrapper wrapper = (ReservationWrapper) anObject;
			return this.reservationId == wrapper.reservationId;
		}

	}

	private static List<ReservationWrapper> getWrapper(List<List<Integer>> firstReservationList) {
		List<ReservationWrapper> result = new ArrayList();
		for (int i = 0; i < firstReservationList.size(); i++) {
			result.add(new ReservationWrapper(firstReservationList.get(i).get(1), firstReservationList.get(i).get(0)));
		}
		return result;
	}

	public static List<Integer> missingReservations(List<List<Integer>> firstReservationList,
			List<List<Integer>> secondReservationList) {
		List<Integer> result = new ArrayList();
		List<ReservationWrapper> firstList = getWrapper(firstReservationList);
		List<ReservationWrapper> secondList = getWrapper(secondReservationList);
		List<ReservationWrapper> resultList = new ArrayList();
		for (ReservationWrapper res : secondList) {
			if (!firstList.contains(res)) {
				resultList.add(res);
			}
		}
		Collections.sort(resultList);
		for (ReservationWrapper res : resultList) {
			result.add(res.reservationId);
		}
		return result;

	}

	public static void main(String[] args) throws Exception {
		List<List<Integer>> list1 = new ArrayList();
		List<Integer> temp = new ArrayList();
		temp.add(1234);
		temp.add(532632);
		list1.add(temp);
		temp = new ArrayList();
		temp.add(234);
		temp.add(632633);
		list1.add(temp);
		temp = new ArrayList();
		temp.add(2354);
		temp.add(732634);
		list1.add(temp);
		List<List<Integer>> list2 = new ArrayList();
		List<Integer> temp2 = new ArrayList();
		temp2.add(1234);
		temp2.add(532632);
		list2.add(temp2);
		temp2 = new ArrayList();
		temp2.add(234);
		temp2.add(632633);
		list2.add(temp2);
		temp2 = new ArrayList();
		temp2.add(2354);
		temp2.add(732634);
		list2.add(temp2);
		temp2 = new ArrayList();
		temp2.add(458);
		temp2.add(642633);
		list2.add(temp2);

		missingReservations(list1, list2);
	}
}
