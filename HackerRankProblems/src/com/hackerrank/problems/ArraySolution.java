package com.hackerrank.problems;

import java.util.Arrays;
import java.util.Iterator;
import java.util.SortedSet;
import java.util.TreeSet;

class ArraySolution {
    public int solution(int[] A) {
    	 SortedSet<Integer> s = new TreeSet();
        
        for(int i=0;i<A.length;i++)
        	s.add(A[i]);
        Iterator<Integer> i = s.iterator();
        int j=1;
        while(i.hasNext())
        {
        	Integer in =i.next();
        	if(j!=in)
        		return j;
        	j++;
        }
        return A.length+1;
    }
}