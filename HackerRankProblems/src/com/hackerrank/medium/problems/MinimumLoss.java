package com.hackerrank.medium.problems;

import java.util.Arrays;
import java.util.HashMap;

public class MinimumLoss {
	
	static int minimumLoss(long[] prices) {
		HashMap<Long,Integer> indices = new HashMap<>();

        //Populate prices array with the input
        for(int i = 0; i < prices.length; i++){
   
            indices.put(prices[i],i);
        }

        Arrays.sort(prices);//Performs a double pivot quicksort and sorts ascending

        int minimumLoss = Integer.MAX_VALUE;

        //Iterate from end to start
        for(int i = prices.length-1; i >0; i--){
            //Make sure it is a smaller loss
            if(prices[i]-prices[i-1] < minimumLoss){
                //Verify if the pair is a valid transaction
                if(indices.get(prices[i]) < indices.get(prices[i-1]))
                    minimumLoss = (int)(prices[i]-prices[i-1]);
            }
        }
        return (int)minimumLoss;

    }
	
	public static void main(String args[])
	{
		long[] price = {20,15,8,2,12};
		System.out.println(minimumLoss(price));
	}

}
