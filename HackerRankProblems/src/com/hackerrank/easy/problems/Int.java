package com.hackerrank.easy.problems;

import java.math.BigInteger;
import java.util.Arrays;

public class Int {
	
	static void miniMaxSum(int[] arr) {


        int val = 0;
        BigInteger valB=BigInteger.ZERO;
        for (int in : arr) {
        	valB = valB.add(BigInteger.valueOf(in));
        }
        Arrays.sort(arr);
        
        System.out.println((valB.subtract(BigInteger.valueOf(arr[arr.length-1]))) + " " + (valB.subtract(BigInteger.valueOf(arr[0]))));
    
    }
	
	public static void main(String args[])
	{
		
int[] arr = {396285104,573261094,759641832,819230764,364801279};
miniMaxSum(arr);
	}

}
