package com.hackerrank.problems;

public class Sam {

	static int substrings(String n) {
		long val=0;
		for(int i=0;i<n.length();i++)
		{
			for(int j=i+1;j<=n.length();j++)
			{
				val = val+Long.parseLong(n.substring(i, j));
			}
		}
		return (int)val;
	}
	public static void main(String args[])
	{
		//Long.parseLong("9726984385");
		System.out.println(substrings("972698438521"));
	}

}
