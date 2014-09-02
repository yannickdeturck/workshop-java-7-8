package be.ordina.workshop.java8.exercises.tweeter;

import be.ordina.workshop.java8.exercises.Exercise2;
import org.junit.Assert;
import org.junit.Test;

import java.util.Map;

public class Exercise2Test {
	@Test
	public void testGetTweetCount() throws Exception {
        Map<String,Integer> tweetCount = Exercise2.getTweetCountJeremyClarksonAndBBCTopGear();
        Assert.assertEquals(2, tweetCount.get("@JeremyClarkson").intValue());
		Assert.assertEquals(1, tweetCount.get("@BBC_TopGear").intValue());
	}
}
