package com.hackerrank.problems;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Test {

	static class wrapperReview implements Comparable<wrapperReview> {

		int score;
		int id;

		wrapperReview(int id, int score) {
			this.id = id;
			this.score = score;
		}

		@Override
		public int compareTo(wrapperReview o) {
			wrapperReview review = (wrapperReview) o;
			return Integer.compare(review.score,this.score );
		}

	}

	public static List<Integer> awardTopKHotels(String positiveKeywords, String negativeKeywords,
			List<Integer> hotelIds, List<String> reviews, int k) {
		Set pos = new HashSet();
		Set neg = new HashSet();
		String[] posArray = positiveKeywords.split(" ");
		for (int i = 0; i < posArray.length; i++) {
			pos.add(posArray[i]);
		}
		String[] negArray = negativeKeywords.split(" ");
		for (int i = 0; i < negArray.length; i++) {
			neg.add(negArray[i]);
		}
		List<Integer> result = new ArrayList();
		Map<Integer, String> map = new HashMap();
		for (int i = 0; i < hotelIds.size(); i++) {
			String review = map.get(hotelIds.get(i));
			if (review == null) {
				review = "";
			}
			review = review + " " + reviews.get(i);
			map.put(hotelIds.get(i), review);
		}
		Map<Integer, Map<String, Integer>> tempMap = new HashMap();
		for (Integer in : map.keySet()) {
			String review = map.get(in);
			String[] reviewArray = review.split(" ");
			Map<String, Integer> tempmap = new HashMap();
			for (int i = 0; i < reviewArray.length; i++) {
				Integer count = tempmap.get(reviewArray[i]);
				if (count == null)
					count = 0;
				count = count + 1;
				tempmap.put(reviewArray[i], count);
			}
			tempMap.put(in, tempmap);
		}
		Set keySet = tempMap.keySet();
		int value = 0;
		List<wrapperReview> tempList = new ArrayList();
		for (Integer in : tempMap.keySet()) {
			Map<String, Integer> tem = tempMap.get(in);
			for (String word : tem.keySet()) {
				if (pos.contains(word)) {
					value = value + tem.get(word) * 3;
				}
				if (neg.contains(word)) {
					value = value + tem.get(word) * (-1);
				}
			}
			tempList.add(new wrapperReview(in, value));
		}
		Collections.sort(tempList);
		for (int i = 0; i < tempList.size(); i++) {

			result.add(tempList.get(i).id);
			if (i > k)
				break;
		}
		return result;

	}
	
	public static void main(String args[])
	{
		
	}
}
