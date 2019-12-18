package com.hackerrank.medium.problems;

import java.util.HashSet;
import java.util.Set;
import java.util.*;

public class Solutions {
	
	
	
    public static void main(String [] args) {
        String business_name_1 = "";
        String business_name_2 = "";
    
        System.out.println(compute_jaccard_index(business_name_1, business_name_2));
    }

    public static float compute_jaccard_index(String string1, String string2){
    	System.out.println(string2.length());
        if(string1 == null || string2 == null)
            return (float) 0.0;
        float commonWordsCount=0;
        float distinctWordsCount=0;
        float result=0;
        String[] string1Array = string1.split(" ");
        String[] string2Array = string2.split(" ");
        Set<String> tempSet = new HashSet();
        for(String temp : string1Array)
        {
            tempSet.add(temp);
        }
        for(String temp : string2Array)
        {
            if(tempSet.contains(temp))
            {
               commonWordsCount++; 
            }
            tempSet.add(temp);
        }
        distinctWordsCount = tempSet.size();
        result = commonWordsCount/distinctWordsCount;
        return result; 
    }

}
