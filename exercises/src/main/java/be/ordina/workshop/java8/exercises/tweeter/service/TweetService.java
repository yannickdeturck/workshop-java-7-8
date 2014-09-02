package be.ordina.workshop.java8.exercises.tweeter.service;

import be.ordina.workshop.java8.exercises.tweeter.model.Tweet;

import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;
import java.util.stream.Collectors;

/**
 * @author Yannick De Turck
 */
public class TweetService {
	private static TweetService INSTANCE;

	private static TweetReader reader = new TweetCacheReader();

	private static List<Tweet> tweetCache;

	protected TweetService() {
	}

	public static TweetService getInstance() {
		if (INSTANCE == null) {
			INSTANCE = new TweetService();
			tweetCache = reader.read();
		}
		return INSTANCE;
	}

	public List<Tweet> findTweets() {
		return tweetCache;
	}

	public List<Tweet> findTweets(Predicate<Tweet> predicate) {
		return tweetCache.stream()
		  .filter(predicate)
		  .collect(Collectors.toList());
	}

	public Optional<Tweet> findTweet(Long tweetId) {
		Optional<Tweet> result;
		if (tweetId == null) {
			result = Optional.empty();
		} else {
			result = tweetCache.stream()
			  .filter(t -> tweetId.equals(t.getTweetId()))
			  .findAny();
		}
		return result;
	}
}
