package org.example.dsa;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.PriorityQueue;
import java.util.Set;

public class Twitter {
	private static int tweetCount = 0;
	private Map<Integer, Set<Integer>> followerMap;
	private Map<Integer, PriorityQueue<TweetData>> tweetsMap;

	public static class TweetData {
		int timestamp;
		int tweetId;

		public TweetData(int tweetId) {
			this.timestamp = tweetCount++;
			this.tweetId = tweetId;
		}
	}

	public Twitter() {
		this.followerMap = new HashMap<>();
		this.tweetsMap = new HashMap<>();
	}

	public void postTweet(int userId, int tweetId) {
		PriorityQueue<TweetData> tweetsForUser = this.tweetsMap.getOrDefault(userId,
				new PriorityQueue<>((a, b) -> Integer.compare(a.timestamp, b.timestamp)));

		tweetsForUser.offer(new TweetData(tweetId));
		if (tweetsForUser.size() > 10) tweetsForUser.poll();
		this.tweetsMap.put(userId, tweetsForUser);
	}

	public List<Integer> getNewsFeed(int userId) {
		Set<Integer> followers = this.followerMap.getOrDefault(userId, new HashSet<>());
		followers.add(userId);

		PriorityQueue<TweetData> topTweets = new PriorityQueue<>((a, b) -> Integer.compare(b.timestamp, a.timestamp));
		for (int follower : followers) {
			PriorityQueue<TweetData> tweetsForUser = this.tweetsMap.get(follower);
			if (Objects.isNull(tweetsForUser) || tweetsForUser.isEmpty()) continue;

			for (TweetData tweetData : tweetsForUser) {
				topTweets.offer(tweetData);

				if (topTweets.size() > 10) topTweets.poll();
			}
		}
		List<Integer> result = new ArrayList<>();
		while (!topTweets.isEmpty()) {
			result.add(topTweets.poll().tweetId);
		}
		return result.reversed();
	}

	public void follow(int followerId, int followeeId) {
		Set<Integer> followers = this.followerMap.getOrDefault(followerId, new HashSet<>());
		if (followers.contains(followeeId)) return;

		followers.add(followeeId);
		this.followerMap.put(followerId, followers);
	}

	public void unfollow(int followerId, int followeeId) {
		Set<Integer> followers = this.followerMap.getOrDefault(followerId, new HashSet<>());
		if (followers.isEmpty() || !followers.contains(followeeId)) return;

		followers.remove(followeeId);
		this.followerMap.put(followerId, followers);
 	}
}

