package com.hackerrank.easy.problems;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution {

	Map<String, String[]> data;

	public Solution(Map<String, String[]> data) {
		this.data = data;
	}

	public boolean hasMutualFirstChoice(String username) {
		return hasMutualPairForRank(username, 0);
	}

	public boolean hasMutualPairForRank(String username, int rank) {
		String swapUserName = (data.get(username) != null && data.get(username).length  >rank  ) ? data.get(username)[rank]
				: null;
		String otherUserName = (data.get(swapUserName) != null && data.get(swapUserName).length > rank)
				? data.get(swapUserName)[rank] : null;
		if (otherUserName != null && swapUserName != null)
			return otherUserName.equalsIgnoreCase(username);
		return false;
	}

	public String[] changedPairings(String username, int rank)
	{
		String[] resultArray = null;
		List<String> resultList = new ArrayList();
		String existingUserName = (data.get(username) != null && data.get(username).length >rank )?data.get(username)[rank]:null;
		String swappedUserName = (data.get(username) != null && data.get(username).length >rank )?data.get(username)[rank-1]:null;
		if(hasMutualPairForRank(existingUserName, rank)) {
			resultList.add(existingUserName);
		}
		String temp = data.get(username)[rank];
		data.get(username)[rank]=data.get(username)[rank-1];
		data.get(username)[rank-1] = temp;
		String[] tempArray = data.get(username);
		List<Integer> tem1p=null;
		if(hasMutualPairForRank(username, rank)) {
			resultList.add(existingUserName);
		}
		resultArray = new String[resultList.size()];
		for (int i = 0; i < resultList.size(); i++) {
			resultArray[i] = resultList.get(i);
		}
		return resultArray;
	}

	public static void main(String args[]) {
		Map<String, String[]> data = new HashMap<String, String[]>();
		data.put("a", new String[] { "c", "d" });
		data.put("b", new String[] { "d", "a", "c" });
		data.put("c", new String[] { "a", "b" });
		data.put("d", new String[] { "c", "a", "b" });
		data.put("e", new String[] {});

		Solution sol = new Solution(data);
		/*System.out.println(sol.hasMutualFirstChoice(null)); // null
		System.out.println(sol.hasMutualFirstChoice("r"));
		System.out.println(sol.hasMutualFirstChoice("a"));
		System.out.println(sol.hasMutualFirstChoice("b"));
		System.out.println(sol.hasMutualPairForRank("a", 0));
		System.out.println(sol.hasMutualPairForRank("a", 1));
		System.out.println(sol.hasMutualPairForRank("e", 0));*/
		//System.out.println(sol.changedPairings("d", 1));
		//System.out.println(sol.changedPairings("b", 2));
		System.out.println(sol.changedPairings("b", 1));
	}

	// null
	// invalid input. missing usernames
	// bundary cases : only one value exists
	// success case : given test case
	// failed case

}
