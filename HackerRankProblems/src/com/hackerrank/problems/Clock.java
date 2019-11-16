package com.hackerrank.problems;

import java.util.HashMap;
import java.util.Map;

public class Clock {
	static String timeInWords(int h, int m) {
		Map<Integer, String> resultMap = new HashMap();
		String result = "";
		if (m == 0)
			return getValue(h) + " o' clock";
		if (m == 1)
			return "one minute past " + getValue(h);
		if (m == 15)
			return "quarter past " + getValue(h);
		if (m == 30)
			return "half past " + getValue(h);
		if (m == 45)
			return "quarter to " + getValue(h + 1);
		if (m < 30)
			return getValue(m) + " minutes past " + getValue(h);
		if (m > 30)
			return getValue(60 - m) + " minutes to " + getValue(h + 1);
		return result;
	}

	private static String getValue(int n) {
		Map<Integer, String> resultMap = new HashMap();
		resultMap.put(1, "one");
		resultMap.put(2, "two");
		resultMap.put(3, "three");
		resultMap.put(4, "four");
		resultMap.put(5, "five");
		resultMap.put(6, "six");
		resultMap.put(7, "seven");
		resultMap.put(8, "eight");
		resultMap.put(9, "nine");
		resultMap.put(10, "ten");
		resultMap.put(11, "eleven");
		resultMap.put(12, "twelve");
		resultMap.put(13, "thirteen");
		resultMap.put(14, "fourteen");
		resultMap.put(15, "fifteen");
		resultMap.put(16, "sixtene");
		resultMap.put(17, "seventeen");
		resultMap.put(18, "eighteen");
		resultMap.put(19, "nineteen");
		resultMap.put(20, "twenty");
		resultMap.put(30, "thirty");
		resultMap.put(40, "fourty");
		resultMap.put(50, "fifty");
		resultMap.put(60, "sixty");

		String result = "";
		if (n / 10 == 0) {
			return resultMap.get(n);
		} else {
			if (n < 20)
				return resultMap.get(n);
			else
				return resultMap.get((n / 10)*10) + " " + resultMap.get(n % 10);
		}
	}

	public static void main(String args[]) {
		System.out.println(timeInWords(7, 29));
	}
}
