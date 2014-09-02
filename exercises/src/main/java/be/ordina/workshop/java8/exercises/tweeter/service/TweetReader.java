package be.ordina.workshop.java8.exercises.tweeter.service;

import be.ordina.workshop.java8.exercises.tweeter.model.Tweet;

import java.util.List;

/**
 * Class which is able to read tweets.
 *
 * @author Ken Coenen
 */
public abstract class TweetReader {
	/**
	 * @return Retrieve the list of tweets.
	 */
	abstract List<Tweet> read();
}
