package be.ordina.workshop.java8.exercises.tweeter;

import be.ordina.workshop.java8.exercises.Exercise2;
import be.ordina.workshop.java8.exercises.tweeter.model.Tweet;
import be.ordina.workshop.java8.exercises.tweeter.util.TweetNotFoundException;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import java.util.List;
import java.util.Map;

/**
 * @author Yannick De Turck
 */
@RunWith(JUnit4.class)
public class Exercise2Test {
    @Test
    public void testListTweeters() {
        List<String> tweeters = Exercise2.getTweeters();

        Assert.assertEquals(8, tweeters.size());
        Assert.assertTrue(tweeters.contains("@JeremyClarkson"));
        Assert.assertTrue(tweeters.contains("@verge"));
        Assert.assertTrue(tweeters.contains("@mobilevikingsBE"));
        Assert.assertTrue(tweeters.contains("@SciencePorn"));
        Assert.assertTrue(tweeters.contains("@bimmerpost"));
        Assert.assertTrue(tweeters.contains("@Kotaku"));
        Assert.assertTrue(tweeters.contains("@Mr_Jean"));
        Assert.assertTrue(tweeters.contains("@BBC_TopGear"));
    }

    @Test
    public void testGetTweetCount()  {
        Assert.assertEquals(2, Exercise2.getTweetCount("@JeremyClarkson").intValue());
        Assert.assertEquals(3, Exercise2.getTweetCount("@verge").intValue());
        Assert.assertEquals(1, Exercise2.getTweetCount("@Kotaku").intValue());
    }

    @Test
    public void testListUsersWithTweetCount() {
        Map<String,Integer> usersWithTweetCount = Exercise2.listUsersWithTweetCount();
        Assert.assertEquals(2, usersWithTweetCount.get("@JeremyClarkson").intValue());
        Assert.assertEquals(3, usersWithTweetCount.get("@verge").intValue());
        Assert.assertEquals(1, usersWithTweetCount.get("@mobilevikingsBE").intValue());
        Assert.assertEquals(1, usersWithTweetCount.get("@SciencePorn").intValue());
        Assert.assertEquals(1, usersWithTweetCount.get("@bimmerpost").intValue());
        Assert.assertEquals(1, usersWithTweetCount.get("@Kotaku").intValue());
        Assert.assertEquals(1, usersWithTweetCount.get("@Mr_Jean").intValue());
        Assert.assertEquals(1, usersWithTweetCount.get("@BBC_TopGear").intValue());
    }

    @Test
    public void testGetTopTweet() {
        Assert.assertEquals("This is a video of me being ice bucketed. @MrJamesMay @RichardHammond You're next. youtu.be/CU6pB7s7rtg",
                Exercise2.getTopTweet("@JeremyClarkson").get().getText());
        Assert.assertEquals("Apple's September 9th event is official. iPhone 6 and iWatch expected theverge.com/e/5842842 pic.twitter.com/7xosFMPwhJ",
                Exercise2.getTopTweet("@verge").get().getText());
        Assert.assertEquals("Oculus Rift gestuurde 3D webcam opstelling. #Ordina #ordinabelgium #innovation #oculus instagram.com/p/sPdEjjLwkK/",
                Exercise2.getTopTweet("@Mr_Jean").get().getText());
    }

    @Test
    public void testGetSortedTweets() {
        List<Tweet> sortedTweets = Exercise2.getSortedTweets((t1, t2) -> t1.getTweetId().compareTo(t2.getTweetId()) * -1);
        Assert.assertEquals(11L, sortedTweets.get(0).getTweetId().longValue());
        Assert.assertEquals(10L, sortedTweets.get(1).getTweetId().longValue());
        Assert.assertEquals(9L, sortedTweets.get(2).getTweetId().longValue());
        Assert.assertEquals(8L, sortedTweets.get(3).getTweetId().longValue());
        Assert.assertEquals(7L, sortedTweets.get(4).getTweetId().longValue());
        Assert.assertEquals(6L, sortedTweets.get(5).getTweetId().longValue());
        Assert.assertEquals(5L, sortedTweets.get(6).getTweetId().longValue());
        Assert.assertEquals(4L, sortedTweets.get(7).getTweetId().longValue());
        Assert.assertEquals(3L, sortedTweets.get(8).getTweetId().longValue());
        Assert.assertEquals(2L, sortedTweets.get(9).getTweetId().longValue());
        Assert.assertEquals(1L, sortedTweets.get(10).getTweetId().longValue());
    }

    @Test
    public void testGetTweetText() throws TweetNotFoundException {
        Assert.assertEquals("Argument with children: who is more famous, Nicki Minaj or Rick Wakeman?", Exercise2.getTweetText(1L));
        Assert.assertEquals("Nintendo of Europe lays off 320 people: bit.ly/1rEoK1j pic.twitter.com/XbN1N9DWtz", Exercise2.getTweetText(8L));
        try {
            Exercise2.getTweetText(23L);
            Assert.fail();
        } catch (TweetNotFoundException e) {
            Assert.assertEquals("Tweet with ID 23 was not found.", e.getMessage());
        }
    }
}
