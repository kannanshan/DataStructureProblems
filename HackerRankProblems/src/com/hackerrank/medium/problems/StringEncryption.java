package com.hackerrank.medium.problems;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class StringEncryption {

	static class Wrapper implements Comparable<Wrapper> {
		int count;
		String text;
		int position;

		public Wrapper(String i, String j, int position) {
			this.count = Integer.parseInt(i);
			this.text = j;
			this.position = position;
		}

		@Override
		public int compareTo(Wrapper o) {
			return Integer.compare(this.count, o.count);
		}

	}

	static void countSort(List<List<String>> arr) {
		List<Wrapper> wrapper = new ArrayList();
		for (int i = 0; i < arr.size(); i++) {
			wrapper.add(new Wrapper(arr.get(i).get(0), arr.get(i).get(1), i));
		}
		Collections.sort(wrapper);
		for(int i=0;i<wrapper.size();i++)
		{
			Wrapper wrap = wrapper.get(i);
			if(wrap.position<wrapper.size()/2)
			{
				System.out.print("-");
			}
			else
			{
				System.out.print(wrap.text+" ");
				
			}
		}

	}

	public static void main(String args[]) {
		//List<List<String>> arr = Arrays.asList({{"0","ab"}, {"6","cd"}, {"0","ef"}, {"6","gh"}, {"4","ij"}, {"0","ab"}, {"6","cd"}, {"0","ef"}, {"6","gh"}, {"0","ij"}, {"4","that"}, {"3","be"}, {"0","to"}, {"1", "be"}, {"5", "question"}, {"1", "or"}, {"2", "not"}, {"4", "is"}, {"2", "to"}, {"4", "the"}});
		List<List<String>> arr = new ArrayList();
		List temp = new ArrayList();
		temp.add("0");
		temp.add("a");
		arr.add(temp);
		temp = new ArrayList();
		temp.add("4");
		temp.add("d");
		arr.add(temp);
		temp = new ArrayList();
		temp.add("2");
		temp.add("b");
		arr.add(temp);
		temp = new ArrayList();
		temp.add("1");
		temp.add("c");
		arr.add(temp);
		countSort(arr);
	}

}
