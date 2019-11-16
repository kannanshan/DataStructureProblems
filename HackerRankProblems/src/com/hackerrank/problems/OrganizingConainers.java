package com.hackerrank.problems;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class OrganizingConainers {


	private static int get(int row, int i, int[][] container) {
		int sum = 0;
		for (int j = 0; j < row; j++) {
			if (i != j) {
				sum = sum + container[i][j];
			}
		}
		return sum;
	}

	private static final Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) throws IOException {
		int[][] container ={{0 ,2 ,1},
				{1, 1, 1},
				{2 ,0 ,0}};
		//System.out.println(organizingContainers(container));
	}
}
