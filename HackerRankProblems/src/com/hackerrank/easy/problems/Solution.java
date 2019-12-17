package com.hackerrank.easy.problems;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution {

	static class SortComparator implements Comparator<ResultWrapper> {
		@Override
		public int compare(ResultWrapper temp1, ResultWrapper temp2) {

			if (temp1.count == temp2.count) {
				return temp1.url.compareTo(temp2.url);
			}
			if (temp1.count < temp2.count) {
				return 1;
			}
			if (temp1.count > temp2.count) {
				return -1;
			}
			return 0;
		}
	}

	static class LogWrapper {
		String url;
		String ip;
		long timeStamp;

		public LogWrapper(String bizUrl, String ip, long timeStamp) {
			this.url = bizUrl;
			this.ip = ip;
			this.timeStamp = timeStamp;
		}
	}

	static class ResultWrapper {
		String url;
		int count;

		public ResultWrapper(String url, int count) {
			this.url = url;
			this.count = count;
		}
		
		public String toString()
		{
			return this.url+":"+this.count;
		}
	}

	static List<LogWrapper> inputList = new ArrayList();

	public static List<ResultWrapper> getTopBiz(int k) {
		Map<String, ResultWrapper> tempMap = new HashMap();
		for (LogWrapper logWrapper : inputList) {
			ResultWrapper resultWrapper = tempMap.get(logWrapper.url);
			if (resultWrapper == null) {
				resultWrapper = new ResultWrapper(logWrapper.url, 0);
				tempMap.put(logWrapper.url, resultWrapper);
			}
			resultWrapper.count++;
		}
		List<ResultWrapper> resultList = new ArrayList();
		for (String key : tempMap.keySet()) {
			resultList.add(tempMap.get(key));
		}
		Collections.sort(resultList, new SortComparator());
		return resultList;
	}

	public static void main(String[] args) {
		// you can write to stdout for debugging purposes, e.g.
		System.out.println("This is a debug message");
		LogWrapper temp = new LogWrapper("www.yelp.com/sammys","19.123.43.21",1543245201);
		inputList.add(temp);
		temp = new LogWrapper("www.yelp.fr/chezlulu","19.123.43.21",1543245201);
		inputList.add(temp);
		temp = new LogWrapper("www.yelp.it/damario","19.123.43.21",1543245201);
		inputList.add(temp);
		temp = new LogWrapper("www.yelp.it/damario","19.123.43.21",1543245201);
		inputList.add(temp);
		temp = new LogWrapper("www.yelp.com/sammys","19.123.43.21",1543245201);
		inputList.add(temp);
		temp = new LogWrapper("www.yelp.com/sammys","19.123.43.21",1543245201);
		inputList.add(temp);
		temp = new LogWrapper("www.yelp.de/alexs","19.123.43.21",1543245201);
		inputList.add(temp);
		List<ResultWrapper> tempList = getTopBiz(3);
		System.out.println(tempList);
	}
}
