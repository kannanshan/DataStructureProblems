package com.hackerrank.problems;

public class Sum {
	
	static long aVeryBigSum(long[] ar) {
		long ans = 0;
		for(long l : ar)
		{
			ans=ans+l;
		}
		return ans;

    }

}
