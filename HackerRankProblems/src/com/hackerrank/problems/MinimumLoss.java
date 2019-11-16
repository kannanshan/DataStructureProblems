package com.hackerrank.problems;

public class MinimumLoss {
	
	static int minimumLoss(long[] price) {
		long min=Integer.MAX_VALUE;
		for(int i=0;i<price.length;i++)
		{
			long temp=price[i];
			for(int j=i+1;j<price.length;j++)
			{
				if(temp>price[j])
					min = Math.min(min, temp-price[j]);
			}
		}
		return (int)min;

    }
	
	public static void main(String args[])
	{
		long[] price = {20,15,8,2,12};
		System.out.println(minimumLoss(price));
	}

}
