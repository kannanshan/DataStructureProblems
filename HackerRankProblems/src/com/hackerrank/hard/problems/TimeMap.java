package com.hackerrank.hard.problems;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class TimeMap {

	Map<String, TreeMap<Integer, String>> map = new HashMap();

	/** Initialize your data structure here. */
	public TimeMap() {

	}

	public void set(String key, String value, int timestamp) {
		TreeMap<Integer, String> tree = map.get(key);
		if (tree == null) {
			tree = new TreeMap();
			map.put(key, tree);
		}
		tree.put(timestamp, value);

	}

	public String get(String key, int timestamp) {
		String result = null;
		TreeMap<Integer, String> tree = map.get(key);
		if (tree != null)
			if (tree.lowerEntry(timestamp + 1) != null) {
				result = tree.lowerEntry(timestamp + 1).getValue();
			} else {
				result = "";
			}
		return result;
	}

	public static void main(String args[]) {
		// ["foo","bar",1],["foo",1],["foo",3],["foo","bar2",4],["foo",4],["foo",5]
		// [[],["love","high",10],["love","low",20],["love",5],["love",10],["love",15],["love",20],["love",25]]
		TimeMap tm = new TimeMap();
		tm.set("love", "hig", 10);
		tm.set("love", "low", 20);
		System.out.println(tm.get("love", 5));
		System.out.println(tm.get("love", 10));
		tm.set("foo", "bar2", 4);
		System.out.println(tm.get("love", 15));
		System.out.println(tm.get("love", 20));
		System.out.println(tm.get("love", 25));
	}
}
