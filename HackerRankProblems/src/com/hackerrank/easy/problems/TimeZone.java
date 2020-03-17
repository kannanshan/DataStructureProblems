package com.hackerrank.easy.problems;

public class TimeZone {

	static String timeConversion(String s) {
		String val = s.substring(8);
		String[] array = s.split(":");
		int hours = Integer.parseInt(array[0]);
		if (val.equalsIgnoreCase("PM")) {
			if (hours == 12) {
				hours = 12;
			} else {
				hours = hours + 12;
			}
		}
		if (val.equalsIgnoreCase("AM")) {
			if (hours == 12) {
				hours = 0;
			}
		}
		if (hours < 10) {
			array[0] = "0" + String.valueOf(hours);
		} else {
			array[0] = String.valueOf(hours);
		}
		String ans=null;
		for (String temp : array) {
			if(ans==null){
			ans = temp;
			}
			else
			{
				ans = ans + ":"+temp;
			}
		}
		return ans.substring(0, 8);

	}

	public static void main(String args[]) {
		System.out.println(timeConversion("01:23:23PM"));
	}

}
