package com.hackerrank.medium.problems;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class StringBeauty {

	public static void recursive(String input, int pos, String current, List<String> resultList) {
		Map<String, String> inputMap = new HashMap();
		inputMap.put("1", "a");
		inputMap.put("2", "b");
		inputMap.put("11", "k");
		inputMap.put("21", "i");
		if (pos >= input.length())
			resultList.add(current);
		else {
			recursive(input, pos + 1, current + inputMap.get(input.substring(pos, pos + 1)), resultList);
			if (pos + 2 <= input.length()) {
				recursive(input, pos + 2, current + inputMap.get(input.substring(pos, pos + 2)), resultList);
			}
		}
	}

	public static void main(String args[]) {
		List<String> result = new ArrayList();
		recursive("121", 0, "", result);
		System.out.println(result);
	}

}
