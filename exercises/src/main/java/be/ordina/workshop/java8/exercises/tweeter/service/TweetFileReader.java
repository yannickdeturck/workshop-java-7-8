package be.ordina.workshop.java8.exercises.tweeter.service;

import be.ordina.workshop.java8.exercises.tweeter.model.Tweet;

import java.io.*;
import java.net.URISyntaxException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Ken Coenen
 */
public class TweetFileReader extends TweetReader {
	/**
	 * {@inheritDoc}
	 */
	@Override
	List<Tweet> read() {
		String line;
		String csvSplitBy = ";";
		List<Tweet> tweetCache = new ArrayList<>();

		// TODO Change this try-block so that it uses the try-with-resources and the multicatch exceptions.
        try (BufferedReader br = new BufferedReader(new FileReader(new File(TweetFileReader.class.getResource("/tweets.csv").toURI())))){
            int id = 0;
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");
            while ((line = br.readLine()) != null) {
                // use comma as separator
                String[] tweet = line.split(csvSplitBy);
                tweetCache.add(new Tweet((long) ++id, tweet[0], tweet[1], tweet[2], LocalDateTime.parse(tweet[3], formatter), Integer.valueOf(tweet[4]), Integer.valueOf(tweet[5])));
            }
        } catch (IOException | URISyntaxException e) {
            e.printStackTrace();
        }
        return tweetCache;
    }

	public static void main(String[] args) {
        TweetReader reader = new TweetFileReader();
        reader.read().stream()
                .forEach(System.out::println);
	}
}
