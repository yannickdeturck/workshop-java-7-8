package be.ordina.workshop.java8.exercises.tweeter;

import be.ordina.workshop.java8.exercises.Exercise3;
import be.ordina.workshop.java8.exercises.tweeter.model.Tweet;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import java.util.List;
import java.util.Map;

@RunWith(JUnit4.class)
public class Exercise3Test {
    @Test
    public void testListTweeters() throws Exception {
        List<String> tweeters = Exercise3.getTweeters();

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
    public void testGetTweetCount() throws Exception {
        Assert.assertEquals(2, Exercise3.getTweetCount("@JeremyClarkson").intValue());
        Assert.assertEquals(3, Exercise3.getTweetCount("@verge").intValue());
        Assert.assertEquals(1, Exercise3.getTweetCount("@Kotaku").intValue());
    }

    @Test
    public void testListUsersWithTweetCount() throws Exception {
        Map<String,Integer> usersWithTweetCount = Exercise3.listUsersWithTweetCount();
        Assert.assertEquals(2, usersWithTweetCount.get("@JeremyClarkson").intValue());
        Assert.assertEquals(3, usersWithTweetCount.get("@verge").intValue());
        Assert.assertEquals(1, usersWithTweetCount.get("@Kotaku").intValue());
    }

    @Test
    public void testGetTopTweet() throws Exception {
        Assert.assertEquals("This is a video of me being ice bucketed. @MrJamesMay @RichardHammond You're next. youtu.be/CU6pB7s7rtg", Exercise3.getTopTweet("@JeremyClarkson").getText());
        Assert.assertEquals("Apple's September 9th event is official. iPhone 6 and iWatch expected theverge.com/e/5842842 pic.twitter.com/7xosFMPwhJ", Exercise3.getTopTweet("@verge").getText());
        Assert.assertEquals("Oculus Rift gestuurde 3D webcam opstelling. #Ordina #ordinabelgium #innovation #oculus instagram.com/p/sPdEjjLwkK/", Exercise3.getTopTweet("@Mr_Jean").getText());
    }

    @Test
    public void getSortedTweets() throws Exception {
        List<Tweet> sortedTweets = Exercise3.getSortedTweets((t1, t2) -> t1.getTweetId().compareTo(t2.getTweetId()));
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
}
