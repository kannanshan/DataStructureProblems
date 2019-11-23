package com.hackerrank.hard.problems;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SpellChecker {
	public static String[] spellchecker(String[] wordlist, String[] queries) {
		String[] result = new String[queries.length];
		Map<String, String> map = new HashMap();
		for (String temp : wordlist) {
			map.put(temp, temp);
			map.put(temp.toLowerCase(), temp);
		}
		int i = 0;
		for (String temp : queries) {
			String ans = getValue(temp, map);
			if (ans == null) {
				ans=getValue1(temp, map);
			}
			if(ans==null)
				ans="";
			result[i++]=ans;
		}
		return result;
	}

	private static String getValue1(String temp, Map<String, String> map) {
		String ans = "";
		List<Character> vowelList = new ArrayList();
		vowelList.add('a');
		vowelList.add('e');
		vowelList.add('i');
		vowelList.add('o');
		vowelList.add('u');
		char[] charArray = temp.toCharArray();
		for (int j = 0; j < temp.length(); j++) {
			if (vowelList.contains(temp.charAt(j))) {
				charArray[j] = 'a';
				ans = getValue(new String(charArray), map);
				if (ans != null)
					break;
				charArray[j] = 'e';
				ans = getValue(new String(charArray), map);
				if (ans != null)
					break;
				charArray[j] = 'i';
				ans = getValue(new String(charArray), map);
				if (ans != null)
					break;
				charArray[j] = 'o';
				ans = getValue(new String(charArray), map);
				if (ans != null)
					break;
				charArray[j] = 'u';
				ans = getValue(new String(charArray), map);
				if (ans != null)
					break;
			}
		}
		return ans;
	}

	private static String getValue(String temp, Map<String, String> map) {
		String ans = map.get(temp);
		if (ans == null) {
			ans = map.get(temp.toLowerCase());
		}
		return ans;
	}
	
	public static void main(String args[])
	{
		String[] wordlist = {"KiTe","kite","hare","Hare"};
		String[] queries = {"keto"};
		String[] result = spellchecker(wordlist, queries);
		System.out.println();
	}
}
