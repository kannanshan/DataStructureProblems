package com.hackerrank.medium.problems;

import java.util.List;

public class CoinChange {
	
	static int count(int S[], int m, int n ) 
    { 


        if (n == 0) 
            return 1; 

        if (n < 0) 
            return 0;  
        if (m <=0 && n >= 1) 
            return 0; 
        return count( S, m - 1, n ) + 
               count( S, m, n-S[m-1] ); 
    } 
	
	public static long getWays(int n, List<Long> c) {
		int[] temp = new int[c.size()];
		for(int i=0;i<c.size();i++)
		{
			temp[i]=(int)((long)c.get(i));
		}
		return count(temp, n, c.size());
	}

}
