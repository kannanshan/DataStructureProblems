package com.hackerrank.hard.problems;

public class KSimilarities {
	public int kSimilarity(String A, String B) {
		int result = 0;
		for(int i=0;i<A.length();i++)
		{
			if(A.charAt(i)!=B.charAt(i))
				result++;
		}
		if(result/2==0)
			result=result/2;
		else
			result=(result+1)/2;
		return result;
	}
}
