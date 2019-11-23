package com.hackerrank.hard.problems;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class FizzBuzz {

	static class Message {
		int sender;
		int recipient;
		int conversationId;

		Message(int sender, int recipient, int conversationId) {
			this.sender = sender;
			this.recipient = recipient;
			this.conversationId = conversationId;
		}
	}

	public static int businessResponsivenessRate(int bizOwnerId, List<Message> allMessages) {
		int score = 0;
		int totalCon = 0;
		int wrote = 0;
		Set<Integer> set = new HashSet();
		for (Message mess : allMessages) {
			if ((mess.recipient == bizOwnerId || mess.sender == bizOwnerId) && !set.contains(mess.conversationId)) {
				set.add(mess.conversationId);
				totalCon++;
			}
		}
		set = new HashSet();
		for (Message mess : allMessages) {
			if ((mess.sender == bizOwnerId) && !set.contains(mess.conversationId)) {
				set.add(mess.conversationId);
				wrote++;
			}
		}
		if(totalCon>0 && wrote>0)
			score = (wrote * 100) / totalCon;
		return score;

	}

	public static void main(String args[])
	{
		 List<Message> allMessages = new ArrayList();
		allMessages.add(new Message(1,42,1));
		allMessages.add(new Message(42,1,1));
		allMessages.add(new Message(2,42,2));
		allMessages.add(new Message(88,2,1));
		System.out.println(businessResponsivenessRate(42, allMessages));
	}

}
