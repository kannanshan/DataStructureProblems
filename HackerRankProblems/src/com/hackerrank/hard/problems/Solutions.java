package com.hackerrank.hard.problems;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solutions {

	static class User {
	    Integer id;
	    Boolean optedIn;

	    public User(Integer id, Boolean optedIn) {
	        this.id = id;
	        this.optedIn = optedIn;
	    }

	    public Integer getId() {
	        return this.id;
	    }
	    public Boolean getOptedIn() {
	        return this.optedIn;
	    }
	}

	static class OptInChange {
	    Integer userId;
	    String action;

	    public OptInChange(Integer userId, String action) {
	        this.userId = userId;
	        this.action = action;
	    }

	    public Integer getUserId() {
	        return this.userId;
	    }

	    public String getAction() {
	        return this.action;
	    }
	}

	public static List<Integer> findUsersWithOptChange(List<User> currentUserList, List<OptInChange> optInChangeLog) {
		List<Integer> resultList = new ArrayList();
		Map<Integer, User> map = new HashMap();
		for (OptInChange opt : optInChangeLog) {
			User user = map.get(opt.userId);
			if (user == null) {
				user = new User(opt.userId, opt.action.equalsIgnoreCase("opt_out") ? false : true);
				map.put(opt.userId, user);
			}
			user.optedIn = opt.action.equalsIgnoreCase("opt_out") ? false : true;
		}
		User tempUser = null;
		for (User user : currentUserList) {
			tempUser = map.get(user.id);
			if (tempUser != null
					&& ((tempUser.id == user.id) && (Boolean.compare(tempUser.getOptedIn(), user.getOptedIn()) != 0))) {
				resultList.add(user.id);
			}
		}

		for (Integer in : map.keySet()) {
			boolean flag = true;
			for (User user : currentUserList) {
				if (in == user.id)
					flag = false;
			}
			if (flag)
				resultList.add(in);
		}

		Collections.sort(resultList);
		return resultList;
	}
	
	public static void main(String args[])
	{
		List<User> currentUserList = new ArrayList();
		currentUserList.add(new User(1, false));
		currentUserList.add(new User(19, true));
		currentUserList.add(new User(4, true));
		currentUserList.add(new User(54, false));
		
		List<OptInChange> optInChangeLog = new ArrayList();
		optInChangeLog.add(new OptInChange(19, "opt_out"));
		optInChangeLog.add(new OptInChange(1, "opt_in"));
		optInChangeLog.add(new OptInChange(71, "opt_in"));
		optInChangeLog.add(new OptInChange(19, "opt_in"));
		System.out.println(findUsersWithOptChange(currentUserList, optInChangeLog))	 ;
	}

}
