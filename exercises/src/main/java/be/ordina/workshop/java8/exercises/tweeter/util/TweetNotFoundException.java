package be.ordina.workshop.java8.exercises.tweeter.util;

/**
 * Exception thrown when a Tweet was not found.
 */
public class TweetNotFoundException extends Exception {
    public TweetNotFoundException(Long tweetId) {
        super(String.format("Tweet with ID %d was not found.", tweetId));
    }
}
