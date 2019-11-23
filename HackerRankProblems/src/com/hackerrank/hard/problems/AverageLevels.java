package com.hackerrank.hard.problems;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AverageLevels {

	public static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}

	public static List<Double> averageOfLevels(TreeNode root) {
		List<Double> result = new ArrayList();
		Map<Integer, List<BigDecimal>> map = new HashMap();
		getValue(root, 1, map);
		int size = map.keySet().size();
		for (int i = 1; i <= size; i++) {
			List<BigDecimal> temp = map.get(i);
			double s = (temp.get(0).divide(temp.get(1),2,RoundingMode.HALF_UP)).doubleValue();
			result.add(s);
		}
		return result;

	}

	public static void getValue(TreeNode node, int level, Map<Integer, List<BigDecimal>> map) {
		if (node == null)
			return;
		List<BigDecimal> tempList = map.get(level);
		if (tempList == null) {
			tempList = new ArrayList();
			tempList.add(0,BigDecimal.ZERO);
			tempList.add(1,BigDecimal.ZERO);
			map.put(level, tempList);
		}
		tempList.set(0, tempList.get(0).add(BigDecimal.valueOf(node.val)));
		tempList.set(1, tempList.get(1).add(BigDecimal.ONE));
		getValue(node.left, level + 1, map);
		getValue(node.right, level + 1, map);

	}

	public static void main(String args[]) {
		//[2147483647,2147483647,2147483647]
		TreeNode n = new TreeNode(2147483647);
		TreeNode n1 = new TreeNode(2147483647);
		TreeNode n2 = new TreeNode(2147483647);
		n.left = n1;
		n.right = n2;
		System.out.println(averageOfLevels(n));
	}

}
