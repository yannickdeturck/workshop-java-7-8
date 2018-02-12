package be.ordina.workshop.java8.exercises;

import be.ordina.workshop.java8.exercises.tweeter.model.Tweet;
import be.ordina.workshop.java8.exercises.tweeter.service.TweetService;
import be.ordina.workshop.java8.exercises.tweeter.util.TweetNotFoundException;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

/**
 * More advanced exercises based on Lambdas, Streams and the TweetService.
 *
 * @author Yannick De Turck
 */
public class Exercise2 {
    private static TweetService tweetService = TweetService.getInstance();

    // TODO Implement this method using streams and the tweetService to return a unique List of tweeters.
    public static List<String> getTweeters() {
        return new ArrayList<>();
    }

    // TODO Implement this method using streams and the tweetService to return the tweet count for the given username
    public static Integer getTweetCount(String username) {
        return 0;
    }

    // TODO Implement this method using streams and the tweetService to return a Map containing the
    // tweet count for each username
    public static Map<String, Integer> listUsersWithTweetCount() {
        return new HashMap<>();
    }

    // TODO Implement this method using streams and the tweetService to lookup the Tweet with the highest amount of retweets
    // for a given username.
    public static Optional<Tweet> getTopTweet(String username) {
        return null;
    }

    // TODO Implement this method using streams and the tweetService to return a sorted list based on the given (lambda) comparator
    public static List<Tweet> getSortedTweets(Comparator<Tweet> comparator) {
        return new ArrayList<>();
    }

    // TODO Implement this method using the tweetService.findTweet which returns an Optional<Tweet>.
    // If a value exists then return the tweet text, otherwise throw a TweetNotFoundException
    public static String getTweetText(Long tweetId) throws TweetNotFoundException {
        return null;
    }
}
