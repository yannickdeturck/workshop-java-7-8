package be.ordina.workshop.java8.exercises.tweeter.service;

import be.ordina.workshop.java8.exercises.tweeter.model.Tweet;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Ken Coenen
 */
public class TweetCacheReader extends TweetReader {
	/**
	 * {@inheritDoc}
	 */
	@Override
	List<Tweet> read() {
		List<Tweet> tweetCache = new ArrayList<>();
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");
		tweetCache.add(new Tweet(1L, "@JeremyClarkson", "Jeremy Clarkson", "Argument with children: who is more famous; Nicki Minaj or Rick Wakeman?", LocalDateTime.parse("26/08/2014 18:06", formatter), 418, 1048));
		tweetCache.add(new Tweet(2L, "@JeremyClarkson", "Jeremy Clarkson", "This is a video of me being ice bucketed. @MrJamesMay @RichardHammond You're next. youtu.be/CU6pB7s7rtg", LocalDateTime.parse("22/08/2014 16:59", formatter), 12466, 12780));
		tweetCache.add(new Tweet(3L, "@verge", "The Verge", "Charlie Shrem will reportedly plead guilty to federal charges related to Bitcoin transactions theverge.com/e/5851860", LocalDateTime.parse("31/08/2014 09:51", formatter), 14, 3));
		tweetCache.add(new Tweet(4L, "@mobilevikingsBE", "Mobile Vikings BE", "The Mobile Vikings team at #nucleuswebkartingtrophy showed with a 5th place we aren't only fast on the water.Yay! *DA pic.twitter.com/QVq2OxKDFY", LocalDateTime.parse("31/08/2014 09:37", formatter), 0, 6));
		tweetCache.add(new Tweet(5L, "@SciencePorn", "SciencePorn", "There were 53 kilobytes of digital memory worldwide in 1953.", LocalDateTime.parse("31/08/2014 05:51", formatter), 889, 873));
		tweetCache.add(new Tweet(6L, "@verge", "The Verge", "The full history of Nintendo's handheld dominance theverge.com/e/5846602 pic.twitter.com/Q62pcydfA3", LocalDateTime.parse("30/08/2014 20:06", formatter), 126, 165));
		tweetCache.add(new Tweet(7L, "@bimmerpost", "BIMMERPOST", "Another M4 Stacked with M Performance Parts Arrives bit.ly/VThEaD", LocalDateTime.parse("29/08/2014 20:32", formatter), 3, 3));
		tweetCache.add(new Tweet(8L, "@Kotaku", "Kotaku", "Nintendo of Europe lays off 320 people: bit.ly/1rEoK1j pic.twitter.com/XbN1N9DWtz", LocalDateTime.parse("29/08/2014 17:38", formatter), 53, 29));
		tweetCache.add(new Tweet(9L, "@Mr_Jean", "Jan De Wilde", "Oculus Rift gestuurde 3D webcam opstelling. #Ordina #ordinabelgium #innovation #oculus instagram.com/p/sPdEjjLwkK/", LocalDateTime.parse("28/08/2014 14:11", formatter), 1, 1));
		tweetCache.add(new Tweet(10L, "@BBC_TopGear", "Top Gear", "The Corvette Stingray will soon come with an 8-speed auto option, but is it any good? TOPGEAR.com/uk/car-news/co… pic.twitter.com/4g3uDSXyXU", LocalDateTime.parse("28/08/2014 22:15", formatter), 187, 310));
		tweetCache.add(new Tweet(11L, "@verge", "The Verge", "Apple's September 9th event is official. iPhone 6 and iWatch expected theverge.com/e/5842842 pic.twitter.com/7xosFMPwhJ", LocalDateTime.parse("28/08/2014 18:14", formatter), 1410, 615));
		return tweetCache;
	}
}
