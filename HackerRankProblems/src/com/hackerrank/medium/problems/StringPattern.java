package com.hackerrank.medium.problems;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class StringPattern {

	static String isValid(String s) {
		Map<Character, Integer> map = new HashMap();
		Set<Integer> set = new HashSet();
		for (int i = 0; i < s.length(); i++) {
			Integer in = map.get(s.charAt(i));
			if (in == null)
				in = 0;
			map.put(s.charAt(i), ++in);
		}
		boolean flag=false;
		int val=0;
		for (Character ch : map.keySet()) {
			if(set.contains(map.get(ch))){
				if(!flag)
					flag=true;
				else
					if(val==0)
						val=map.get(ch);
					if(val!=map.get(ch))
					return "NO";
			}
			set.add(map.get(ch));
		}
		if (set.size() == 1)
			return "YES";
		if (set.size() == 2) {
			Iterator<Integer> it = set.iterator();
			int temp1 = it.next();
			int temp2 = it.next();
			if (Math.abs(temp1 - temp2) == 1)
				return "YES";

		}
		return "NO";

	}
	
	public static void main(String args[])
	{
		System.out.println(isValid("abcdefghhgfedecba"));
	}

}
